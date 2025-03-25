package com.scm.eis.util;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {

    public static boolean isValid(Long value) {
        return value != null && value > 0;
    }

    public static boolean isEmpty(String string) {
        return StringUtils.isBlank(string);
    }
}
