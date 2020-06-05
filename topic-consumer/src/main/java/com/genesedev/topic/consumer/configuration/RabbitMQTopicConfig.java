package com.genesedev.topic.consumer.configuration;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String routingKey;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.dead-letter.producer}")
    private String deadLetter;

    @Value("${spring.rabbitmq.request.parking-lot.producer}")
    private String parkingLot;

    @Value("${spring.rabbitmq.request.fraudes.producer}")
    private String fraudes;

    @Value("${spring.rabbitmq.request.fraude-horario.producer}")
    private String fraudeHorario;

    @Value("${spring.rabbitmq.request.fraude-valor.producer}")
    private String fraudeValor;

    @Value("${spring.rabbitmq.request.routing-key.all}")
    private String routingKeyAll;

    @Value("${spring.rabbitmq.request.routing-key.horario}")
    private String routingKeyHorario;

    @Value("${spring.rabbitmq.request.routing-key.valor}")
    private String routingKeyValor;

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Queue queue() {
        return  QueueBuilder.durable(routingKey)
                .deadLetterExchange(exchange)
                .deadLetterRoutingKey(deadLetter)
                .build();
    }

    @Bean
    Queue deadLetter() {
        return QueueBuilder.durable(deadLetter)
                .deadLetterExchange(exchange)
                .deadLetterRoutingKey(routingKey)
                .build();
    }

    @Bean
    Queue parkingLot() {
        return new Queue(parkingLot);
    }
    @Bean
    Queue fraudes() {
        return new Queue(fraudes);
    }
    @Bean
    Queue fraudeHorario() {
        return new Queue(fraudeHorario);
    }
    @Bean
    Queue fraudeValor() {
        return new Queue(fraudeValor);
    }

    @Bean
    public Binding bindingQueue() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(routingKey);
    }

    @Bean
    public Binding bindingDeadLetter() {
        return BindingBuilder.bind(deadLetter()).to(topicExchange()).with(deadLetter);
    }

    @Bean
    public Binding bindingParkingLot() {
        return BindingBuilder.bind(parkingLot()).to(topicExchange()).with(parkingLot);
    }

    @Bean
    Binding bindingRoutingKeyAll() {
        return BindingBuilder.bind(fraudes()).to(topicExchange()).with(routingKeyAll);
    }

    @Bean
    Binding bindingRoutingKeyHorario() {
        return BindingBuilder.bind(fraudeHorario()).to(topicExchange()).with(routingKeyHorario);
    }

    @Bean
    Binding bindingRoutingKeyValor() {
        return BindingBuilder.bind(fraudeValor()).to(topicExchange()).with(routingKeyValor);
    }

}
