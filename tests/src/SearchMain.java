package src;

import app.SearchUseCaseFactory;
import data_access.ProductDAO;
import entity.ProductFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchViewModel;
import view.SearchView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class SearchMain
{
    public static void main(String[] args) throws IOException
    {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Search test");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SearchViewModel searchViewModel = new SearchViewModel();

        FileWriter fileWriter = new FileWriter("empty.csv");
        String header = "id,title,inventory,URL,price";
        fileWriter.write(header);
        fileWriter.close();
        ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory());

        view.SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, searchViewModel, pdDAO);
        assert searchView != null;
        views.add(searchView, searchView.viewName);


        viewManagerModel.setActiveView(searchView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
