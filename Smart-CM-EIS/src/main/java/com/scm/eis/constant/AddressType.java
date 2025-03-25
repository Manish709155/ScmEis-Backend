package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressType {

    HOME("Home"),OFFICE("Office"),OTHERS("Others");

    final String diplayName;
}
