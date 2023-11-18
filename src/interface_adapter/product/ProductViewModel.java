package interface_adapter.product;

import interface_adapter.ViewModel;
import interface_adapter.search.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProductViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Product details";
    public static final String PRICE_LABEL = "$";
    public static final String INVENTORY_LABEL = "items left:";
    public static final String REVIEW_LABEL = "Reviews:";
    public static final String PURCHASE_LABEL = "Buy now";
    public static final String ADD_TO_CART_LABEL = "Add to cart";

    public ProductViewModel(){super("Product details");}
    private ProductState state = new ProductState();
    public void setState(ProductState state){this.state = state; }
    public ProductState getState() {return state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
