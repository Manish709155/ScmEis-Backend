package com.scm.eis.controller;

import com.scm.eis.helper.TaskAssignHelper;
import com.scm.eis.request.TaskAssignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/rest/api/v/assign")
public class TaskAssignRestBoatController {

    @Autowired
    TaskAssignHelper taskAssignHelper;

    @PostMapping("/manualQuery")
    public ResponseEntity<?> assignManualQueryGeneratedTask(@RequestBody TaskAssignRequest taskAssignRequest){
        try{
            taskAssignHelper.assignManualQueryGeneratedTask(taskAssignRequest);
            return  new ResponseEntity<>("Task has been assigned successfully to respective employee.",HttpStatus.OK);

        }
        catch (RuntimeException r){
            return  new ResponseEntity<>(r.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/chatBoatQuery")
    public ResponseEntity<?> assignChatBoatQueryGeneratedTask(@RequestBody TaskAssignRequest taskAssignRequest){
        try{
            taskAssignHelper.assignChatBoatQueryGeneratedTask(taskAssignRequest);
            return  new ResponseEntity<>("Task has been assigned successfully to respective employee.",HttpStatus.OK);

        }
        catch (RuntimeException r){
            return  new ResponseEntity<>(r.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
