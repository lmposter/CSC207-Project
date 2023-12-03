package interface_adapter.sellerPage;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SellerViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class SellerViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";

    private SellerState state = new SellerState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";

    public static final String SEARCH_ITEM_LABEL = "Search Item";

    public static final String SELL_PRODUCT_LABEL = "My Store";
    public static final String PERSONAL_PAGE_LABEL = "Order In Progress";
    private String loggedInUser;

    /**
     * Constructs a SellerViewModel with the specified view name.
     *
     */
    public SellerViewModel() {
        super("logged in");
    }

    /**
     * Sets the state of the logged-in view.
     *
     * @param state The SellerState to set.
     */
    public void setState(SellerState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners that a property has changed.
     * This is called to alert the view when the state changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener.
     *
     * @param listener The listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the logged-in view.
     *
     * @return The current SellerState.
     */
    public SellerState getState() {
        return state;
    }

    /**
     * Gets the username of the logged-in user.
     *
     * @return The username of the logged-in user.
     */
    public String getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Sets the username of the logged-in user.
     *
     * @param loggedInUser The username to set.
     */
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
