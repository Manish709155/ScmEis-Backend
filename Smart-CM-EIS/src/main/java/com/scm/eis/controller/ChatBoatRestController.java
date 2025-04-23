package com.scm.eis.controller;

import com.scm.eis.config.WebSocketEventListener;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.request.ChatMessage;
import com.scm.eis.service.UserService;
import com.scm.eis.service.UserServiceRegistrationService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.EventListener;
import java.util.Objects;

@Controller
@Slf4j
public class ChatBoatRestController {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    UserService userService;

    @Autowired
    WebSocketEventListener webSocketEventListener;


    @MessageMapping("/register.query")
    @SendTo("/topic/private")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        UserServiceRegistration userServiceRegistration = new UserServiceRegistration();
        userServiceRegistration.setQueryInvalidReason(chatMessage.getAskQuery());
        userServiceRegistrationService.createUserServiceRegistration(userServiceRegistration);
        chatUser(chatMessage);
        return chatMessage(chatMessage,chatMessage.getValidateConsumerId());
    }

    @MessageMapping("/chatUser")
    @SendTo("/topic/private")
    public void chatUser(
            @Payload ChatMessage chatMessage
    ) {
        log.info("User Message: {}", chatMessage.getAskQuery());
    }
    public ChatMessage chatMessage(ChatMessage chatMessage,String consumerId) {
     webSocketEventListener.handleWebSocketDisconnectListener(consumerId);
        return chatMessage;
    }



}