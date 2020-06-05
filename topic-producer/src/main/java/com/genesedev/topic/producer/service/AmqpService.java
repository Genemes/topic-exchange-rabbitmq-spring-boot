package com.genesedev.topic.producer.service;

import com.genesedev.topic.producer.domain.TransferenciaQueue;

public interface AmqpService {
    void sendToConsumer(TransferenciaQueue message);
}
