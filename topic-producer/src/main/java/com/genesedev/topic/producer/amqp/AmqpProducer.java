package com.genesedev.topic.producer.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
