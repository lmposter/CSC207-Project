package interface_adapter.guestPage;

/**
 * The LoggedInState class represents the state of the logged-in view.
 * It includes information such as the username of the logged-in user.
 */
public class GuestState {
    private String username = "";

    /**
     * Constructs a LoggedInState by copying the values from another LoggedInState.
     *
     * @param copy The LoggedInState to copy values from.
     */
    public GuestState(GuestState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public GuestState() {}

    /**
     * Gets the username of the logged-in user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the logged-in user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }
}