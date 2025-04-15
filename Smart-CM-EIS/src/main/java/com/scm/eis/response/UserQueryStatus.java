package com.scm.eis.response;

import com.scm.eis.constant.SolutionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserQueryStatus {

    Long id;

    SolutionStatus userQueryUpdatedStatus;
}
