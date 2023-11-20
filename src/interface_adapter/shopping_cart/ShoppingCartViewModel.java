package interface_adapter.shopping_cart;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShoppingCartViewModel extends ViewModel
{
    private ShoppingCartState state = new ShoppingCartState();

    public ShoppingCartViewModel()
    {
        super("Shopping Cart");
    }

    public ShoppingCartState getState()
    {
        return this.state;
    }

    public void setState(ShoppingCartState state)
    {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {}
}
