package interface_adapter.AllUserPage.guestPage;

import interface_adapter.AllUserPage.AllUserViewModel;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SellerViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class GuestViewModel extends AllUserViewModel {


    private GuestState state = new GuestState();

    public static final String LOGOUT_BUTTON_LABEL = "Login to access more features!";

    /**
     * Constructs a SellerViewModel with the specified view name.
     *
     */
    public GuestViewModel() {
        super("guest logged in");
    }

    /**
     * Sets the state of the logged-in view.
     *
     * @param state The SellerState to set.
     */
}
