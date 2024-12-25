package net.BuildUI.NotificationService.service;

import net.BuildUI.NotificationService.models.notificationDeliveryModel;
import net.BuildUI.NotificationService.models.notificationModel;
import net.BuildUI.NotificationService.models.subscriberModel;
import net.BuildUI.NotificationService.repository.subscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class notificationService {

    @Autowired
    private subscriberRepo subscriberRepo;

    @Autowired
    private notificationOrcProducer producer;

    public void processData(notificationModel notification) {
        // Retrieve the subscriber from the repository
        Optional<subscriberModel> subscriber = subscriberRepo.findById(notification.getProductName());

        if (subscriber.isPresent()) {
            // For each email in the subscriber's email list, send a notification
            subscriber.get().getSubscriberEmails().forEach(email -> {
                notificationDeliveryModel message = createNotificationModel(email, notification);
                producer.sendNotification(message);
            });
        } else {
            throw new RuntimeException("No subscriber found for product: " + notification.getProductName());
        }
    }

    private notificationDeliveryModel createNotificationModel(String email, notificationModel notification) {
        notificationDeliveryModel res = new notificationDeliveryModel();
        res.setEmail(email);
        res.setProductName(notification.getProductName());
        res.setPrice(notification.getPrice());
        res.setPredictedDate(notification.getPredictedDate());
        res.setSource(notification.getSource());
        res.setProductUrl(notification.getProductUrl());
        return res;
    }
}
