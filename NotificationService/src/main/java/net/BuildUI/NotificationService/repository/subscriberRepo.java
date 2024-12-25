package net.BuildUI.NotificationService.repository;

import net.BuildUI.NotificationService.models.subscriberModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface subscriberRepo extends MongoRepository<subscriberModel, String> {
}
