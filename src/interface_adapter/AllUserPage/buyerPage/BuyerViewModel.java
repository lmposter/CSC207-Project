package interface_adapter.AllUserPage.buyerPage;

import interface_adapter.AllUserPage.AllUserState;
import interface_adapter.AllUserPage.AllUserViewModel;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SellerViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class BuyerViewModel extends AllUserViewModel {


    private BuyerState state = new BuyerState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";

    public static final String SELL_PRODUCT_LABEL = "My Orders";
    public static final String PERSONAL_PAGE_LABEL = "Personal Page";
    public static final String SHOPPING_CART_LABEL = "Shopping Cart";

    /**
     * Constructs a SellerViewModel with the specified view name.
     *
     */
    public BuyerViewModel() {
        super("buyer logged in");
    }
    public BuyerState getState() {
        return state;
    }

}
