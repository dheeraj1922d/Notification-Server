package net.BuildUI.NotificationService.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//model for data to be received from the ML server
@Getter
@Setter
public class notificationModel {
    private String productName ;
    private double price ;
    private Date predictedDate;
    private String source ;
    private String productUrl;

}
