package view;

import entity.Review;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ProductView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "Product Details";

    private final SearchViewModel searchViewModel;
    private final ProductViewModel productViewModel;
    private final ProductController productController;
    private JButton buy;
    private JButton add_to_cart;
    private JButton closeButton;
    private final JPanel pdPanel;

    public ProductView(ProductController controller, ProductViewModel productViewModel, boolean showButtons, SearchViewModel searchViewModel, BuyerViewModel buyerViewModel)
    {
        this.searchViewModel = searchViewModel;
        JFrame application = new JFrame(this.viewName);
        CardLayout cardLayout = new CardLayout();
        this.productController = controller;
        this.productViewModel = productViewModel;
        productViewModel.addPropertyChangeListener(this);
        this.pdPanel = new JPanel(cardLayout);

        application.setSize(600, 400);

        pdPanel.setLayout(new BoxLayout(pdPanel, BoxLayout.Y_AXIS));

        JLabel pdTitle = new JLabel(productViewModel.getState().getTitle().concat("\n"));
        JLabel price = new JLabel(ProductViewModel.PRICE_LABEL.concat(String.valueOf(productViewModel.getState().getPrice())).concat("\n"));
        JLabel inventory = new JLabel(ProductViewModel.INVENTORY_LABEL.concat(String.valueOf(productViewModel.getState().getInventory())).concat("\n"));
        ArrayList<Review> reviewList = productViewModel.getState().getReviews();
        String reviewListStr = Review.printReviews(reviewList);
        JLabel reviews = new JLabel(ProductViewModel.REVIEW_LABEL.concat("\n").concat(reviewListStr).concat("\n"));

        pdTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventory.setAlignmentX(Component.CENTER_ALIGNMENT);
        reviews.setAlignmentX(Component.CENTER_ALIGNMENT);


        try
        {
            URL url = new URL(productViewModel.getState().getURL());
            Image image = ImageIO.read(url).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(imageIcon);
            pdPanel.add(imageLabel);

        } catch (IIOException | MalformedURLException e)
        {
            pdPanel.add(new JLabel("Image not available in ProductView"));
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        pdPanel.add(pdTitle);
        pdPanel.add(price);
        pdPanel.add(inventory);
        pdPanel.add(reviews);

        if (showButtons)
        {
            this.buy = new JButton(ProductViewModel.PURCHASE_LABEL);
            this.add_to_cart = new JButton(ProductViewModel.ADD_TO_CART_LABEL);
            this.closeButton = new JButton(ProductViewModel.CLOSE);
            pdPanel.add(buy);
            pdPanel.add(add_to_cart);
            pdPanel.add(closeButton);


            buy.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    SearchState searchState = searchViewModel.getState();
                    ProductState productState = productViewModel.getState();
                    productController.buyProduct(searchState.getUsername(), productState.getID(), productState.getTitle(), productState.getPrice());
//                    JOptionPane.showConfirmDialog(pdPanel,"Purchase feature is coming soon!");
                }
            });

            add_to_cart.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    if (searchViewModel.getState().isBuyer())
                    {
                        buyerViewModel.getState().addProduct(productViewModel.getState().getProduct());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(pdPanel,"Log in to use shopping cart");
                    }
                }
            });

            closeButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    application.dispose();
                }
            });
        }


        JLabel title = new JLabel(ProductViewModel.TITLE_LABEL);
        application.add(title);
        application.add(pdPanel);
        pdPanel.setVisible(true);
        application.add(pdPanel);
        application.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        ProductState state = (ProductState) evt.getNewValue();
        if (state.getPdIDError() != null)
        {
            JOptionPane.showMessageDialog(this, state.getPdIDError());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Click " + e.getActionCommand());
    }

    public ProductController getProductController()
    {
        return productController;
    }
}