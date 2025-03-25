package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeCategory {

    TECHNICAL("Technical"),NONTECHNICAL("Non Technical");

    private final String diplayName;
}
