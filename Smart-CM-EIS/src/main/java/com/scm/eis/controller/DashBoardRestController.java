package com.scm.eis.controller;

import com.scm.eis.helper.DashBoardHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v")
public class DashBoardRestController {

    @Autowired
    DashBoardHelper dashBoardHelper;

    @GetMapping("/dashboard/solutionStatusCount")
    public ResponseEntity<Object> getSolutionStatusCount() {
        try {
            return new ResponseEntity<>(dashBoardHelper.getSolutionStatusCount(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
