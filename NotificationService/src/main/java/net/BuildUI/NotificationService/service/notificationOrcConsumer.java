package net.BuildUI.NotificationService.service;

import net.BuildUI.NotificationService.models.notificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class notificationOrcConsumer {

    @Autowired
    private KafkaTemplate<String , notificationModel> kafkaTemplate;

    @Autowired
    private notificationService notificationService;

    @KafkaListener(topics = "product_events", groupId = "notification_group")
    private void consume(notificationModel product){
        notificationService.processData(product);
    }
}
