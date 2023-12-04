package use_case.allUser.sellerPage;

import use_case.allUser.AllUserInputBoundary;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface SellerInputBoundary extends AllUserInputBoundary {


    void changePassword(String username, String password);


    void switchPageOrder(String username);

    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);

    void execute(SellerInputData sellerInputData);
}