package com.scm.eis.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskAssignRequest {

    String ticketNumber;

    String employeeSapId;
}
