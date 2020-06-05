package com.genesedev.topic.consumer.service.implementation;

import com.genesedev.topic.consumer.domain.TransferenciaQueue;
import com.genesedev.topic.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(TransferenciaQueue message, String queue) {
        if(message.getValor() <= 0){
            throw new AmqpRejectAndDontRequeueException("valor insuficiente");
        }
        // Verificar agência válida

        System.out.println(queue + " - "+ message.toString());
    }
}
