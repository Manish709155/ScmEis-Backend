package com.scm.eis.request;

import com.scm.eis.constant.MessageType;
import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    MessageType type;

    private String askQuery;

    String validateConsumerId;

}