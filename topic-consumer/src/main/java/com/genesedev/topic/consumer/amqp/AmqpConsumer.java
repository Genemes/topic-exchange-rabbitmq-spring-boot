package com.genesedev.topic.consumer.amqp;

public interface AmqpConsumer<T> {
    void consumer(T t);
    void consumerQueueFraudes(T t);
    void consumerQueueFraudesHorario(T t);
    void consumerQueueFraudesValor(T t);
}
