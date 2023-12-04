package use_case.allUser.buyerPage;

import use_case.allUser.AllUserOutputBoundary;

/**
 * The LoginOutputBoundary interface defines methods for presenting the output of the login use case.
 * It includes operations for preparing views in case of successful and failed login attempts.
 */
public interface BuyerOutputBoundary extends AllUserOutputBoundary {

    /**
     * Prepare the view for a successful login attempt.
     *
     * @param buyerOutputData The output data containing user information.
     */
    void prepareSuccessView(BuyerOutputData buyerOutputData);

    void switchPageOrder(String username);


    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);
}