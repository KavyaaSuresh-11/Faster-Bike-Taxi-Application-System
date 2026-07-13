package velocityventures.mobili.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import velocityventures.mobili.entity.enums.NotificationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {

    private Long notificationId;

    private Long applicationId;

    private String title;

    private String message;

    private NotificationType notificationType;

    private Boolean isRead;

    private LocalDateTime createdAt;
}