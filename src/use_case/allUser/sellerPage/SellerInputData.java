package use_case.allUser.sellerPage;

/**
 * The LoginInputData class represents the input data for the user login process.
 * It holds information such as the username and password.
 */
public record SellerInputData(String username) {

    /**
     * Constructs a LoginInputData object with the provided username and password.
     *
     * @param username The username for the login attempt.
     */
    public SellerInputData {
    }

    /**
     * Gets the username.
     *
     * @return The username for the login attempt.
     */
    @Override
    public String username() {
        return username;
    }

}
