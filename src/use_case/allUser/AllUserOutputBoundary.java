package use_case.allUser;

import use_case.allUser.sellerPage.SellerOutputData;

public interface AllUserOutputBoundary {
    void switchPageLogOut();
    void switchPageSearch(String username);
    void prepareFailView(String errorMessage);
}
