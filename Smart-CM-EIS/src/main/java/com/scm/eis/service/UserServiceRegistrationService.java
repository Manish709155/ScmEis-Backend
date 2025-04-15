package com.scm.eis.service;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.UserServiceRegistration;

import java.util.List;
import java.util.Optional;

public interface UserServiceRegistrationService {

    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistration userServiceRegistration);

    public Optional<UserServiceRegistration> findByTicketNumberAndActiveAndInSolutionStatusInList(String ticketNumber, boolean active, List<SolutionStatus> solutionStatuses);

    public UserServiceRegistration findByTicketNumberAndActiveTrue(String ticketNumber);
}

