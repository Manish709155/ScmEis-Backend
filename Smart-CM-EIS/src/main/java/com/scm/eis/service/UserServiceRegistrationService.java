package com.scm.eis.service;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.UserServiceRegistration;

import java.util.List;
import java.util.Optional;

public interface UserServiceRegistrationService {

    UserServiceRegistration createUserServiceRegistration(UserServiceRegistration userServiceRegistration);

    Optional<UserServiceRegistration> findByConsumerIdAndActiveTrueAndSolutionStatus(String consumerId);

    UserServiceRegistration findByTicketNumberAndActiveTrue(String ticketNumber);
}

