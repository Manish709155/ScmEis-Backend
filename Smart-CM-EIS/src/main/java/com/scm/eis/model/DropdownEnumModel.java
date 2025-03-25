package com.scm.eis.model;

import lombok.Value;

import java.io.Serializable;

@Value
public class DropdownEnumModel implements Serializable {

        static final long serialVersionUID = 1L;

        String label;

        String value;

    }



