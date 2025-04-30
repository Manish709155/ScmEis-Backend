package com.scm.eis.config;

import com.scm.eis.constant.MessageType;
import com.scm.eis.entity.User;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.request.ChatBoatRequest;
import com.scm.eis.service.UserService;
import com.scm.eis.service.UserServiceRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    @Autowired
    UserService userService;

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @EventListener
    public void handleWebSocketDisconnectListener(String consumerId) {
        User user = getChatUser(consumerId);
        if (user != null) {
            StringBuilder fullNameBuilder = new StringBuilder();
            fullNameBuilder.append(user.getFirstName());
            if (user.getMiddleName() != null && !user.getMiddleName().isBlank()) {
                fullNameBuilder.append(" ").append(user.getMiddleName());
            }
            fullNameBuilder.append(" ").append(user.getLastName());
            String userName = fullNameBuilder.toString();
            log.info("User connected: {}", userName);
            var chatBoatRequest = ChatBoatRequest.builder()
                    .type(MessageType.CHAT)
                    .validateConsumerId(userName)
                    .build();
            messagingTemplate.convertAndSend("/topic/private", chatBoatRequest);
        } else {
            log.warn("No user found for consumerId: {}", consumerId);
        }
        UserServiceRegistration userRegistration = new UserServiceRegistration();
        userRegistration.setUser(user);
        userServiceRegistrationService.createUserServiceRegistration(userRegistration);
    }

    public User getChatUser(String consumerId) {
        return userService.findByActiveTrueAndConsumerId(consumerId);
    }
}
