package interface_adapter.AllUserPage;

import interface_adapter.AllUserPage.buyerPage.BuyerState;

public class AllUserState {
    private String username = "";

    /**
     * Constructs a SellerState by copying the values from another SellerState.
     *
     * @param copy The SellerState to copy values from.
     */
    public AllUserState(AllUserState copy) {
        username = copy.getUsername();
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public AllUserState() {}

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
