package info_api.controller;

import info_api.bo.Info;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InfoControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InfoController controller;

    @Test
    void infoController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getInfos_ShouldReturnInfo() {
        var infos = this.restTemplate.getForEntity("http://localhost:" + port + "/infos/", Info.class);
        var info = infos.getBody();
        assertNotNull(info);
        Assert.assertEquals("Parc zoologique de Lille", info.getName());
    }
}
