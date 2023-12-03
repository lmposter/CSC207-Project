package use_case.sellerPage;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface SellerInputBoundary {
    
    void switchPageLogOut();

    void changePassword(String username, String password);

    void switchPageSearch(String username);

    void switchPageOrder(String username);

    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);

    void execute(SellerInputData sellerInputData);
}