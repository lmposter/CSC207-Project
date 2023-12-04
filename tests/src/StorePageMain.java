package src;

import app.CreatePdUseCaseFactory;
import app.SignupUseCaseFactory;
import data_access.ProductDAO;
import data_access.UserDataAccessObject;
import entity.BuyerFactory;
import entity.ProductFactory;
import entity.Seller;
import entity.SellerFactory;
import interface_adapter.Create_product.CreatePdViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import view.StorePageView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class StorePageMain {
//    public static void main(String[] args) throws IOException {
//        JFrame application = new JFrame("Create Product test");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//        JPanel views = new JPanel(cardLayout);
//
//        view.StorePageView storePageView = new StorePageView(storePageViewModel, userDataAccessObject);
//        views.add(storePageView, storePageView.viewName);
//        application.add(views);
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(views, cardLayout, viewManagerModel);
//
//        StorePageViewModel storePageViewModel = new StorePageViewModel();
//
//        viewManagerModel.setActiveView(storePageView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        application.pack();
//        application.setVisible(true);
//    }
}
