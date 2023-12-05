package interface_adapter.orders;

/**
 * The LoginState class represents the state of the login view.
 * It includes information such as username, username error, password, and password error.
 */
public class OrderState {
    private String username = "";
    private String usernameError = null;

    /**
     * Constructs a LoginState by copying the values from another LoginState.
     *
     * @param copy The LoginState to copy values from.
     */
    public OrderState(OrderState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OrderState() {}

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
}
