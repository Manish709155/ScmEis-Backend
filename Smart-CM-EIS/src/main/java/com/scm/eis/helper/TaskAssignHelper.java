package com.scm.eis.helper;

import com.scm.eis.constant.RoleTypeEnum;
import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.User;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.request.TaskAssignRequest;
import com.scm.eis.service.ChatBoatService;
import com.scm.eis.service.EmployeeService;
import com.scm.eis.service.UserService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskAssignHelper {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    UserService userService;

    @Autowired
    ChatBoatService chatBoatService;

    public void assignManualQueryGeneratedTask(TaskAssignRequest taskAssignRequest){
     Employee employee= employeeService.findBySapCardAndActiveTrue(taskAssignRequest.getEmployeeSapId());
     UserServiceRegistration userSerReg= userServiceRegistrationService.findByTicketNumberAndActiveTrue(taskAssignRequest.getTicketNumber());
     Optional<User> user= userService.findUserById(userSerReg.getUser().getId());
     if (user.get().getRoleType()== RoleTypeEnum.ADMIN){
         userSerReg.setEmployee(employee);
     }
     else {
        throw new RuntimeException("You have not access to assign the task,only admin can do.");
     }
     userServiceRegistrationService.createUserServiceRegistration(userSerReg);

    }

    public void assignChatBoatQueryGeneratedTask(TaskAssignRequest taskAssignRequest){
        Employee employee= employeeService.findBySapCardAndActiveTrue(taskAssignRequest.getEmployeeSapId());
        ChatBoat chatBoat= chatBoatService.findByTicketNumberAndActiveTrue(taskAssignRequest.getTicketNumber());
        Optional<User> user= userService.findUserById(chatBoat.getUser().getId());
        if (user.get().getRoleType()== RoleTypeEnum.ADMIN){
            chatBoat.setEmployee(employee);
        }
        else {
            throw new RuntimeException("You have not access to assign the task,only admin can do.");
        }
        chatBoatService.userAskedQueryByChatBoat(chatBoat);

    }
}
