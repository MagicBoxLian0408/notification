package kr.magicbox.notification.adapter.in.web.controller;

import kr.magicbox.notification.adapter.in.web.dto.request.RegisterFcmTokenRequest;
import kr.magicbox.notification.application.dto.command.ReadNotificationCommand;
import kr.magicbox.notification.application.dto.command.RegisterFcmTokenCommand;
import kr.magicbox.notification.application.port.in.ReadNotificationUseCase;
import kr.magicbox.notification.application.port.in.RegisterFcmTokenUseCase;
import kr.magicbox.notification.domain.vo.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationCommandController {

    private final RegisterFcmTokenUseCase registerFcmTokenUseCase;
    private final ReadNotificationUseCase readNotificationUseCase;

    @PostMapping("/fcm-token")
    public ResponseEntity<Void> registerFcmToken(
            @AuthenticationPrincipal UserId userId,
            @RequestBody RegisterFcmTokenRequest request) {
        registerFcmTokenUseCase.register(RegisterFcmTokenCommand.of(userId.value(), request.token()));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<Void> readNotification(
            @AuthenticationPrincipal UserId userId,
            @PathVariable Long notificationId) {
        readNotificationUseCase.read(ReadNotificationCommand.of(notificationId, userId.value()));
        return ResponseEntity.noContent().build();
    }
}
