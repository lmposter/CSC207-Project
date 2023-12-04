package interface_adapter.AllUserPage;

import interface_adapter.AllUserPage.buyerPage.BuyerState;
import interface_adapter.AllUserPage.sellerPage.SellerState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AllUserViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";
    private AllUserState state = new AllUserState();
    public static final String SEARCH_ITEM_LABEL = "Search Item";

    public AllUserViewModel(String user) {
        super("User logged in");
    }
    private String user;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners that a property has changed.
     * This is called to alert the view when the state changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(AllUserState state) {
        this.state = state;
    }
    public AllUserState getState() {
        return state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
