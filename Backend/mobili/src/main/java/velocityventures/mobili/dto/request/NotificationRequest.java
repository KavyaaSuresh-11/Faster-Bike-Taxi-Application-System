package velocityventures.mobili.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import velocityventures.mobili.entity.enums.NotificationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

    private Long applicationId;

    private String title;

    private String message;

    private NotificationType notificationType;

}