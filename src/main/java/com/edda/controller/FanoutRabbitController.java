//package com.edda.controller;
//
//import com.edda.config.FanoutRabbitConfig;
//import com.edda.config.TopicRabbitConfig;
//import com.edda.dto.Good;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class FanoutRabbitController {
//
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public FanoutRabbitController(RabbitTemplate rabbitTemplate){
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @PostMapping(path = "/sendFanoutQueue1/{id}")
//    public String sendFanoutQueue1(@PathVariable("id") String id){
//        Good good = new Good();
//        good.setId(Integer.parseInt(id));
//        good.setName("WeSave");
//        good.setPrice(10);
//        this.rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE, good);
//        return "ok1";
//    }
//
//    @PostMapping(path = "/sendFanoutQueue2/{id}")
//    public String sendFanoutQueue2(@PathVariable("id") String id){
//        Good good = new Good();
//        good.setId(Integer.parseInt(id));
//        good.setName("Formssi");
//        good.setPrice(12);
//        this.rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE, good);
//        return "ok2";
//    }
//
//    @RabbitListener(queues = TopicRabbitConfig.TOPIC_QUEUE1)
//    public void receiveTopicQueue1(Good good){
//        log.info("1接收到的对象：{}", good);
//    }
//
//    @RabbitListener(queues = TopicRabbitConfig.TOPIC_QUEUE2)
//    public void receiveTopicQueue2(Good good){
//        log.info("2接收到的对象：{}", good);
//    }
//}
