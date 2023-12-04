package view;

import interface_adapter.AllUserPage.sellerPage.SellerController;
import interface_adapter.AllUserPage.sellerPage.SellerState;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * SellerView represents the graphical user interface for the seller's dashboard.
 */
public class SellerView extends JPanel implements ActionListener, PropertyChangeListener {

    // Constants
    public final String viewName = "logged in";
    private final SellerViewModel sellerViewModel;
    private final SellerController sellerController;

    // GUI Components
    JLabel title;
    JLabel usernameLabel;
    JLabel balanceLabel;
    JLabel shopLabel;
    JLabel imageLabel;
    final JButton logOut;
    final JButton searchItem;
    final JButton sellProduct;
    final JButton orders;

    /**
     * Constructs a SellerView with the provided view model and controller.
     *
     * @param sellerViewModel The view model for the seller's dashboard.
     * @param sellerController The controller for managing seller actions.
     */
    public SellerView(SellerViewModel sellerViewModel, SellerController sellerController) {
        this.sellerViewModel = sellerViewModel;
        this.sellerController = sellerController;
        this.sellerViewModel.addPropertyChangeListener(this);

        // Initialize GUI components
        title = new JLabel("My Page");
        styleLabel(title, Color.BLACK, new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameLabel = new JLabel("Welcome back!");
        styleLabel(usernameLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        balanceLabel = new JLabel("Total Money Earned $0.00");
        styleLabel(balanceLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon imageIcon = new ImageIcon("resources/guest.png"); // Replace with the path to your image
        imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        shopLabel = new JLabel("Sell some stuff ... ");
        styleLabel(shopLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        shopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Add Search Item Button
        searchItem = new JButton(SellerViewModel.SEARCH_ITEM_LABEL);
        styleButton(searchItem, Color.GRAY, Color.BLACK);
        buttons.add(searchItem);

        // Add Sell Product Button
        sellProduct = new JButton(SellerViewModel.SELL_PRODUCT_LABEL);
        styleButton(sellProduct, Color.GRAY, Color.BLACK);
        buttons.add(sellProduct);

        // Add Personal Page Button
        orders = new JButton(SellerViewModel.PERSONAL_PAGE_LABEL);
        styleButton(orders, Color.GRAY, Color.BLACK);
        buttons.add(orders);

        // Add Log Out Button
        logOut = new JButton(SellerViewModel.LOGOUT_BUTTON_LABEL);
        styleButton(logOut, Color.GRAY, Color.BLACK);
        buttons.add(logOut);

        // Add action listeners
        logOut.addActionListener(this);
        searchItem.addActionListener(this);
        sellProduct.addActionListener(this);
        orders.addActionListener(this);

        // Set up the layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameLabel);
        this.add(imageLabel);
        this.add(balanceLabel);
        this.add(shopLabel);
        this.add(buttons);
    }

    // Helper method to style buttons
    private void styleButton(JButton button, Color bgColor, Color fgColor) {
        // Styling button appearance
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

    // Helper method to style labels
    private void styleLabel(JLabel label, Color color, Font font) {
        label.setForeground(color);
        label.setFont(font);
    }

    /**
     * Handles button click events.
     *
     * @param evt The ActionEvent representing the button click event.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == logOut) {
            // Perform logout action
            System.out.println("Logging out...");
            SellerState currentState = sellerViewModel.getState();
            sellerController.switchPageLogOut();
        } else if (evt.getSource() == searchItem) {
            // Perform search item action
            System.out.println("Searching for items...");
            SellerState currentState = sellerViewModel.getState();
            sellerController.switchPageSearch(currentState.getUsername());
        } else if (evt.getSource() == sellProduct) {
            // Perform sell product action
            System.out.println("Selling a product...");
            SellerState currentState = sellerViewModel.getState();
            sellerController.switchPageStorePage(currentState.getUsername());
        } else if (evt.getSource() == orders) {
            // Perform personal page action
            System.out.println("Accessing personal page...");
            SellerState currentState = sellerViewModel.getState();
            sellerController.switchPageOrder(currentState.getUsername());
        }
    }

    /**
     * Handles property change events.
     *
     * @param evt The PropertyChangeEvent representing the change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SellerState state = (SellerState) evt.getNewValue();
        title.setText(state.getUsername() + "'s Personal Dashboard");
        usernameLabel.setText("Welcome back! Seller " + state.getUsername());
    }
}