package net.BuildUI.NotificationService.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//this model is for subscriber database
@Getter
@Setter
@Document(collection = "subcribers")
public class subscriberModel {
    @Id
    private String product;
    private List<String> subscriberEmails;
}
