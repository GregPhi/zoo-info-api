package info_api.controller;

import info_api.bo.Info;
import info_api.service.InfoService;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class InfoControllerTest {

    @Test
    void getInfos_shouldCallTheService(){
        var service = mock(InfoService.class);
        var controller = new InfoController(service);

        var infoTest = new Info();
        when(service.getInfo()).thenReturn(infoTest);

        var infos = controller.getInfos();
        assertEquals("Parc zoologique de Lille", infos.getName());

        verify(service).getInfo();
    }


    @Test
    void infoController_shouldBeAnnotated(){
        var controllerAnnotation =
                InfoController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        var requestMappingAnnotation =
                InfoController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/infos"}, requestMappingAnnotation.value());
    }

    @Test
    void getInfos_shouldBeAnnotated() throws NoSuchMethodException {
        var getInfos =
                InfoController.class.getDeclaredMethod("getInfos");
        var getMapping = getInfos.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }

    @Test
    void updateInfo_shouldBeAnnotated() throws NoSuchMethodException {
        var updateInfo =
                InfoController.class.getDeclaredMethod("updateInfo", Info.class);
        var putMapping = updateInfo.getAnnotation(PutMapping.class);

        var requestBodyAnnotation = updateInfo.getParameters()[0].getAnnotation(RequestBody.class);

        assertNotNull(putMapping);
        assertArrayEquals(new String[]{"/"}, putMapping.path());

        assertNotNull(requestBodyAnnotation);
    }
}
