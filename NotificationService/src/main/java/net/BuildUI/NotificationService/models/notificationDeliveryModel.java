package net.BuildUI.NotificationService.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class notificationDeliveryModel {
    private String email;
    private String productName ;
    private double price ;
    private Date predictedDate;
    private String source ;
    private String productUrl;
}
