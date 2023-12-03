package use_case.buyerPage;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface BuyerInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     *
     * @param buyerInputData The input data containing username and password for login.
     */
    void execute(BuyerInputData buyerInputData);

    void switchPageLogOut();

    void changePassword(String username, String password);

    void switchPageSearch(String username);

    void switchPageOrder(String username);

    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);
}