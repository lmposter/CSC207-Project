package view;

import interface_adapter.product.ProductController;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "product details";
    private final ProductViewModel productViewModel;
    private final ProductController productController;

    private final JButton buy;
    private final JButton add_to_cart;
    private final JButton check_reviews;


    public ProductView(ProductController controller, ProductViewModel productViewModel) {

        this.productController = controller;
        this.productViewModel = productViewModel;
        productViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ProductViewModel.TITLE_LABEL + productViewModel.getState().getTitle());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        JLabel price = new JLabel(ProductViewModel.PRICE_LABEL + productViewModel.getState().getPrice());
        JLabel inventory = new JLabel(ProductViewModel.INVENTORY_LABEL+ productViewModel.getState().getInventory());
        price.setAlignmentX(Component.RIGHT_ALIGNMENT);
        inventory.setAlignmentX(Component.LEFT_ALIGNMENT);
        //TODO:show photo
        buy = new JButton(ProductViewModel.PURCHASE_LABEL);
        add_to_cart = new JButton(ProductViewModel.ADD_TO_CART_LABEL);
        check_reviews = new JButton(ProductViewModel.REVIEW_LABEL);
        buttons.add(buy);
        buttons.add(add_to_cart);
        buttons.add(check_reviews);

        buy.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        //TODO: buy this product, add to orders
                    }
                }
        );

        add_to_cart.addActionListener(
                 new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        //TODO: add_to_cart
                    }
                }
        );

        check_reviews.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        //TODO: show reviews
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ProductState state = (ProductState) evt.getNewValue();
        if (state.getPdIDError() != null) {
            JOptionPane.showMessageDialog(this, state.getPdIDError());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }
}
