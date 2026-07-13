package velocityventures.mobili.service;

import java.util.List;

import velocityventures.mobili.dto.request.NotificationRequest;
import velocityventures.mobili.dto.response.NotificationResponse;

public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest request);
    List<NotificationResponse> getAll();
    NotificationResponse getById(Long id);
    List<NotificationResponse> getByApplicationId(Long applicationId);
    String markAsRead(Long id);
    String deleteById(Long id);
}
