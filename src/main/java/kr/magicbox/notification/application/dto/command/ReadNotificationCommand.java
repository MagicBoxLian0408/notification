package kr.magicbox.notification.application.dto.command;

public record ReadNotificationCommand(
        Long notificationId,
        Long userId
) {
    public static ReadNotificationCommand of(Long notificationId, Long userId) {
        return new ReadNotificationCommand(notificationId, userId);
    }
}
