package info_api.service;

import info_api.bo.Info;

public interface InfoService {
    Info getInfo();

    Info updateInfo(Info info);
}
