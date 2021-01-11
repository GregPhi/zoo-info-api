package info_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InfoRepositoryImplTest {

    private final InfoRepositoryImpl repository = new InfoRepositoryImpl();

    @Test
    void getInfo_shouldReturnInfo(){
        var info = repository.getInfo();
        assertNotNull(info);
        assertEquals("Parc zoologique de Lille", info.getName());
    }

    @Test
    void applicationContext_shouldLoadInfoRepository(){

        var context = new AnnotationConfigApplicationContext("info_api.repository");
        var repoByName = context.getBean("infoRepositoryImpl");
        var repoByClass = context.getBean(InfoRepository.class);

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }
}
