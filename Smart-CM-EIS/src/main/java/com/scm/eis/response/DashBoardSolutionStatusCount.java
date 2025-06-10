package com.scm.eis.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DashBoardSolutionStatusCount {

    Long resolvedCount;

    Long pendingCount;

    Long rejectedCount;

    Long createdCount;

    Long onHoldCount;

    Long inProgressCount;

    Long approvedCount;

    Long totalCount;


}
