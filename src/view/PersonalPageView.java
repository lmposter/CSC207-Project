package view;

import interface_adapter.SwitchPage.SwitchPageController;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PersonalPageView extends JPanel implements ActionListener, PropertyChangeListener
{

    private final String viewname = "Personal Page";
    private final JButton cart;
    private final JButton store;
    private final JLabel usernameLabel;
    private final JButton changeUsername;
    private final JButton changePassword;
    private final SwitchPageController switchController;
    private final LoggedInViewModel loggedInViewModel;

    public PersonalPageView(SwitchPageController switchController, LoggedInViewModel loggedInViewModel)
    {
        JLabel title = new JLabel("Personal Page");
        this.switchController = switchController;
        this.loggedInViewModel = loggedInViewModel;
        this.cart = new JButton("Shopping Cart");
        this.store = new JButton("Store");
        changeUsername = new JButton("Change Username");
        changePassword = new JButton("Change Password");

        String username = loggedInViewModel.getState().getUsername();

        usernameLabel = new JLabel("Username: " + username);


        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BorderLayout());

        add(usernameLabel, BorderLayout.NORTH);

        // Create a panel to hold the buttons and set its layout
        JPanel button = new JPanel();
        button.setLayout(new FlowLayout());

        // Add buttons to the button panel
        button.add(store);
        button.add(cart);
        button.add(changeUsername);
        button.add(changePassword);

        // Add the button panel to the main panel
        add(button, BorderLayout.CENTER);

        store.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals(store))
                {
                    switchController.switchToStore();
                }
            }
        });

        cart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals(cart))
                {
                    switchController.switchToCart();
                }
            }
        });

        changeUsername.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals(changeUsername))
                {
                    // TODO
                }
            }
        });

        changePassword.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource().equals(changePassword))
                {
                    // TODO
                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {

    }
}
