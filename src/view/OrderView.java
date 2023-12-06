package view;

import interface_adapter.API.DatabaseAPI;
import interface_adapter.orders.OrderController;
import interface_adapter.orders.OrderViewModel;
import interface_adapter.search.SearchViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class OrderView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Order";

    private final JPanel pdPanel;

    private final OrderViewModel orderViewModel;

    private final OrderController orderController;

    private final SearchViewModel searchViewModel;

    JLabel title;

    JButton backButton;

    public OrderView(OrderController orderController, OrderViewModel orderViewModel, boolean showButtons, SearchViewModel searchViewModel) {
        this.pdPanel = new JPanel();
        this.orderViewModel = orderViewModel;
        this.orderController = orderController;
        this.searchViewModel = searchViewModel;
        this.orderViewModel.addPropertyChangeListener(this);

        // Use BoxLayout with Y_AXIS alignment
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Create a title label
        title = new JLabel("Personal Orders");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.ORANGE);
        title.setOpaque(true);
        title.setBackground(new Color(60, 60, 60));
        this.add(title);

        if (showButtons){
            initComponents(true);
        };

        backButton = new JButton("Back");
        styleButton(backButton, new Color(0, 0, 0), Color.WHITE);
        this.add(backButton);
        backButton.addActionListener(this);


    }

    public void initComponents(boolean showButtons) {
        System.out.println("refreshed");
        List<String[]> productsData = DatabaseAPI.findProducts(orderViewModel.getState().getUsername());
        if (productsData != null){
        for (String[] productData : productsData) {
            String title = productData[1];
            String price = productData[2];
            System.out.println(title + price);

            JLabel pdTitle = new JLabel("Title: " + title);
            JLabel priceLabel = new JLabel("Price: $" + price);

            pdTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
            priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            if (showButtons) {
                JButton buyButton = new JButton("Delivered");
                styleButton(buyButton, new Color(173, 216, 230), Color.BLACK);

                // Add action listener for the button
                buyButton.addActionListener(this);

                // Set action command to identify the product
                buyButton.setActionCommand(title);

                // Add components to the main panel
                this.add(pdTitle);
                this.add(priceLabel);
                this.add(buyButton);
            } else {
                JPanel productPanel = new JPanel();
                productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

                productPanel.add(pdTitle);
                productPanel.add(priceLabel);

                // Add productPanel to the main panel
                this.add(productPanel);
            }

            this.add(Box.createRigidArea(new Dimension(0, 10))); // Add some spacing between products
        }
        this.revalidate();}
    }

    private void styleButton(@NotNull JButton button, Color bgColor, Color fgColor) {
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

    public static List<String[]> getHardcodedProductsData(int numProducts) {
        List<String[]> productsData = new java.util.ArrayList<>();

        for (int i = 0; i < numProducts; i++) {
            String[] product = new String[3];
            product[0] = String.valueOf(i); // ID
            product[1] = "Sample Product " + (i + 1); // Title
            product[2] = "123"; // Price
            productsData.add(product);
        }

        return productsData;
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(backButton)) {
            orderController.switchPage();
        }
    }

    @Override
    public void propertyChange(@NotNull PropertyChangeEvent evt) {
        // Handle property changes if needed
    }
}
