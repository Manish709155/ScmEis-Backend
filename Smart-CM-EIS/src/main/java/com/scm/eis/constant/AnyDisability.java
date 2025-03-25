package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnyDisability {

    YES("Yes"),NO("No"),PRIVATE("Private can note be disclosed.");

    private final String displayName;
}
