package com.scm.eis.controller;

import com.scm.eis.request.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class ChatBoatLiveRestController {

    @Autowired
    ChatBoatRestController chatBoatRestController;

    @PostMapping("/sendMessage")
    public ResponseEntity<Object> userLogIn(@RequestBody ChatMessage chatMessage){
        try {
            return  new ResponseEntity<>(chatBoatRestController.sendMessage(chatMessage), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
