package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SupportChannel {
    PHONE_CALL("Direct call to a support agent", "Fast", "24/7", "HIGH", "+1-800-123-4567"),
    PHONE_TEXT("Text messages for support", "Moderate", "9 AM - 9 PM", "MEDIUM", "+1-800-987-6543"),
    HELPLINE_NUMBER("Toll-free number for customer support", "Fast", "24/7", "HIGH", "+1-800-HELP-NOW"),
    EMAIL_ID("Support via email responses", "Slow", "Business Hours", "LOW", "support@powercompany.com"),
    AI_CHATBOT("Automated chatbot for instant assistance", "Instant", "24/7", "MEDIUM", "chat.powercompany.com"),
    SOCIAL_MEDIA("Support through social platforms", "Varies", "Business Hours", "LOW", "@PowerCompanySupport");

    private final String description;
    private final String responseTime;
    private final String availability;
    private final String servicePriority;
    private final String helpline;
}
