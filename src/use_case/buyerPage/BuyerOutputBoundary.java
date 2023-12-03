package use_case.buyerPage;

/**
 * The LoginOutputBoundary interface defines methods for presenting the output of the login use case.
 * It includes operations for preparing views in case of successful and failed login attempts.
 */
public interface BuyerOutputBoundary {

    /**
     * Prepare the view for a successful login attempt.
     *
     * @param buyerOutputData The output data containing user information.
     */
    void prepareSuccessView(BuyerOutputData buyerOutputData);

    /**
     * Prepare the view for a failed login attempt.
     *
     * @param errorMessage The error message to be displayed.
     */
    void prepareFailView(String errorMessage);

    void switchPageLogOut();

    void switchPageOrder(String username);

    void switchPageSearch(String username);

    void switchPageShoppingCart(String username);

    void switchPageStorePage(String username);
}