package use_case.guestPage;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface GuestInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     */

    void switchPageLogOut();

    void switchPageSearch(String username);
}