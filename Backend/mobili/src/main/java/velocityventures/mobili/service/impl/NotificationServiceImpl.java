package velocityventures.mobili.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import velocityventures.mobili.dto.request.NotificationRequest;
import velocityventures.mobili.dto.response.NotificationResponse;
import velocityventures.mobili.entity.DriverApplication;
import velocityventures.mobili.entity.Notification;
import velocityventures.mobili.repository.DriverApplicationRepository;
import velocityventures.mobili.repository.NotificationRepository;
import velocityventures.mobili.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepo;

    @Autowired
    private DriverApplicationRepository driverRepo;

    @Override
    public NotificationResponse sendNotification(NotificationRequest request) {

        DriverApplication application = driverRepo.findById(request.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found!"));

        Notification notification = Notification.builder()
                .driverApplication(application)
                .title(request.getTitle())
                .message(request.getMessage())
                .notificationType(request.getNotificationType())
                .isRead(false)
                .createdAt(LocalDateTime.now())
                .build();

        Notification saved = notificationRepo.save(notification);

        return NotificationResponse.builder()
                .notificationId(saved.getNotificationId())
                .applicationId(saved.getDriverApplication().getApplicationId())
                .title(saved.getTitle())
                .message(saved.getMessage())
                .notificationType(saved.getNotificationType())
                .isRead(saved.getIsRead())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    @Override
    public List<NotificationResponse> getAll() {

        List<Notification> overall = notificationRepo.findAll();
        List<NotificationResponse> list = new ArrayList<>();

        for (Notification notification : overall) {

            NotificationResponse response = NotificationResponse.builder()
                    .notificationId(notification.getNotificationId())
                    .applicationId(notification.getDriverApplication().getApplicationId())
                    .title(notification.getTitle())
                    .message(notification.getMessage())
                    .notificationType(notification.getNotificationType())
                    .isRead(notification.getIsRead())
                    .createdAt(notification.getCreatedAt())
                    .build();

            list.add(response);
        }

        return list;
    }

    @Override
    public NotificationResponse getById(Long id) {

        Notification notification = notificationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found!"));

        return NotificationResponse.builder()
                .notificationId(notification.getNotificationId())
                .applicationId(notification.getDriverApplication().getApplicationId())
                .title(notification.getTitle())
                .message(notification.getMessage())
                .notificationType(notification.getNotificationType())
                .isRead(notification.getIsRead())
                .createdAt(notification.getCreatedAt())
                .build();
    }

    @Override
    public List<NotificationResponse> getByApplicationId(Long applicationId) {

        List<Notification> notifications =
                notificationRepo.findByDriverApplicationApplicationid(applicationId);

        List<NotificationResponse> list = new ArrayList<>();

        for (Notification notification : notifications) {

            NotificationResponse response = NotificationResponse.builder()
                    .notificationId(notification.getNotificationId())
                    .applicationId(notification.getDriverApplication().getApplicationId())
                    .title(notification.getTitle())
                    .message(notification.getMessage())
                    .notificationType(notification.getNotificationType())
                    .isRead(notification.getIsRead())
                    .createdAt(notification.getCreatedAt())
                    .build();

            list.add(response);
        }

        return list;
    }

    @Override
    public String markAsRead(Long id) {

        Notification notification = notificationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found!"));

        notification.setIsRead(true);

        notificationRepo.save(notification);

        return "Notification marked as read.";
    }

    @Override
    public String deleteById(Long id) {

        Notification notification = notificationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found!"));

        notificationRepo.delete(notification);

        return "Notification deleted successfully.";
    }
}