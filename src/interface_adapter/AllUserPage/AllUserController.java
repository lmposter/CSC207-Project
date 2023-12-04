package interface_adapter.AllUserPage;

import use_case.allUser.AllUserInputBoundary;
import use_case.allUser.buyerPage.BuyerInputBoundary;
import use_case.allUser.buyerPage.BuyerInputData;

public class AllUserController {
    private final AllUserInputBoundary allUserInteractor;
    public AllUserController(AllUserInputBoundary allUserInteractor) {
        this.allUserInteractor = allUserInteractor;
    }

    public void switchPageSearch(String username) {
        allUserInteractor.switchPageSearch(username);
    }
    public void switchPageLogOut() {
        allUserInteractor.switchPageLogOut();
    }

}
