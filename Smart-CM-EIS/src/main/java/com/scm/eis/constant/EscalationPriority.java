package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EscalationPriority {


    LOW("4"),
    MEDIUM("3"),
    HIGH("2"),
    VERY_HIGH("1");


    public final String level;
}