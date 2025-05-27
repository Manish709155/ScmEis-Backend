package com.scm.eis.controller;

import com.scm.eis.helper.ComplainHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/complain")
public class ComplainRestController {

    @Autowired
    ComplainHelper complainHelper;

    @GetMapping("/list")
    public ResponseEntity<Object> getNotificationsManualAndChatBoat(){
        try {
            return  new ResponseEntity<>( complainHelper.getComplainList(), HttpStatus.OK);

        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
