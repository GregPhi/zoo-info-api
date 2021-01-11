package info_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import info_api.bo.Info;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class InfoRepositoryImpl implements InfoRepository{
    private Info info;

    public InfoRepositoryImpl() {
        try {
            var infoStream = new ClassPathResource("infos.json").getInputStream();
            var objectMapper = new ObjectMapper();
            this.info = objectMapper.readValue(infoStream, Info.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Info getInfo() {
        return this.info;
    }

    @Override
    public Info updateInfo(Info info) {
        return null;
    }
}
