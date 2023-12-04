package use_case.allUser.buyerPage;

import use_case.allUser.AllUserInputBoundary;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface BuyerInputBoundary extends AllUserInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     *
     * @param buyerInputData The input data containing username and password for login.
     */
    void execute(BuyerInputData buyerInputData);

    void changePassword(String username, String password);


    void switchPageOrder(String username);

    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);
}