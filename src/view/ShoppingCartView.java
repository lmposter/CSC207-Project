package view;

import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.shopping_cart.checkOut.CheckOutController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShoppingCartView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "shopping cart";

    private final ShoppingCartViewModel shoppingCartViewModel;

    private final CheckOutController checkOutController;

    private final LoggedInViewModel loggedInViewModel;

    private final JButton checkOut;
    private final JButton store;

    public ShoppingCartView(ShoppingCartViewModel shoppingCartViewModel, CheckOutController checkOutController, LoggedInViewModel loggedInViewModel)
    {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.checkOutController = checkOutController;
        this.loggedInViewModel = loggedInViewModel;

        this.checkOut = new JButton("Check Out");
        this.store = new JButton("Store");

        this.shoppingCartViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Shopping Cart");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        buttons.add(this.checkOut);
        buttons.add(this.store);

        checkOut.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if (e.getSource().equals(checkOut))
                        {
                            String username = loggedInViewModel.getLoggedInUser();
                            checkOutController.execute(username);
                        }
                    }
                }
        );

        store.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if (e.getSource().equals(store))
                        {
                            //TODO Switch to Store Page
                        }
                    }
                }
        );


    }

    private JPanel createProductPanel(String name, double price)
    {
        JPanel productpanel = new JPanel();
        return productpanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
