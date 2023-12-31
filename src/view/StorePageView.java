package view;

import app.CreatePdUseCaseFactory;
import app.ProductDetailsUseCaseFactory;
import data_access.ProductDAO;
import data_access.UserDataAccessObject;
import entity.LoginUser;
import entity.Product;
import entity.ProductFactory;
import entity.Seller;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.Create_product.CreatePdState;
import interface_adapter.Create_product.CreatePdViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;
import interface_adapter.signup.SignupState;
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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.store_page.StorePageController;
import interface_adapter.store_page.StorePageState;
import interface_adapter.store_page.StorePageViewModel;

public class StorePageView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "Store Page";
    private JLabel sellerNameLabel;
    private JLabel sellerIdLabel;
    private JPanel productsPanel;

    private StorePageController storePageController;

    private SellerViewModel sellerViewModel;
    private JButton createProductButton;
    private JButton returnPage;

    private final StorePageViewModel storePageViewModel;
    private JPanel headerPanel;

    public StorePageView(StorePageViewModel storePageViewModel, SellerViewModel sellerViewModel, StorePageController storePageController)
    {
        this.storePageViewModel = storePageViewModel;
        this.sellerViewModel = sellerViewModel;
        this.storePageController = storePageController;
        setLayout(new BorderLayout());
        headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel title = new JLabel("My Store Page");
        headerPanel.add(title);
        add(headerPanel, BorderLayout.NORTH);
        // Products
        productsPanel = new JPanel();
    }

    public void refreshView(ViewManagerModel viewManagerModel)
    {
        System.out.println("refreshed");
        // Clear existing products
        productsPanel.removeAll();
        if (storePageViewModel.getState().getUsername() != null)
        {
            Seller seller = (Seller) storePageController.get(storePageViewModel.getState().getUsername());
            if (seller != null)
            {
                // Seller info
                sellerNameLabel = new JLabel(seller.getName());
                sellerIdLabel = new JLabel("Store ID: " + seller.getId());
                headerPanel.add(sellerNameLabel);
                headerPanel.add(sellerIdLabel);
                // Add the header panel to the top of the view
                productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));
                for (Product product : storePageController.findProducts(seller.getName()))
                {
                    addProduct(product);
                }

                // Create product button
                createProductButton = new JButton("Create a New Product");
                createProductButton.setSize(20, 10);
                createProductButton.addActionListener(e -> actionPerformed(e));

                returnPage = new JButton("return");
                returnPage.setSize(20, 10);
                returnPage.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if (e.getSource().equals(returnPage))
                        {
                            viewManagerModel.setActiveView("seller logged in");
                        }
                    }
                });

                //        add(productsPanel, BorderLayout.NORTH);
                add(new JScrollPane(productsPanel), BorderLayout.CENTER);
                add(createProductButton, BorderLayout.SOUTH);
                // add(returnPage);
                // Set the initial size of the view
                setSize(800, 600);

            }
        } else
        {
            sellerNameLabel = new JLabel("Seller do not exist");
            headerPanel.add(sellerNameLabel);
        }

        // Revalidate and repaint the products panel
        productsPanel.revalidate();
        productsPanel.repaint();
    }

    public void addProduct(Product product)
    {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.X_AXIS));
        productPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        try
        {
            URL url = new URL(product.getURL());
            ImageIcon imageIcon = new ImageIcon(url);
            JLabel imageLabel = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
            productPanel.add(imageLabel);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
            productPanel.add(new JLabel("ImageURL is broken"));
        }

        productPanel.add(new JLabel("   ")); // Empty space for padding
        productPanel.add(new JLabel(product.getTitle()));
        productPanel.add(new JLabel("   ")); // Empty space for padding
        productPanel.add(new JLabel("Price: $" + product.getPrice()));
        productPanel.add(new JLabel("   ")); // Empty space for padding
        productPanel.add(new JLabel("Inventory: " + product.getInventory()));
        productPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

                ViewManagerModel viewManagerModel = new ViewManagerModel();
                ProductViewModel pdViewModel = new ProductViewModel();
                ProductState state = new ProductState(product.getId(), product.getURL(), product.getTitle(), product.getPrice(), product.getInventory(), product.getReview());
                pdViewModel.setState(state);
                ProductView pdView = ProductDetailsUseCaseFactory.createForSeller(viewManagerModel, pdViewModel, storePageController.getDAO());

                assert pdView != null;
                pdView.show();
                ProductController pdController = pdView.getProductController();
                pdController.execute(product.getID());
            }
        });

        productsPanel.add(productPanel);
        productsPanel.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        JFrame application = new JFrame("Create Product");

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        CreatePdViewModel createPdViewModel = new CreatePdViewModel();

        try
        {

            File f = new File("empty.csv");
            if (!(f.exists() && !f.isDirectory()))
            {
                FileWriter fileWriter = new FileWriter("empty.csv");
                String header = "id,title,inventory,URL,price,tags,reviews";
                fileWriter.write(header);
                fileWriter.close();
            }
            ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory());
            view.CreatePdView createPdView = CreatePdUseCaseFactory.create(viewManagerModel, createPdViewModel, pdDAO, sellerViewModel);
            assert createPdView != null;
            views.add(createPdView, createPdView.viewName);

            viewManagerModel.setActiveView(createPdView.viewName);
            viewManagerModel.firePropertyChanged();

            application.pack();
            application.setVisible(true);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Error reading file");//TODO: change to database
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        Object state = evt.getNewValue();
        if (state instanceof StorePageState)
        {
            StorePageState storePageState = (StorePageState) state;
            if (storePageState.getUsernameError() != null)
            {
                JOptionPane.showMessageDialog(this, storePageState.getUsernameError());
            }
            if (storePageState.getIdError() != null)
            {
                JOptionPane.showMessageDialog(this, storePageState.getIdError());
            }
            if (storePageState.getProductsError() != null)
            {
                JOptionPane.showMessageDialog(this, storePageState.getProductsError());
            }
        }
    }
}