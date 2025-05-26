package com.scm.eis.serviceImpl;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.repository.UserServiceRegistrationRepository;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceRegistrationImpl implements UserServiceRegistrationService {

    @Autowired
    UserServiceRegistrationRepository userServiceRegistrationRepository;

    @Override
    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistration userServiceRegistration){
        return userServiceRegistrationRepository.save(userServiceRegistration);
    }

    @Override
    public Optional<UserServiceRegistration> findByConsumerIdAndActiveTrueAndSolutionStatus(String consumerId) {
        return userServiceRegistrationRepository.findByConsumerIdAndActiveTrueAndSolutionStatus(consumerId);
    }


    @Override
    public UserServiceRegistration findByTicketNumberAndActiveTrue(String ticketNumber) {
        return userServiceRegistrationRepository.findByTicketNumberAndActiveTrue(ticketNumber);
    }

    @Override
    public Optional<UserServiceRegistration> findByNotificationReadActiveTrueAndConsumerId(String consumerId) {
        return userServiceRegistrationRepository.findByActiveTrueAndNotificationReadTrueAndUserConsumerId(consumerId);
    }

    @Override
    public List<UserServiceRegistration> findUnreadNotifications() {
        return userServiceRegistrationRepository.findUnreadNotifications();
    }

}
