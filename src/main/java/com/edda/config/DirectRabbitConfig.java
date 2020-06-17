package com.edda.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class DirectRabbitConfig {

    public static final String DIRECT_QUEUE = "direct.queue";

    @Bean
    public Queue directQueue(){
        //name/persistent
        return new Queue(DIRECT_QUEUE);
    }
}
