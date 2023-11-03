package use_case.login;

/**
 * The LoginInputData class represents the input data for the user login process.
 * It holds information such as the username and password.
 */
public record LoginInputData(String username, String password) {

    /**
     * Constructs a LoginInputData object with the provided username and password.
     *
     * @param username The username for the login attempt.
     * @param password The password for the login attempt.
     */
    public LoginInputData {
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

    /**
     * Gets the password.
     *
     * @return The password for the login attempt.
     */
    @Override
    public String password() {
        return password;
    }
}
