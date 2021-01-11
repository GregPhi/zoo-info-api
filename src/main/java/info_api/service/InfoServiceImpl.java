package info_api.service;

import info_api.bo.Info;
import info_api.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService{

    public final InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }


    @Override
    public Info getInfo() {
        return this.infoRepository.getInfo();
    }

    @Override
    public Info updateInfo(Info info) {
        return this.infoRepository.updateInfo(info);
    }
}
