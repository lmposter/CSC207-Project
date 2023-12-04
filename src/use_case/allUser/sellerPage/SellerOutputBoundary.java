package use_case.allUser.sellerPage;

import use_case.allUser.AllUserOutputBoundary;

/**
 * The LoginOutputBoundary interface defines methods for presenting the output of the login use case.
 * It includes operations for preparing views in case of successful and failed login attempts.
 */
public interface SellerOutputBoundary extends AllUserOutputBoundary {

    /**
     * Prepare the view for a successful login attempt.
     *
     * @param sellerOutputData The output data containing user information.
     */
    void prepareSuccessView(SellerOutputData sellerOutputData);


    void switchPageOrder(String username);


    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);
}