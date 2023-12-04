package interface_adapter.AllUserPage.sellerPage;

import interface_adapter.AllUserPage.AllUserState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The SellerViewModel class represents the view model for the logged-in view.
 * It includes labels, buttons, and the state of the logged-in view.
 */
public class SellerViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";

    public static final String SEARCH_ITEM_LABEL = "Search Item";
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

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
    public void setState(SellerState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
