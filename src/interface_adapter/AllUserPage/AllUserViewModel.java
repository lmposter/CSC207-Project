package interface_adapter.AllUserPage;

import interface_adapter.AllUserPage.buyerPage.BuyerState;
import interface_adapter.AllUserPage.sellerPage.SellerState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AllUserViewModel extends ViewModel {
    public final String TITLE_LABEL = "Amazoff";

    public static final String SEARCH_ITEM_LABEL = "Search Item";

    public AllUserViewModel(String user) {
        super("User logged in");
    }
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
