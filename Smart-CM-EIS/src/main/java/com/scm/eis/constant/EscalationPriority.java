package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EscalationPriority {


    LOW("4"),
    MEDIUM("3"),
    HIGH("2"),
    VERY_HIGH("1"),
    TEAM_WILL_BE_DECIDE("Team Will Be Decide");

    public final String level;
}