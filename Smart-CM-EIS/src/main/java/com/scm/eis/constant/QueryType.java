package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueryType {

    VALID("Valid"),INVALID("Invalid");

    private final String diplayName;
}
