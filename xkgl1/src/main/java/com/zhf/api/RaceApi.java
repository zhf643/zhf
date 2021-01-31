package com.zhf.api;

import com.zhf.application.RaceInputDTO;
import com.zhf.application.service.IRaceService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/races")
public class RaceApi {
    private IRaceService service;

    public Object create(@RequestBody RaceInputDTO model){
        return service.create(model);
    }
}
