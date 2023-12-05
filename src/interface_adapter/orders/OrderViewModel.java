package interface_adapter.orders;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The LoginViewModel class represents the view model for the login view.
 * It includes labels, buttons, and the state of the login view.
 */
public class OrderViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Order";
    public static final String USERNAME_LABEL = "Username";
    public static final String PASSWORD_LABEL = "Password";

    public static final String Product_Menu = "Product";
    // public static final String GUEST_BUTTON_LABEL = "Guest Login";
    private OrderState state = new OrderState();

    /**
     * Constructs a LoginViewModel with the specified view name.
     *
     */
    public OrderViewModel() {
        super("Order");
    }

    /**
     * Sets the state of the login view.
     *
     * @param state The LoginState to set.
     */
    public void setState(OrderState state) {
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
     * Gets the current state of the login view.
     *
     * @return The current LoginState.
     */
    public OrderState getState() {
        return state;
    }
}
