package com.genesedev.topic.producer.service.implementation;

import com.genesedev.topic.producer.amqp.AmqpProducer;
import com.genesedev.topic.producer.domain.TransferenciaQueue;
import com.genesedev.topic.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<TransferenciaQueue> amqp;

    @Override
    public void sendToConsumer(TransferenciaQueue message) {
        amqp.producer(message);
    }
}
