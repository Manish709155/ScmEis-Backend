package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskType {

    CHAT_BOAT("Chat Boat"),
    MANUAL("Manual");
    private final String displayName;
}
