package info_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InfoApi {

    public static void main(String... args){
        SpringApplication.run(InfoApi.class,args);
        System.out.println("=================================================");
        System.out.println("        -> http://localhost:8005/infos/");
        System.out.println("=================================================");
    }
}
