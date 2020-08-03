//package com.edda.controller;
//
//import com.edda.dto.Good;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class DirectRabbitController {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @PostMapping(path = "/sendDirect")
//    public void sendDirectQueue(){
//        Good good = new Good();
//        good.setId(1);
//        good.setName("WeSave");
//        good.setPrice(10);
//        this.rabbitTemplate.convertAndSend("direct.queue", good);
//    }
//
//    @RabbitListener(queues = "direct.queue")
//    public void receiveDirectQueue(Good good){
//        log.info("接收到的对象：{}", good);
//    }
//
//}
