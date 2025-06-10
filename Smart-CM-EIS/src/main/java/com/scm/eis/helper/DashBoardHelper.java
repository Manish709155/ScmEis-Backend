package com.scm.eis.helper;

import com.scm.eis.response.DashBoardSolutionStatusCount;
import com.scm.eis.service.ChatBoatService;
import com.scm.eis.service.UserServiceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashBoardHelper {

    @Autowired
    ChatBoatService chatBoatService;

    @Autowired
    UserServiceRegistrationService userServiceRegistrationService;

    public DashBoardSolutionStatusCount getSolutionStatusCount() {

        Long resolvedCount = chatBoatService.countActiveResolvedSolutions() + userServiceRegistrationService.countActiveResolvedSolutions();

        Long pendingCount = chatBoatService.countActivePendingSolutions() + userServiceRegistrationService.countActivePendingSolutions();

        Long rejectedCount = chatBoatService.countActiveRejectedSolutions() + userServiceRegistrationService.countActiveRejectedSolutions();

        Long createdCount = chatBoatService.countActiveCreatedSolutions() + userServiceRegistrationService.countActiveCreatedSolutions();

        Long onHoldCount = chatBoatService.countActiveoNHoldSolutions() + userServiceRegistrationService.countActiveONHoldSolutions();

        Long inProgressCount = chatBoatService.countActiveinProgressSolutions() + userServiceRegistrationService.countActiveInProgressSolutions();

        Long totalCount = resolvedCount + pendingCount + rejectedCount + createdCount + onHoldCount + inProgressCount;

        DashBoardSolutionStatusCount dashBoardSolutionStatusCount = new DashBoardSolutionStatusCount();

        dashBoardSolutionStatusCount.setResolvedCount(resolvedCount);
        dashBoardSolutionStatusCount.setPendingCount(pendingCount);
        dashBoardSolutionStatusCount.setRejectedCount(rejectedCount);
        dashBoardSolutionStatusCount.setCreatedCount(createdCount);
        dashBoardSolutionStatusCount.setOnHoldCount(onHoldCount);
        dashBoardSolutionStatusCount.setInProgressCount(inProgressCount);
        dashBoardSolutionStatusCount.setTotalCount(totalCount);

        return dashBoardSolutionStatusCount;
    }
}
