package interface_adapter.buyerPage;

/**
 * The SellerState class represents the state of the logged-in view.
 * It includes information such as the username of the logged-in user.
 */
public class BuyerState {
    private String username = "";

    /**
     * Constructs a SellerState by copying the values from another SellerState.
     *
     * @param copy The SellerState to copy values from.
     */
    public BuyerState(BuyerState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public BuyerState() {}

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