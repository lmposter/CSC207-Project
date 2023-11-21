package view;

import interface_adapter.shopping_cart.ShoppingCartViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShoppingCartView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "shopping cart";

    private final ShoppingCartViewModel shoppingCartViewModel;

    private final JButton checkOut;

    public ShoppingCartView(ShoppingCartViewModel shoppingCartViewModel, JButton checkOut)
    {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.checkOut = checkOut;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
