package interface_adapter.logged_in;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The LoggedInViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class LoggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";

    private LoggedInState state = new LoggedInState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";

    public static final String SEARCH_ITEM_LABEL = "Search Item";

    public static final String SELL_PRODUCT_LABEL = "Sell Product";
    public static final String PERSONAL_PAGE_LABEL = "Personal Page";
    public static final String SHOPPING_CART_LABEL = "Shopping Cart";
    private String loggedInUser;

    /**
     * Constructs a LoggedInViewModel with the specified view name.
     *
     */
    public LoggedInViewModel() {
        super("logged in");
    }

    /**
     * Sets the state of the logged-in view.
     *
     * @param state The LoggedInState to set.
     */
    public void setState(LoggedInState state) {
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
     * @return The current LoggedInState.
     */
    public LoggedInState getState() {
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
