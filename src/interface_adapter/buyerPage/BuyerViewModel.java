package interface_adapter.buyerPage;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SellerViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class BuyerViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";

    private BuyerState state = new BuyerState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";

    public static final String SEARCH_ITEM_LABEL = "Browse Items";

<<<<<<< HEAD:src/interface_adapter/logged_in/LoggedInViewModel.java
    public static final String STORE_LABEL = "Store Page";
=======
    public static final String SELL_PRODUCT_LABEL = "My Orders";
>>>>>>> f2b7ed05fca187c6036832af52480bef0610c6f1:src/interface_adapter/buyerPage/BuyerViewModel.java
    public static final String PERSONAL_PAGE_LABEL = "Personal Page";
    public static final String SHOPPING_CART_LABEL = "Shopping Cart";
    private String loggedInUser;

    /**
     * Constructs a SellerViewModel with the specified view name.
     *
     */
    public BuyerViewModel() {
        super("buyer logged in");
    }

    /**
     * Sets the state of the logged-in view.
     *
     * @param state The SellerState to set.
     */
    public void setState(BuyerState state) {
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
    public BuyerState getState() {
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
