package view;

import app.ProductDetailsUseCaseFactory;
import data_access.ProductDAO;
import entity.Product;
import entity.ProductFactory;
import interface_adapter.AllUserPage.buyerPage.BuyerController;
import interface_adapter.AllUserPage.buyerPage.BuyerState;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;
import interface_adapter.search.SearchViewModel;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * BuyerView represents the graphical user interface for the buyer's dashboard.
 */
public class BuyerView extends JPanel implements ActionListener, PropertyChangeListener
{

    // Constants
    public final String viewName = "buyer logged in";
    private final BuyerViewModel buyerViewModel;
    private final BuyerController buyerController;

    // GUI Components
    JLabel title;
    JLabel usernameLabel;
    JLabel balanceLabel;
    JLabel shopLabel;
    JLabel imageLabel;
    final JButton logOut;
    final JButton searchItem;
    // final JButton sellProduct;
    final JButton orders;
    final JButton shoppingCart;

    /**
     * Constructs a BuyerView with the provided view model and controller.
     *
     * @param buyerViewModel  The view model for the buyer's dashboard.
     * @param buyerController The controller for managing buyer actions.
     */
    public BuyerView(BuyerViewModel buyerViewModel, BuyerController buyerController)
    {
        this.buyerViewModel = buyerViewModel;
        this.buyerController = buyerController;
        this.buyerViewModel.addPropertyChangeListener(this);

        // Initialize GUI components
        title = new JLabel("My Page");
        styleLabel(title, Color.BLACK, new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameLabel = new JLabel("Welcome back!");
        styleLabel(usernameLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        balanceLabel = new JLabel("Total Balance $0.00");
        styleLabel(balanceLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon imageIcon = new ImageIcon("resources/guest.png"); // Replace with the path to your image
        imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        shopLabel = new JLabel("Keep shopping for ... ");
        styleLabel(shopLabel, Color.BLACK, new Font("Arial", Font.PLAIN, 14));
        shopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Add Search Item Button
        searchItem = new JButton(BuyerViewModel.SEARCH_ITEM_LABEL);
        styleButton(searchItem, Color.GRAY, Color.BLACK);
        buttons.add(searchItem);

        // Add Sell Product Button
//        sellProduct = new JButton(BuyerViewModel.SELL_PRODUCT_LABEL);
//        styleButton(sellProduct, Color.GRAY, Color.BLACK);
//        buttons.add(sellProduct);

        // Add Personal Page Button
        orders = new JButton("Orders");
        styleButton(orders, Color.GRAY, Color.BLACK);
        buttons.add(orders);

        // Add Shopping Cart Button
        shoppingCart = new JButton(BuyerViewModel.SHOPPING_CART_LABEL);
        styleButton(shoppingCart, Color.GRAY, Color.BLACK);
        buttons.add(shoppingCart);

        // Add Log Out Button
        logOut = new JButton(BuyerViewModel.LOGOUT_BUTTON_LABEL);
        styleButton(logOut, Color.GRAY, Color.BLACK);
        buttons.add(logOut);

        // Add action listeners
        logOut.addActionListener(this);
        searchItem.addActionListener(this);
        // sellProduct.addActionListener(this);
        orders.addActionListener(this);
        shoppingCart.addActionListener(this);

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
    private void styleButton(JButton button, Color bgColor, Color fgColor)
    {
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
    private void styleLabel(JLabel label, Color color, Font font)
    {
        label.setForeground(color);
        label.setFont(font);
    }

    /**
     * Handles button click events.
     *
     * @param evt The ActionEvent representing the button click event.
     */
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == logOut)
        {
            // Perform logout action
            System.out.println("Logging out...");
            BuyerState currentState = buyerViewModel.getState();
            buyerController.switchPageLogOut();
        } else if (evt.getSource() == searchItem)
        {
            // Perform search item action
            System.out.println("Searching for items...");
            BuyerState currentState = buyerViewModel.getState();
            buyerController.switchPageSearch(currentState.getUsername());
        } else if (evt.getSource() == orders)
        {
            // Perform personal page action
            System.out.println("Accessing personal page...");
            BuyerState currentState = buyerViewModel.getState();
            buyerController.switchPageOrder(currentState.getUsername());
        } else if (evt.getSource() == shoppingCart)
        {
            // Perform shopping cart action
            System.out.println("Accessing shopping cart...");
            //            BuyerState currentState = buyerViewModel.getState();
            //            buyerController.switchPageShoppingCart(currentState.getUsername());
            if (buyerViewModel.getState().getCart().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Currently empty");
            } else
            {
                JPanel cart = new JPanel();

                double price = 0.0;

                JFrame frame = new JFrame(buyerViewModel.getState().getUsername() + "'s Shopping Cart");
                frame.setSize(600, 400);

                cart.setLayout(new BoxLayout(cart, BoxLayout.Y_AXIS));
                JScrollPane scrollPane = new JScrollPane(cart);
                frame.add(scrollPane);

                for (Product p : buyerViewModel.getState().getCart())
                {
                    price += p.getPrice();

                    JPanel productPanel = new JPanel();
                    productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

                    try
                    {
                        URL url = new URL(p.getURL());
                        Image image = ImageIO.read(url).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                        ImageIcon imageicon = new ImageIcon(image);
                        JLabel imageLabel = new JLabel(imageicon);
                        productPanel.add(imageLabel);
                    } catch (IIOException | MalformedURLException e)
                    {
                        e.printStackTrace();
                        productPanel.add(new JLabel("Image not available"));
                    } catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                    productPanel.add(new JLabel("Price: $" + p.getPrice()));
                    productPanel.add(new JLabel("Inventory: " + p.getInventory()));

                    cart.add(productPanel);
                }
                JLabel totalPrice = new JLabel("Total Price: " + String.valueOf(price));
                cart.add(totalPrice);
                frame.setVisible(true);
            }
        }
    }

    /**
     * Handles property change events.
     *
     * @param evt The PropertyChangeEvent representing the change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        BuyerState state = (BuyerState) evt.getNewValue();
        title.setText(state.getUsername() + "'s Personal Dashboard");
        usernameLabel.setText("Welcome back! Customer " + state.getUsername());
    }
}