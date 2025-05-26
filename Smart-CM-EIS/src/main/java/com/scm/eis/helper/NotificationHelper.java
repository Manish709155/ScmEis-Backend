package com.scm.eis.helper;

import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.response.NotificationChatBoatResponse;
import com.scm.eis.response.NotificationListResponse;
import com.scm.eis.response.NotificationManualQueryResponse;
import com.scm.eis.service.ChatBoatService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class NotificationHelper {

    @Autowired
    ChatBoatService chatBoatService;

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    public List<NotificationListResponse> getNotificationListResponse() {
        List<NotificationListResponse> responses = new ArrayList<>();
        chatBoatService.findUnreadNotifications().stream()
                .map(ChatBoat::getUserAskedQuery)
                .filter(Objects::nonNull)
                .map(msg ->
                        NotificationListResponse.builder()
                                .notificationChatBoatResponse(
                                        NotificationChatBoatResponse.builder()
                                                .message(msg)
                                                .build())
                                .build()
                )
                .forEach(responses::add);
        userServiceRegistrationService.findUnreadNotifications().stream()
                .map(UserServiceRegistration::getUserAskedQuery)
                .filter(Objects::nonNull)
                .map(msg ->
                        NotificationListResponse.builder()
                                .notificationManualQueryResponse(
                                        NotificationManualQueryResponse.builder()
                                                .message(msg)
                                                .build())
                                .build()
                )
                .forEach(responses::add);

        return responses;
    }



}
