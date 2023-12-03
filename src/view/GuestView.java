package view;

import interface_adapter.guestPage.GuestController;
import interface_adapter.guestPage.GuestState;
import interface_adapter.guestPage.GuestViewModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;

/**
 * GuestView represents the graphical user interface for the guest user's dashboard.
 */
public class GuestView extends JPanel implements ActionListener, PropertyChangeListener {

    // Constants
    public final String viewName = "guest logged in";
    private final GuestViewModel guestViewModel;
    private final GuestController guestController;

    // GUI Components
    JLabel title;
    JLabel usernameLabel;
    JLabel balanceLabel;
    JLabel shopLabel;
    JLabel imageLabel;
    final JButton logOut;
    final JButton searchItem;

    /**
     * Constructs a GuestView with the provided view model and controller.
     *
     * @param guestViewModel  The view model for the guest user's dashboard.
     * @param guestController The controller for managing guest user actions.
     */
    public GuestView(GuestViewModel guestViewModel, GuestController guestController) {
        this.guestViewModel = guestViewModel;
        this.guestController = guestController;
        this.guestViewModel.addPropertyChangeListener(this);

        // Initialize GUI components
        title = new JLabel("My Page");
        styleLabel(title, Color.BLACK, new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameLabel = new JLabel("Welcome back!");
        styleLabel(usernameLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        balanceLabel = new JLabel("Please Login to access your balance ...");
        styleLabel(balanceLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon imageIcon = new ImageIcon("resources/guest.png"); // Replace with the path to your image
        imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        shopLabel = new JLabel("Please Login to access your shop ...");
        styleLabel(shopLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        shopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Add Search Item Button
        searchItem = new JButton(GuestViewModel.SEARCH_ITEM_LABEL);
        styleButton(searchItem, Color.GRAY, Color.BLACK);
        buttons.add(searchItem);

        // Add Log Out Button
        logOut = new JButton(GuestViewModel.LOGOUT_BUTTON_LABEL);
        styleButton(logOut, Color.GRAY, Color.BLACK);
        buttons.add(logOut);

        // Add action listeners
        logOut.addActionListener(this);
        searchItem.addActionListener(this);

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
            GuestState currentState = guestViewModel.getState();
            guestController.switchPageLogOut();
        } else if (evt.getSource() == searchItem) {
            // Perform search item action
            System.out.println("Searching for items...");
            GuestState currentState = guestViewModel.getState();
            guestController.switchPageSearch(currentState.getUsername());
        }
    }

    /**
     * Handles property change events.
     *
     * @param evt The PropertyChangeEvent representing the change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GuestState state = (GuestState) evt.getNewValue();
        title.setText(state.getUsername() + "'s Personal Dashboard");
        usernameLabel.setText("Welcome back! Guest " + state.getUsername());
    }
}