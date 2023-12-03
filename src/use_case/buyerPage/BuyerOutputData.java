package use_case.buyerPage;

/**
 * The LoginOutputData class represents the output data for the login use case.
 * It holds information to be presented in the view after a login attempt.
 */
public record BuyerOutputData(String username, boolean successful) {

    /**
     * Constructs a LoginOutputData object with the provided username and success status.
     *
     * @param username   The username associated with the login attempt.
     * @param successful True if the login was successful, false otherwise.
     */
    public BuyerOutputData {
    }

    /**
     * Gets the username associated with the login attempt.
     *
     * @return The username.
     */
    @Override
    public String username() {
        return username;
    }

    /**
     * Checks if the login was successful.
     *
     * @return True if the login was successful, false otherwise.
     */
    @Override
    public boolean successful() {
        return successful;
    }
}
