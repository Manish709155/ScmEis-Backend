package com.scm.eis.helper;

import com.scm.eis.entity.ChatBoat;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.response.ChatBoatComplainListResponse;
import com.scm.eis.response.ComplainListResponse;
import com.scm.eis.response.ManualComplaintListResponse;
import com.scm.eis.service.ChatBoatService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ComplainHelper {

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    @Autowired
    ChatBoatService chatBoatService;

    public List<ComplainListResponse> getComplainList() {
        List<UserServiceRegistration> usrSerRegs = userServiceRegistrationService.getManualComplaintListResponse();
        List<ChatBoat> chatBoats = chatBoatService.getChatBoatComplainListResponse();

        List<ComplainListResponse> manualResponses = usrSerRegs.stream()
                .map(user -> ComplainListResponse.builder()
                        .manualComplaintListResponse(
                                ManualComplaintListResponse.builder()
                                        .id(user.getId())
                                        .nonTechSolutionsTypes(user.getNonTechSolutionsTypes())
                                        .techSolutionsTypes(user.getTechSolutionsTypes())
                                        .ticketNumber(user.getTicketNumber())
                                        .serviceNumber(user.getServiceNumber())
                                        .solutionStatus(user.getSolutionStatus())
                                        .language(user.getLanguage())
                                        .escalationPriority(user.getEscalationPriority())
                                        .queryUnder(user.getQueryUnder())
                                        .employeeLevel(user.getEmployeeLevel())
                                        .userAskedQuery(user.getUserAskedQuery())
                                        .active(user.getActive())
                                        .createdOn(user.getCreatedOn())
                                        .build())
                        .build())
                .toList();

        List<ComplainListResponse> chatBotResponses = chatBoats.stream()
                .map(chat -> ComplainListResponse.builder()
                        .chatBoatComplainListResponse(
                                ChatBoatComplainListResponse.builder()
                                        .id(chat.getId())
                                        .ticketNumber(chat.getTicketNumber())
                                        .serviceNumber(chat.getServiceNumber())
                                        .solutionStatus(chat.getSolutionStatus())
                                        .escalationPriority(chat.getEscalationPriority())
                                        .queryUnder(chat.getQueryUnder())
                                        .userAskedQuery(chat.getUserAskedQuery())
                                        .active(chat.getActive())
                                        .createdOn(chat.getCreatedOn())
                                        .build())
                        .build())
                .toList();

        return Stream.concat(manualResponses.stream(), chatBotResponses.stream())
                .toList();
    }


}
