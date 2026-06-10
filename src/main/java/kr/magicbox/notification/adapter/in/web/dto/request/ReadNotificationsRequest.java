package kr.magicbox.notification.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ReadNotificationsRequest(
        @NotEmpty List<Long> notificationIds
) {
}
