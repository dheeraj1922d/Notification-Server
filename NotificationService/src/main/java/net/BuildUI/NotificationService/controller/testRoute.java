package net.BuildUI.NotificationService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.BuildUI.NotificationService.models.notificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Component
@RestController
@RequestMapping("/test")
public class testRoute {

    @Autowired
    private KafkaTemplate<String , notificationModel> kafkaTemplate;

    @PostMapping
    private String sendMessage(@RequestBody notificationModel notification){
        try{
            kafkaTemplate.send("product_events" , notification.getProductName() , notification);
            return "message successfully send to kafka";
        }catch (Exception e){
            return "error while sending message to kafka from ML server" + e.getMessage();
        }
    }
}
