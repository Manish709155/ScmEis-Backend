package com.scm.eis.request;

import com.scm.eis.constant.EscalationPriority;
import com.scm.eis.constant.QueryUnder;
import com.scm.eis.constant.SolutionStatus;
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
public class ChatBoatRequest implements Serializable {

    SolutionStatus solutionStatus;

    EscalationPriority escalationPriority;

    String userAskedQuery;

}
