package com.genesedev.topic.consumer.amqp.implementation;

import com.genesedev.topic.consumer.amqp.AmqpConsumer;
import com.genesedev.topic.consumer.domain.TransferenciaQueue;
import com.genesedev.topic.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<TransferenciaQueue> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(TransferenciaQueue message) {
        sendMessage(message, "Queue Principal");
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.fraudes.producer}")
    public void consumerQueueFraudes(TransferenciaQueue message) {
        sendMessage(message, "Queue Fraudes");
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.fraude-horario.producer}")
    public void consumerQueueFraudesHorario(TransferenciaQueue message) {
        sendMessage(message, "Queue Fraudes Horário");
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.fraude-valor.producer}")
    public void consumerQueueFraudesValor(TransferenciaQueue message) {
        sendMessage(message, "Queue Fraudes Valor");
    }

    private void sendMessage(TransferenciaQueue message, String queue){
        try {
            consumerService.action(message, queue);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

}
