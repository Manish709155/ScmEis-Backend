package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueryUnder {
    TECHNICAL("Technical"),NON_TECHNICAL("Non-Technical");

    final String queryUnder;
}
