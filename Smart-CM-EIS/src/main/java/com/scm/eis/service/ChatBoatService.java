package com.scm.eis.service;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.request.NotificationRequest;

import java.util.List;
import java.util.Optional;

public interface ChatBoatService {

    public void userAskedQueryByChatBoat(ChatBoat chatBoat);

    ChatBoat findByUserIdAndActiveTrue(Long userId);

    Optional<ChatBoat> findByConsumerIdAndActiveTrueAndSolutionStatus(String consumerId);

    Optional<ChatBoat> findByActiveTrueAndNotificationReadTrueAndUserConsumerId(String consumerId);

    List<ChatBoat> findUnreadNotifications();

    List<ChatBoat> getChatBoatComplainListResponse();
}
