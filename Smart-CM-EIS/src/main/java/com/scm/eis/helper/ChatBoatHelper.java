package com.scm.eis.helper;

import com.scm.eis.entity.ChatBoat;
import com.scm.eis.request.ChatBoatRequest;
import com.scm.eis.service.ChatBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatBoatHelper {

    @Autowired
    ChatBoatService chatBoatService;

    public ChatBoat userAskedQuery(ChatBoatRequest chatBoatRequest) {
        ChatBoat chatBoat= new ChatBoat();
        chatBoat.setSolutionStatus(chatBoatRequest.getSolutionStatus());
        chatBoat.setEscalationPriority(chatBoatRequest.getEscalationPriority());
        chatBoat.setUserAskedQuery(chatBoatRequest.getUserAskedQuery());
        chatBoatService.userAskedQueryByChatBoat(chatBoat);
        return chatBoat;
    }
}
