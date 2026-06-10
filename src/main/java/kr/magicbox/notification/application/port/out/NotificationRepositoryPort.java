package kr.magicbox.notification.application.port.out;

import kr.magicbox.notification.domain.aggregate.Notification;

import java.util.List;

public interface NotificationRepositoryPort {
    void save(Notification notification);
    void update(Notification notification);
    Notification findByIdAndUserId(Long notificationId, Long userId);
    List<Notification> findAllByUserId(Long userId);
}
