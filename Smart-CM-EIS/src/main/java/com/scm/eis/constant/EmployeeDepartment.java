package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeDepartment {
    ENGINEERING("Handles power grid maintenance, repairs, and infrastructure development."),
    CUSTOMER_SERVICE("Manages customer inquiries, complaints, and billing assistance."),
    IT_SUPPORT("Maintains company software, networks, and cybersecurity."),
    FINANCE("Oversees budgeting, electricity tariff management, and financial audits."),
    HR("Handles employee hiring, training, payroll, and benefits."),
    OPERATIONS("Manages power distribution, outage response, and grid efficiency."),
    LEGAL("Ensures regulatory compliance and handles legal disputes."),
    RENEWABLE_ENERGY("Focuses on integrating solar, wind, and other renewable energy sources."),
    SALES_MARKETING("Promotes electricity plans, services, and customer engagement strategies.");

    private final String description;

}
