package com.scm.eis.serviceImpl;

import com.scm.eis.entity.ChatBoat;
import com.scm.eis.repository.ChatRepository;
import com.scm.eis.service.ChatBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatBoatServiceImpl implements ChatBoatService {

    @Autowired
    ChatRepository chatRepository;

    @Override
    public ChatBoat userAskedQueryByChatBoat(ChatBoat chatBoat) {
        return chatRepository.save(chatBoat);
    }
}
