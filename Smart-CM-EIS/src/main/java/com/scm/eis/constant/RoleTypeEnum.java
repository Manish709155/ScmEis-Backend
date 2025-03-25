package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleTypeEnum {

    ADMIN("Admin"),
    ORGANIZATION_EMPLOYEE("Organization Employee"),
    USER("User");

    private String displayName;


}
