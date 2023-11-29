package view;
import app.ProductDetailsUseCaseFactory;
import data_access.ProductDAO;
import entity.LoginUser;
import entity.Product;
import entity.ProductFactory;
import entity.Seller;
import interface_adapter.ViewManagerModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;
import interface_adapter.signup.SignupViewModel;

import javax.imageio.IIOException;
import javax.swing.*;
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
import java.util.ArrayList;

public class StorePageView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Store Page";
    private JLabel sellerNameLabel;
    private JLabel sellerIdLabel;
    private JPanel productsPanel;
    private JButton createProductButton;

    public StorePageView(Seller seller) {
        setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel title = new JLabel("My Store Page");
        headerPanel.add(title);


        // Seller info
        sellerNameLabel = new JLabel(seller.getName());
        sellerIdLabel = new JLabel("Store ID: " + seller.getId());
        headerPanel.add(sellerNameLabel);
        headerPanel.add(sellerIdLabel);
        // Add the header panel to the top of the view
        add(headerPanel, BorderLayout.NORTH);
        // Products
        productsPanel = new JPanel();
        productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));
        for (Product product : seller.getProducts()) {
            addProduct(product);
        }

        // Create product button
        createProductButton = new JButton("Create a New Product");
        createProductButton.setSize(20, 10);
        createProductButton.addActionListener(e -> actionPerformed(e));

//        add(productsPanel, BorderLayout.NORTH);
        add(new JScrollPane(productsPanel), BorderLayout.CENTER);
        add(createProductButton, BorderLayout.SOUTH);
        // Set the initial size of the view
        setSize(800, 600);

    }

    private void addProduct(Product product) {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.X_AXIS));

        try {
            URL url = new URL(product.getURL());
            ImageIcon imageIcon = new ImageIcon(url);
            JLabel imageLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            productPanel.add(imageLabel);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            productPanel.add(new JLabel("ImageURL is broken"));
        }

        productPanel.add(new JLabel(product.getTitle()));
        productPanel.add(new JLabel("Price: $" + product.getPrice()));
        productPanel.add(new JLabel("Inventory: " + product.getInventory()));
        productPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                ViewManagerModel viewManagerModel = new ViewManagerModel();
                ProductViewModel pdViewModel = new ProductViewModel();
                ProductState state = new ProductState(product.getId(), product.getURL(), product.getTitle(), product.getPrice(), product.getInventory(), product.getReview());
                pdViewModel.setState(state);

                ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory()); //TODO: change to database

                ProductView pdView = ProductDetailsUseCaseFactory.createForSeller(viewManagerModel, pdViewModel, pdDAO);

                assert pdView != null;
                pdView.show();
                ProductController pdController = pdView.getProductController();
                pdController.execute(product.getID());
            }
        });

        productsPanel.add(productPanel);
        productsPanel.revalidate();
    }
//TODO: problem here, does not show title/name, create button too big, panel size weird.
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: go to createPd view
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//TODO: implement this
    }
}