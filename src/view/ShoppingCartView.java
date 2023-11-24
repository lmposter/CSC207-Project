package view;

import entity.Product;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.shopping_cart.checkOut.CheckOutController;

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

public class ShoppingCartView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "shopping cart";

    private final ShoppingCartViewModel shoppingCartViewModel;

    private final CheckOutController checkOutController;

    private final LoggedInViewModel loggedInViewModel;

    private final JPanel mainPanel;
    private final JButton checkOut;
    private final JButton store;

    public ShoppingCartView(ShoppingCartViewModel shoppingCartViewModel, CheckOutController checkOutController, LoggedInViewModel loggedInViewModel)
    {
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.checkOutController = checkOutController;
        this.loggedInViewModel = loggedInViewModel;

        this.mainPanel = new JPanel();
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
                            //TODO: Switch to Store Page
                        }
                    }
                }
        );

        for (Product product : shoppingCartViewModel.getState())
        {
            JPanel subpanel = createProductPanel(product.getTitle(), product.getPrice(), product.getURL());
            this.mainPanel.add(subpanel);
        }

        this.mainPanel.add(buttons);

    }

    /**
     *
     * @param name title
     * @param p price
     * @param imageUrl url of image
     * @return a subpanel for this product
     */
    private JPanel createProductPanel(String name, double p, String imageUrl)
    {
        JPanel productPanel = new JPanel();

        JLabel title = new JLabel(name);
        JLabel price = new JLabel(String.valueOf(p));

        try
        {
            URL url = new URL(imageUrl);
            Image image = ImageIO.read(url).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(imageIcon);
            productPanel.add(imageLabel);
        } catch (IIOException | MalformedURLException e) {
            productPanel.add(new JLabel("Image not available in ProductView"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        productPanel.add(title);
        productPanel.add(price);

        JButton remove = new JButton();

        remove.addActionListener(
                new ActionListener()
                {
                @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if (e.getSource().equals(remove))
                        {
                            // TODO: remove this product from shopping cart
                        }
                    }
                }
        );

        productPanel.add(remove);

        return productPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
