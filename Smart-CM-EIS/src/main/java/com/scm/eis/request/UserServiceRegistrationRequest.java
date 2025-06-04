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

    NonTechSolutionsTypes nonTechSolutionsTypes;

    TechSolutionsTypes techSolutionsTypes;

    SolutionStatus solutionStatus;

    SupportChannel supportChannel;

    LanguageType language;

    EscalationPriority escalationPriority;

    QueryUnder queryUnder;

    EmployeeLevel employeeLevel;

    String consumerId;

    EmployeeCategory employeeCategory;

    String userAskedQuery;

}
