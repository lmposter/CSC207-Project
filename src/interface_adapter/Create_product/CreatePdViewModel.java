package interface_adapter.Create_product;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreatePdViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Create Product";
    public static final String PDTITLE_LABEL = "Product Title";
    public static final String URL_LABEL = "Photo URL";
    public static final String PRICE_LABEL = "Price";
    public static final String inventory_LABEL = "Inventory";
    public static final String CREATE_BUTTON_LABEL = "CREATE";
    public static final String AFTER_VIEW_PANEL_LABEL = "MESSAGE";

    public CreatePdViewModel(){super("Create Product");}
    private CreatePdState state = new CreatePdState();
    public void setState(CreatePdState state){this.state = state; }
    public CreatePdState getState() {return state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
