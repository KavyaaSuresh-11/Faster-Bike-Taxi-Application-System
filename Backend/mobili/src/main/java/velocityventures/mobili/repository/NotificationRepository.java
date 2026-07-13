package velocityventures.mobili.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import velocityventures.mobili.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByDriverApplicationApplicationid(Long applicationId);

}
