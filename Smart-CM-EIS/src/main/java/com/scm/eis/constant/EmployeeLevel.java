package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeLevel {
    LEVEL_ONE("Level-1"),LEVEL_TWO("Level-2"),LEVEL_THREE("Level-3"),LEVEL_FOUR("Level-4");

    final String employeeLevel;
}