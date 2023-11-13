package interface_adapter.login;

/**
 * The LoginState class represents the state of the login view.
 * It includes information such as username, username error, password, and password error.
 */
public class LoginState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Constructs a LoginState by copying the values from another LoginState.
     *
     * @param copy The LoginState to copy values from.
     */
    public LoginState(LoginState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoginState() {}

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the username error.
     *
     * @return The username error.
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the password error.
     *
     * @return The password error.
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the username error.
     *
     * @param usernameError The username error to set.
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the password error.
     *
     * @param passwordError The password error to set.
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}
