package com.scm.eis.serviceImpl;

import com.scm.eis.entity.UserServiceRegistration;
import com.scm.eis.repository.UserServiceRegistrationRepository;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceRegistrationImpl implements UserServiceRegistrationService {

    @Autowired
    UserServiceRegistrationRepository userServiceRegistrationRepository;

    @Override
    public UserServiceRegistration createUserServiceRegistration(UserServiceRegistration userServiceRegistration){
        return userServiceRegistrationRepository.save(userServiceRegistration);
    };
}
