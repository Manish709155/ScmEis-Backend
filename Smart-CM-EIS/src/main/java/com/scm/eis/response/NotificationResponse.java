package com.scm.eis.response;

import com.scm.eis.constant.SolutionStatus;
import lombok.Data;

@Data
public class NotificationResponse {

    Long id;

    SolutionStatus notificationMessage;

    Boolean notificationRead;
}
