package net.BuildUI.NotificationService.service;

import net.BuildUI.NotificationService.models.notificationDeliveryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class notificationOrcProducer {
    @Autowired
    private KafkaTemplate<String , notificationDeliveryModel> kafkaTemplate;

    void sendNotification(notificationDeliveryModel notification){
        kafkaTemplate.send("notification-topic" , notification.getEmail() , notification);
        System.out.println("Notification sent to Kafka topic : " + " -> " + notification);
    }
}
