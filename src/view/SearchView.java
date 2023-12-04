package view;

import app.ProductDetailsUseCaseFactory;
import data_access.ProductDAO;
import entity.Product;
import entity.ProductFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "Search";

    private final SearchViewModel searchViewModel;
    private final JTextField searchInputField = new JTextField(50);
    private final SearchController searchController;

    private final JButton returnPage;
    private final JButton goSearch;
    private JPanel mainPanel;


    public SearchView(SearchController controller, SearchViewModel searchViewModel)
    {
        this.searchController = controller;
        this.searchViewModel = searchViewModel;
        this.mainPanel = new JPanel();
        searchViewModel.addPropertyChangeListener(this);

        LabelTextPanel contentToSearch = new LabelTextPanel(new JLabel(SearchViewModel.SEARCH_LABEL), searchInputField);

        contentToSearch.setSize(200, 20);

        JPanel buttons = new JPanel();
        returnPage = new JButton("return");
        goSearch = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(goSearch);
        buttons.add(returnPage);

        JFrame frame = new JFrame(SearchViewModel.PRODUCT_PANEL_LABEL);
        frame.setSize(600, 400);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);

        goSearch.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (evt.getSource().equals(goSearch))
                {
                    SearchState currentState = searchViewModel.getState();
                    searchController.execute(currentState.getContent());
                    frame.setVisible(true);
                }
            }
        });

        returnPage.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (evt.getSource().equals(returnPage))
                {
                    searchController.switchPage();
                }
            }
        });

        searchInputField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                SearchState currentState = searchViewModel.getState();
                String text = searchInputField.getText() + e.getKeyChar();
                currentState.setContent(text);
                searchViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(contentToSearch);
        this.add(buttons);
        frame.setVisible(false);
    }

    public void actionPerformed(ActionEvent evt)
    {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        SearchState state = (SearchState) evt.getNewValue();
        if (state.getProductsError() == null)
        {
            // Clear existing product panels
            mainPanel.removeAll();
            mainPanel.add(new JLabel(state.getMessage()));
            // Add new product panels based on the updated search results
            ArrayList<Product> pdToShow = state.getProducts();
            for (Product pd : pdToShow)
            {
                JPanel productPanel = new JPanel();
                productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));


                try
                {
                    URL url = new URL(pd.getURL());
                    Image image = ImageIO.read(url).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    ImageIcon imageIcon = new ImageIcon(image);
                    JLabel imageLabel = new JLabel(imageIcon);
                    productPanel.add(imageLabel);


                } catch (IIOException | MalformedURLException e)
                {
                    e.printStackTrace();
                    productPanel.add(new JLabel("Image not available"));
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                productPanel.add(new JLabel("Price: $" + pd.getPrice()));
                productPanel.add(new JLabel("Inventory: " + pd.getInventory()));
                productPanel.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {

                        ViewManagerModel viewManagerModel = new ViewManagerModel();
                        ProductViewModel pdViewModel = new ProductViewModel();
                        ProductState state = new ProductState(pd.getId(), pd.getURL(), pd.getTitle(), pd.getPrice(), pd.getInventory(), pd.getReview());
                        pdViewModel.setState(state);
                        FileWriter fileWriter = null;
                        try
                        {
                            fileWriter = new FileWriter("empty.csv");
                            String header = "id,title,inventory,URL,price";
                            fileWriter.write(header);
                            fileWriter.close();
                        } catch (IOException ex)
                        {
                            throw new RuntimeException(ex);
                        }
                        ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory()); //TODO: change to database

                        ProductView pdView = ProductDetailsUseCaseFactory.createForBuyer(viewManagerModel, pdViewModel, pdDAO, searchViewModel);

                        assert pdView != null;
                        pdView.show();
                        ProductController pdController = pdView.getProductController();
                        pdController.execute(pd.getID());
                    }
                });
                mainPanel.add(productPanel);
            }

            // Refresh the mainPanel to show updated results
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

}