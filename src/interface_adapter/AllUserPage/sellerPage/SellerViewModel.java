package interface_adapter.AllUserPage.sellerPage;

import interface_adapter.AllUserPage.AllUserState;
import interface_adapter.AllUserPage.AllUserViewModel;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SellerViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class SellerViewModel extends AllUserViewModel {


    private SellerState state = new SellerState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";

    public static final String SELL_PRODUCT_LABEL = "My Store";
    public static final String PERSONAL_PAGE_LABEL = "Order In Progress";
    private String loggedInUser;

    /**
     * Constructs a SellerViewModel with the specified view name.
     *
     */
    public SellerViewModel() {
        super("seller logged in");
    }
    public SellerState getState() {
        return state;
    }


}
