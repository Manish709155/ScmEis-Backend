package com.scm.eis.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum NonTechSolutionsTypes {

    CUSTOMER_SERVICE_CENTERS("Physical service centers assist with billing issues and complaints."),
    AWARENESS_PROGRAMS("Educational initiatives teach customers energy-saving practices."),
    PAPER_BILLING("Customers receive physical copies of their electricity bills."),
    EMERGENCY_SUPPORT("On-ground technician teams handle power outages and infrastructure issues."),
    RURAL_ELECTRIFICATION("Projects aimed at expanding electricity access to remote areas."),
    SUBSIDIES("Financial aid programs offer discounted electricity rates for eligible customers."),
    TARIFF_ADVISORY("Guidance on selecting the best electricity tariff plans for different needs."),
    LOAD_SHEDDING_SCHEDULES("Planned power outage schedules are communicated to affected areas.");
     final String query;
}
