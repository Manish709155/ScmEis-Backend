package com.scm.eis.controller;

import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.helper.ChatBoatHelper;
import com.scm.eis.helper.UserServiceRegistrationHelper;
import com.scm.eis.request.NotificationRequest;
import com.scm.eis.service.ChatBoatService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationRestController {

    @Autowired
    UserServiceRegistrationHelper userServiceRegistrationHelper;

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;


    @Autowired
    ChatBoatService chatBoatService;

    @Autowired
    ChatBoatHelper chatBoatHelper;

    @GetMapping("/manualQuery/{consumerId}")
    public ResponseEntity<Object> getManualQueryNotification(@PathVariable("consumerId") String consumerId){
        try {
            return  new ResponseEntity<>( userServiceRegistrationHelper.getNotification(consumerId), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/chatBoatQuery/{consumerId}")
    public ResponseEntity<Object> getChatQueryNotification(@PathVariable("consumerId") String consumerId){
        try {
            return  new ResponseEntity<>( chatBoatHelper.getNotification(consumerId), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/manualQueryRead")
    public void readManualQueryNotification(@RequestBody NotificationRequest notificationRequest){
          UserServiceRegistration userServiceRegistration= userServiceRegistrationService.findByNotificationReadActiveTrueAndConsumerId(notificationRequest.getConsumerId()).get();
          userServiceRegistration.setNotificationRead(notificationRequest.getSendNotificationFlagAfterReadingTheNotification());
            userServiceRegistrationService.createUserServiceRegistration(userServiceRegistration);
    }


    @PostMapping("/ChatBoatQueryRead")
    public void readChatBoatQueryNotification(@RequestBody NotificationRequest notificationRequest){
            ChatBoat chatBoat= chatBoatService.findByActiveTrueAndNotificationReadTrueAndUserConsumerId(notificationRequest.getConsumerId()).get();
            chatBoat.setNotificationRead(notificationRequest.getSendNotificationFlagAfterReadingTheNotification());
            chatBoatService.userAskedQueryByChatBoat(chatBoat);
    }
}
