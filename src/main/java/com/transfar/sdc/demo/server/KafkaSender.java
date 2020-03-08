package com.transfar.sdc.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //发送消息方法
    public void send(String data) {

        log.info("+++++++++++++++++++++  message = {}");
        kafkaTemplate.send("test1", data);
    }
}
