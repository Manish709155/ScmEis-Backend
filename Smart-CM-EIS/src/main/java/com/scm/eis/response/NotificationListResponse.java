package com.scm.eis.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationListResponse {

    NotificationManualQueryResponse notificationManualQueryResponse;

    NotificationChatBoatResponse notificationChatBoatResponse;
}
