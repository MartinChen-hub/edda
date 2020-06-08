package com.welab.edda.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {

    public static final String TOPIC_QUEUE1 = "topic.queue1";

    public static final String TOPIC_QUEUE2 = "topic.queue2";

    public static final String TOPIC_EXCHANGE = "topic.exchange";

    @Bean
    public Queue topicQueue1(){
        //name/persistent
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2(){
        //name/persistent
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.message");
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
    }
}
