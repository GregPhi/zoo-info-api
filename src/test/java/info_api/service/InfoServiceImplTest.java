package info_api.service;

import info_api.repository.InfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InfoServiceImplTest {
    @Test
    void applicationContext_shouldLoadInfoService(){
        var context = new AnnotationConfigApplicationContext("info_api");
        var serviceByName = context.getBean("infoServiceImpl");
        var serviceByClass = context.getBean(InfoService.class);

        assertEquals(serviceByName, serviceByClass);
        assertNotNull(serviceByName);
        assertNotNull(serviceByClass);
    }


    @Test
    void infoRepository_shouldBeAutowired_withSpring(){
        var context = new AnnotationConfigApplicationContext("info_api");
        var service = context.getBean(InfoServiceImpl.class);
        assertNotNull(service.infoRepository);
    }

    @Test
    void infoRepository_shouldBeCalled_getInfo(){
        var infoRepository = mock(InfoRepository.class);
        var infoService = new InfoServiceImpl(infoRepository);

        infoService.getInfo();

        verify(infoRepository).getInfo();
    }
}

