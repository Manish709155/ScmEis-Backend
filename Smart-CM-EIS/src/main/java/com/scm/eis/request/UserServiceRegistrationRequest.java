package com.scm.eis.request;

import com.scm.eis.constant.*;
import com.scm.eis.entity.Employee;
import com.scm.eis.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceRegistrationRequest implements Serializable {

    QueryType queryType;

    NonTechSolutionsTypes nonTechSolutionsTypes;

    TechSolutionsTypes techSolutionsTypes;

    SolutionStatus solutionStatus;

    SupportChannel supportChannel;

    LanguageType language;

    String queryInvalidReason;

    String servicePriority;

    Long companyId;

    EscalationPriority escalationPriority;

    QueryUnder queryUnder;

    String optionNotAvailable;

    EmployeeLevel employeeLevel;

    String consumerId;

}
