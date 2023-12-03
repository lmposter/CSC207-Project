package interface_adapter.guestPage;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The LoggedInViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class GuestViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";

    private GuestState state = new GuestState();

    public static final String LOGOUT_BUTTON_LABEL = "Login to access more features!";

    public static final String SEARCH_ITEM_LABEL = "Browse Items";
    
    private String guestUser;

    /**
     * Constructs a LoggedInViewModel with the specified view name.
     *
     */
    public GuestViewModel() {
        super("guest logged in");
    }

    /**
     * Sets the state of the logged-in view.
     *
     * @param state The LoggedInState to set.
     */
    public void setState(GuestState state) {
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
    public GuestState getState() {
        return state;
    }

    /**
     * Gets the username of the logged-in user.
     *
     * @return The username of the logged-in user.
     */
    public String getGuestUser() {
        return guestUser;
    }

    /**
     * Sets the username of the logged-in user.
     *
     * @param guestUser The username to set.
     */
    public void setGuestUser(String guestUser) {
        this.guestUser = guestUser;
    }
}
