package com.scm.eis.response;

import com.scm.eis.constant.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ManualComplaintListResponse {

    Long id;

    NonTechSolutionsTypes nonTechSolutionsTypes;

    TechSolutionsTypes techSolutionsTypes;

    String ticketNumber;

    String serviceNumber;

    SolutionStatus solutionStatus;

    SupportChannel supportChannel;

    LanguageType language;

    EscalationPriority  escalationPriority;

    QueryUnder queryUnder;

    EmployeeLevel employeeLevel;

    String userAskedQuery;

    Boolean active;

    LocalDateTime createdOn;

}
