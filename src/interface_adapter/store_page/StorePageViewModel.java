package interface_adapter.store_page;

import interface_adapter.Create_product.CreatePdState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StorePageViewModel extends ViewModel {
    public static final String CREATE_PRODUCT_LABEL = "Create a new product";

    public StorePageViewModel(){super("Store Page");}
    private StorePageState state = new StorePageState();
    public void setState(StorePageState state){this.state = state; }
    public StorePageState getState() {return state;}

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
