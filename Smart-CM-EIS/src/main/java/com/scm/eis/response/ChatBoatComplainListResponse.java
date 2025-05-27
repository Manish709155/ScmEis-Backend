package com.scm.eis.response;

import com.scm.eis.constant.EscalationPriority;
import com.scm.eis.constant.QueryUnder;
import com.scm.eis.constant.SolutionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ChatBoatComplainListResponse {

    Long id;

    String ticketNumber;


    String serviceNumber;


    SolutionStatus solutionStatus;


    EscalationPriority escalationPriority;


    QueryUnder queryUnder;


    String userAskedQuery;

    Boolean active;

    LocalDateTime createdOn;
}
