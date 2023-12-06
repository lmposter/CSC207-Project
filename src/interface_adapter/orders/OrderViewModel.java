package interface_adapter.orders;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OrderViewModel extends ViewModel
{

    public static final String TITLE_LABEL = "Order";
    public static final String USERNAME_LABEL = "Username";
    public static final String PASSWORD_LABEL = "Password";

    public static final String Product_Menu = "Product";
    // public static final String GUEST_BUTTON_LABEL = "Guest Login";
    private OrderState state = new OrderState();

    public OrderViewModel()
    {
        super("Order");
    }

    public void setState(OrderState state)
    {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged()
    {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    public OrderState getState()
    {
        return state;
    }
}
