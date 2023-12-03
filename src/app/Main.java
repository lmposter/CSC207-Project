package app;

import data_access.ProductDAO;
import data_access.UserDataAccessObject;
import entity.BuyerFactory;
import entity.ProductFactory;
import entity.Seller;
import entity.SellerFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.buyerPage.BuyerViewModel;
import interface_adapter.guestPage.GuestViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.sellerPage.SellerViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("*Amazoff: Buy-Bye Budget* Your #1 Choice for Shopping! ");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        GuestViewModel guestViewModel = new GuestViewModel();
        BuyerViewModel buyerViewModel = new BuyerViewModel();
        SellerViewModel sellerViewModel = new SellerViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        SearchViewModel searchViewModel = new SearchViewModel();
        try {FileWriter fileWriter = new FileWriter("empty.csv");
        String header = "id,title,inventory,URL,price";
        fileWriter.write(header);
        fileWriter.close();} catch (Exception e){
            e.printStackTrace();
        }
        ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory());



        UserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new UserDataAccessObject(new BuyerFactory(), new SellerFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        InitializeProject screen = new InitializeProject("resources/loading.gif");
        screen.load(5);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, guestViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, buyerViewModel, sellerViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        GuestView guestView = GuestUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, guestViewModel, searchViewModel, null, null, null, userDataAccessObject);
        views.add(guestView, guestView.viewName);

        BuyerView buyerView = BuyerUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, buyerViewModel, searchViewModel, null, null, null, userDataAccessObject);
        views.add(buyerView, buyerView.viewName);

        SellerView sellerView = SellerUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, sellerViewModel, searchViewModel, null, null, null, userDataAccessObject);
        views.add(sellerView, sellerView.viewName);

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, searchViewModel, pdDAO);
        views.add(searchView, searchView.viewName);

        Seller seller = new Seller("testSeller", "12345678", "StestID123");
        view.StorePageView storePageView = new StorePageView(seller);
        views.add(storePageView, storePageView.viewName);

//        viewManagerModel.setActiveView(searchView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}