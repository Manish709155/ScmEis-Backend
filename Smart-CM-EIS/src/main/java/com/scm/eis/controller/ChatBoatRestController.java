package com.scm.eis.controller;

import com.scm.eis.config.WebSocketEventListener;
import com.scm.eis.constant.EscalationPriority;
import com.scm.eis.constant.MessageType;
import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.User;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.request.ChatBoatRequest;

import com.scm.eis.service.ChatBoatService;
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

import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
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

    @Autowired
    ChatBoatService chatBoatService;



    @MessageMapping("/register.query")
    @SendTo("/topic/private")
    public ChatBoatRequest sendMessage(
            @Payload ChatBoatRequest chatBoatRequest
    ) {
User user=webSocketEventListener.getChatUser(chatBoatRequest.getValidateConsumerId());
        ChatBoat chatBoat= new ChatBoat();
        chatBoat.setSolutionStatus(SolutionStatus.CREATED);
        chatBoat.setEscalationPriority(EscalationPriority.TEAM_WILL_BE_DECIDE);
        chatBoat.setUserAskedQuery(chatBoatRequest.getUserAskedQuery());
        chatBoat.setMessageType(MessageType.CHAT);
        chatBoat.setUser(user);
        chatBoatService.userAskedQueryByChatBoat(chatBoat);
        chatUser(chatBoatRequest);
        return chatMessage(chatBoatRequest,chatBoatRequest.getValidateConsumerId());
    }

    @MessageMapping("/chatUser")
    @SendTo("/topic/private")
    public void chatUser(
            @Payload ChatBoatRequest chatBoatRequest
    ) {
        log.info("User Message: {}", chatBoatRequest.getUserAskedQuery());
    }
    public ChatBoatRequest chatMessage(ChatBoatRequest chatBoatRequest,String consumerId) {
     webSocketEventListener.handleWebSocketDisconnectListener(consumerId);
        return chatBoatRequest;
    }



}