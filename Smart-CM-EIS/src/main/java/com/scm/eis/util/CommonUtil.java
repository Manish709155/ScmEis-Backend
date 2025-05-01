package com.scm.eis.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CommonUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TICKET_NUMBER_LENGTH = 12;
    private static final int SERVICE_NUMBER_LENGTH = 16;
    private static final int EMPLOYEE_SAP_LENGTH = 8;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static boolean isValid(Long value) {
        return value != null && value > 0;
    }

    public static boolean isEmpty(Object string) {
        return ObjectUtils.isEmpty(string);
    }

    public static String generateConsumerId() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(0, 24);
    }

    public static String generateTicketNumber() {
        StringBuilder ticket = new StringBuilder(TICKET_NUMBER_LENGTH);
        for (int i = 0; i < TICKET_NUMBER_LENGTH; i++) {
            ticket.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return ticket.toString();
    }
    public static String generateServiceNumber() {
       return IntStream.range(0, SERVICE_NUMBER_LENGTH)
                .mapToObj(i -> String.valueOf(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length()))))
                .collect(Collectors.joining());
    }

    public static String generateEmployeeSapId() {
        return IntStream.range(0, EMPLOYEE_SAP_LENGTH)
                .mapToObj(i -> String.valueOf(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length()))))
                .collect(Collectors.joining());
    }

    public static String generateOtp() {
        StringBuilder ticket = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            ticket.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return ticket.toString();
    }
}
