package com.scm.eis.service;

import com.scm.eis.constant.SolutionStatus;
import com.scm.eis.entity.ChatBoat;

import java.util.List;

public interface ChatBoatService {

    public void userAskedQueryByChatBoat(ChatBoat chatBoat);

    ChatBoat findByUserIdAndActiveTrue(Long userId);
}
