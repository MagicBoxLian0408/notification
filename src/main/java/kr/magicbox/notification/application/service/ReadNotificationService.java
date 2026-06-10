package kr.magicbox.notification.application.service;

import kr.magicbox.notification.application.dto.command.ReadNotificationCommand;
import kr.magicbox.notification.application.port.in.ReadNotificationUseCase;
import kr.magicbox.notification.application.port.out.NotificationRepositoryPort;
import kr.magicbox.notification.domain.aggregate.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReadNotificationService implements ReadNotificationUseCase {

    private final NotificationRepositoryPort notificationRepositoryPort;

    @Transactional
    @Override
    public void read(ReadNotificationCommand command) {
        Notification notification = notificationRepositoryPort.findByIdAndUserId(
                command.notificationId(), command.userId());
        notification.markRead();
        notificationRepositoryPort.update(notification);
    }
}
