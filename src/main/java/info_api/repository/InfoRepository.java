package info_api.repository;

import info_api.bo.Info;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository {

    Info getInfo();

    Info updateInfo(Info info);
}
