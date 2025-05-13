package com.scm.eis.request;

import lombok.Data;

@Data
public class NotificationRequest {

    String consumerId;

    Boolean sendNotificationFlagAfterReadingTheNotification;
}
