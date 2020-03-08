package com.transfar.sdc.demo.controller;

import com.transfar.sdc.demo.server.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private KafkaSender kafkaSender;


    @RequestMapping(value = "/getAssetElements/{message}", method = RequestMethod.GET)
    public boolean send(@PathVariable String message){
        kafkaSender.send(message);
        return true;
    }
}
