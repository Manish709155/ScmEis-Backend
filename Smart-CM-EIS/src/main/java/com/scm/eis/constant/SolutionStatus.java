package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SolutionStatus {
    CREATED("Created"),
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    ON_HOLD("On Hold"),
    CANCELLED("Cancelled"),
    SUBMITTED("Submitted");

    private final String displayName;
}
