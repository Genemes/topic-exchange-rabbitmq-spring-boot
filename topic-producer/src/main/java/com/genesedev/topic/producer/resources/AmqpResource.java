package com.genesedev.topic.producer.resources;

import com.genesedev.topic.producer.domain.TransferenciaQueue;
import com.genesedev.topic.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpResource {

    @Autowired
    private AmqpService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/topic")
    public void sendToConsumer(@RequestBody TransferenciaQueue message) {
        service.sendToConsumer(message);
    }

}
