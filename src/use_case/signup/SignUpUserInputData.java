package use_case.signup;

/**
 * Data class representing input data for the user signup use case.
 */
public record SignUpUserInputData(String username, String password, String repeatPassword, String signType) {

    /**
     * Constructor for SignUpInputData.
     *
     * @param username       The username provided during signup.
     * @param password       The password provided during signup.
     * @param repeatPassword The repeated password for confirmation.
     * @param signType       The type of signup.
     */
    public SignUpUserInputData {
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    @Override
    public String username() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    @Override
    public String password() {
        return password;
    }

    /**
     * Gets the repeated password for confirmation.
     *
     * @return The repeated password.
     */
    @Override
    public String repeatPassword() {
        return repeatPassword;
    }

    /**
     * Gets the type of signup.
     *
     * @return The type of signup.
     */
    @Override
    public String signType() {
        return signType;
    }
}