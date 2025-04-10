package com.scm.eis.response;

import com.scm.eis.constant.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceRegistrationResponse {

    Long id;

    QueryType queryType;

    NonTechSolutionsTypes nonTechSolutionsTypes;

    TechSolutionsTypes techSolutionsTypes;

    String ticketNumber;

    String serviceNumber;

    SolutionStatus solutionStatus;

    SupportChannel supportChannel;

    LanguageType language;

    String queryInvalidReason;

    String servicePriority;
}
