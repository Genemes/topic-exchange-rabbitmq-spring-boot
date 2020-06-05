package com.genesedev.topic.consumer.service;


import com.genesedev.topic.consumer.domain.TransferenciaQueue;

public interface ConsumerService {

    void action(TransferenciaQueue message, String queue);

}