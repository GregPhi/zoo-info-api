package info_api.controller;

import info_api.bo.Info;
import info_api.service.InfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infos")
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/")
    Info getInfos(){
        return this.infoService.getInfo();
    }

    @PutMapping("/")
    Info updateInfo(@RequestBody Info newInfo) {
        return null;
    }
}
