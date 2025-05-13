package com.scm.eis.helper;

import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.response.NotificationResponse;
import com.scm.eis.service.ChatBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChatBoatHelper {

    @Autowired
    ChatBoatService chatBoatService;

    public NotificationResponse getNotification(String consumerId){
        NotificationResponse notificationResponse = new NotificationResponse();
        Optional<ChatBoat> chatBoat= chatBoatService.findByActiveTrueAndNotificationReadTrueAndUserConsumerId(consumerId);
        notificationResponse.setNotificationRead(chatBoat.get().getNotificationRead());
        notificationResponse.setId(chatBoat.get().getId());
        notificationResponse.setNotificationMessage(chatBoat.get().getSolutionStatus());
        return notificationResponse;
    }
}
