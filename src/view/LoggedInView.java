package view;

import interface_adapter.logged_in.LoggedInController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;

    private final LoggedInController loggedInController;

    JLabel title;
    JLabel usernameLabel;

    final JButton logOut;
    final JButton searchItem;
    final JButton sellProduct;
    final JButton orders;
    final JButton shoppingCart;

    /**
     * A window with a title and JButtons for various actions.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel, LoggedInController loggedInController) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInController = loggedInController;
        this.loggedInViewModel.addPropertyChangeListener(this);

        title = new JLabel("Logged In Screen");
        styleLabel(title, Color.BLACK, new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameLabel = new JLabel("Currently logged in: ");
        styleLabel(usernameLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Add Search Item Button
        searchItem = new JButton(LoggedInViewModel.SEARCH_ITEM_LABEL);
        styleButton(searchItem, Color.GRAY, Color.BLACK);
        buttons.add(searchItem);

        // Add Log Out Button
        logOut = new JButton(LoggedInViewModel.LOGOUT_BUTTON_LABEL);
        styleButton(logOut, Color.GRAY, Color.BLACK);
        buttons.add(logOut);

        // Add Sell Product Button
        sellProduct = new JButton(LoggedInViewModel.SELL_PRODUCT_LABEL);
        styleButton(sellProduct, Color.GRAY, Color.BLACK);
        buttons.add(sellProduct);

        // Add Personal Page Button
        orders = new JButton(LoggedInViewModel.PERSONAL_PAGE_LABEL);
        styleButton(orders, Color.GRAY, Color.BLACK);
        buttons.add(orders);

        // Add Shopping Cart Button
        shoppingCart = new JButton(LoggedInViewModel.SHOPPING_CART_LABEL);
        styleButton(shoppingCart, Color.GRAY, Color.BLACK);
        buttons.add(shoppingCart);

        logOut.addActionListener(this);
        searchItem.addActionListener(this);
        sellProduct.addActionListener(this);
        orders.addActionListener(this);
        shoppingCart.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameLabel);
        this.add(buttons);
    }

    private void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        Border line = BorderFactory.createLineBorder(Color.ORANGE, 1);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
        button.setBorder(BorderFactory.createCompoundBorder(line, compound));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
    }

    private void styleLabel(JLabel label, Color color, Font font) {
        label.setForeground(color);
        label.setFont(font);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == logOut) {
            // Perform logout action
            System.out.println("Logging out...");
            LoggedInState currentState = loggedInViewModel.getState();
            loggedInController.switchPageLogOut();
        } else if (evt.getSource() == searchItem) {
            // Perform search item action
            System.out.println("Searching for items...");
            LoggedInState currentState = loggedInViewModel.getState();
            loggedInController.switchPageSearch(currentState.getUsername());
        } else if (evt.getSource() == sellProduct) {
            // Perform sell product action
            System.out.println("Selling a product...");
            LoggedInState currentState = loggedInViewModel.getState();
            loggedInController.switchPageStorePage(currentState.getUsername());
        } else if (evt.getSource() == orders) {
            // Perform personal page action
            System.out.println("Accessing personal page...");
            LoggedInState currentState = loggedInViewModel.getState();
            loggedInController.switchPageOrder(currentState.getUsername());
        } else if (evt.getSource() == shoppingCart) {
            // Perform shopping cart action
            System.out.println("Accessing shopping cart...");
            LoggedInState currentState = loggedInViewModel.getState();
            loggedInController.switchPageShoppingCart(currentState.getUsername());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        usernameLabel.setText("Currently logged in: " + state.getUsername());
    }
}
