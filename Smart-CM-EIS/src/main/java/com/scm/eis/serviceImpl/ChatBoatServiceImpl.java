package com.scm.eis.serviceImpl;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;
import com.scm.eis.repository.ChatBoatRepository;
import com.scm.eis.service.ChatBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChatBoatServiceImpl implements ChatBoatService {

    @Autowired
    ChatBoatRepository chatBoatRepository;


    @Override
    public void userAskedQueryByChatBoat(ChatBoat chatBoat) {
        chatBoatRepository.save(chatBoat);
    }

    @Override
    public ChatBoat findByUserIdAndActiveTrue(Long userId) {
        return chatBoatRepository.findByUserIdAndActiveTrue(userId);
    }

}
