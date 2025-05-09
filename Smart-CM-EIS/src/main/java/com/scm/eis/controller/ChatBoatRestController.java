package com.scm.eis.controller;

import com.scm.eis.config.WebSocketEventListener;
import com.scm.eis.constant.EscalationPriority;
import com.scm.eis.constant.MessageType;
import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.User;
import com.scm.eis.exception.ChatBoatQueryException;
import com.scm.eis.request.ChatBoatRequest;
import com.scm.eis.service.ChatBoatService;
import com.scm.eis.service.UserService;
import com.scm.eis.service.UserServiceRegistrationService;
import com.scm.eis.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;

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
    ) throws ChatBoatQueryException {
User user=webSocketEventListener.getChatUser(chatBoatRequest.getValidateConsumerId());
        Optional<ChatBoat> chatBoat  = chatBoatService.findByConsumerIdAndActiveTrueAndSolutionStatus(chatBoatRequest.getValidateConsumerId());

        if (chatBoat.isPresent()) {
            throw new ChatBoatQueryException(chatBoat.get().getSolutionStatus());
        }
        ChatBoat newChatBoat= new ChatBoat();
        newChatBoat.setSolutionStatus(SolutionStatus.CREATED);
        newChatBoat.setEscalationPriority(EscalationPriority.TEAM_WILL_BE_DECIDE);
        newChatBoat.setUserAskedQuery(chatBoatRequest.getUserAskedQuery());
        newChatBoat.setMessageType(MessageType.CHAT);
        newChatBoat.setTicketNumber(CommonUtil.generateTicketNumber());
        newChatBoat.setServiceNumber(CommonUtil.generateServiceNumber());
        newChatBoat.setUser(user);
        chatBoatService.userAskedQueryByChatBoat(newChatBoat);
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