package src;

import app.CreatePdUseCaseFactory;
import app.SearchUseCaseFactory;
import data_access.ProductDAO;
import entity.ProductFactory;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.Create_product.CreatePdViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchViewModel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePdMain {
    public static void main(String[] args) throws IOException {
    JFrame application = new JFrame("Create Product test");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    CardLayout cardLayout = new CardLayout();

    // The various View objects. Only one view is visible at a time.
    JPanel views = new JPanel(cardLayout);
        application.add(views);

    // This keeps track of and manages which view is currently showing.
    ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

    CreatePdViewModel createPdViewModel = new CreatePdViewModel();
    SellerViewModel sellerViewModel = new SellerViewModel();

    FileWriter fileWriter = new FileWriter("empty.csv");
    String header = "id,title,inventory,URL,price";
        fileWriter.write(header);
        fileWriter.close();
    ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory());

    view.CreatePdView createPdView = CreatePdUseCaseFactory.create(viewManagerModel, createPdViewModel, pdDAO, sellerViewModel);
        assert createPdView != null;
        views.add(createPdView, createPdView.viewName);

        viewManagerModel.setActiveView(createPdView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
}}
