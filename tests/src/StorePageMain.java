package src;

import entity.Seller;
import interface_adapter.ViewManagerModel;
import interface_adapter.store_page.StorePageViewModel;
import view.StorePageView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

//public class StorePageMain {
//    public static void main(String[] args) throws IOException {
//        JFrame application = new JFrame("Create Product test");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//        JPanel views = new JPanel(cardLayout);
//
//        Seller seller = new Seller("testSeller", "12345678", "StestID123");
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
//}
