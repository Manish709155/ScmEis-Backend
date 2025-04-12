package com.scm.eis.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum TechSolutionsTypes {

    SMART_METERING("Smart meters provide real-time usage data and automated billing."),
    MOBILE_APPS("Mobile apps and web portals allow customers to check usage and pay bills online."),
    LOAD_MANAGEMENT("Automated systems optimize electricity load to prevent voltage fluctuations."),
    RENEWABLE_INTEGRATION("Net metering allows customers to sell surplus solar energy back to the grid."),
    AI_MAINTENANCE("AI-based predictive maintenance helps detect and prevent power failures."),
    EV_CHARGING("Electric vehicle charging station networks provide real-time availability and booking."),
    HOME_ENERGY_MANAGEMENT("IoT-based systems help consumers optimize their home energy usage."),
    AI_CHATBOTS("AI-powered virtual assistants provide instant support for customer queries."),
    OPTION_NOT_AVAILABLE(String.valueOf(""));
    private final String query;
}
