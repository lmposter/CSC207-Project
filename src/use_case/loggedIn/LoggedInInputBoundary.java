package use_case.loggedIn;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface LoggedInInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     *
     * @param loggedInInputData The input data containing username and password for login.
     */
    void execute(LoggedInInputData loggedInInputData);

    void switchPageLogOut();

    void changePassword(String username, String password);

    void switchPageSearch(String username);

    void switchPageOrder(String username);

    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);
}