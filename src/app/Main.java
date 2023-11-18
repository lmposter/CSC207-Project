package app;

import data_access.UserDataAcessObject;
//import entity.CommonUserFactory;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.store_page.StorePageViewModel;
import interface_adapter.personal_page.PersonalPageViewModel;
import view.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

// need dao for singupcase factory and user case factory
public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Login Example");
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
        SignupViewModel signupViewModel = new SignupViewModel();
        StorePageViewModel storePageViewModel = new StorePageViewModel();
        PersonalPageViewModel personalPageViewModel = new PersonalPageViewModel();
        UserDataAcessObject dataAcessObject = new UserDataAcessObject();
//        FileUserDataAccessObject userDataAccessObject;
//        try {
//            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, dataAcessObject);
        views.add(signupView, signupView.viewName);

//        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, storePageViewModel, personalPageViewModel);
//        views.add(loginView, loginView.viewName);

//        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
//        views.add(loggedInView, loggedInView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}