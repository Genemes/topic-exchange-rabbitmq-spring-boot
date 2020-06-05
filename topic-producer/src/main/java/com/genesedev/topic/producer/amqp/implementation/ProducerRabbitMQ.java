package com.genesedev.topic.producer.amqp.implementation;


import com.genesedev.topic.producer.amqp.AmqpProducer;
import com.genesedev.topic.producer.domain.TransferenciaQueue;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<TransferenciaQueue> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.routing-key.all}")
    private String routingKeyAll;

    @Value("${spring.rabbitmq.request.routing-key.horario}")
    private String routingKeyHorario;

    @Value("${spring.rabbitmq.request.routing-key.valor}")
    private String routingKeyValor;

    @Override
    public void producer(TransferenciaQueue message) {
        try {
            String routingKey = getRoutingKey(message);
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

    private String getRoutingKey(TransferenciaQueue transferencia){
        String retorno = "";
        if(transferencia.getValor() >=1000000){
            retorno = routingKeyValor;
        } else if(transferencia.getHorario().getHour() >= 22 ||
                transferencia.getHorario().getHour() <= 05){
            retorno = routingKeyHorario;
        } else if(transferencia.getHorario().getHour() >= 22 ||
                transferencia.getHorario().getHour() <= 05 &&
                transferencia.getValor() >=1000000
        ){
            retorno = routingKeyAll;
        } else {
            retorno = queue;
        }
        return retorno;
    }

}
