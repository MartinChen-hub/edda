package com.edda.controller;

import com.edda.config.TopicRabbitConfig;
import com.edda.dto.Good;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TopicRabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping(path = "/sendTopicQueue1/{id}")
    public String sendTopicQueue1(@PathVariable("id") String id){
        Good good = new Good();
        good.setId(Integer.parseInt(id));
        good.setName("WeSave");
        good.setPrice(10);
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE,"topic.message", good);
        return "ok1";
    }

    @PostMapping(path = "/sendTopicQueue2/{id}")
    public String sendTopicQueue2(@PathVariable("id") String id){
        Good good = new Good();
        good.setId(Integer.parseInt(id));
        good.setName("Formssi");
        good.setPrice(12);
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE,"topic.second", good);
        return "ok2";
    }
//这种情况触发的是 ConfirmCallback 回调函数。
    @PostMapping(path = "/send-non-existent-exchange")
    public String sendTopicQueueNoExistent(){
        Good good = new Good();
        good.setId(11);
        good.setName("non-existent-exchange");
        good.setPrice(12);
        this.rabbitTemplate.convertAndSend("non-existent-exchange","topic.second", good);
        return "ok2";
    }

    @RabbitListener(queues = TopicRabbitConfig.TOPIC_QUEUE1)
    public void receiveTopicQueue1(Good good){
        log.info("1接收到的对象：{}", good);
    }

    @RabbitListener(queues = TopicRabbitConfig.TOPIC_QUEUE2)
    public void receiveTopicQueue2(Good good){
        log.info("2接收到的对象：{}", good);
    }
}
