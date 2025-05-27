package com.scm.eis.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ComplainListResponse {

    ManualComplaintListResponse manualComplaintListResponse;

    ChatBoatComplainListResponse chatBoatComplainListResponse;
}
