package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInController;
import interface_adapter.logged_in.LoggedInPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.loggedIn.LoggedInInputBoundary;
import use_case.loggedIn.LoggedInInteractor;
import use_case.loggedIn.LoggedInOutputBoundary;
import use_case.loggedIn.LoggedInUserDataAccessInterface;
import view.LoggedInView;

import javax.swing.*;
import java.io.IOException;

public class LoggedInUseCaseFactory {

    /** Prevent instantiation. */
    private LoggedInUseCaseFactory() {}

    public static LoggedInView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            LoggedInViewModel loggedInViewModel,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel,
            LoggedInUserDataAccessInterface userDataAccessObject) {

        try {
            LoggedInController loggedInController = createLoginUseCase(viewManagerModel, loginViewModel, signupViewModel, loggedInViewModel, userDataAccessObject, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);
            return new LoggedInView(loggedInViewModel, loggedInController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoggedInController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            LoggedInViewModel loggedInViewModel,
            LoggedInUserDataAccessInterface userDataAccessObject,
            SearchViewModel searchViewModel,
            Orders orderViewModel,
            ShoppingCartViewModel shoppingCartViewModel,
            StorePageViewModel storePageViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LoggedInOutputBoundary loggedInOutputBoundary = new LoggedInPresenter(signupViewModel, viewManagerModel, loggedInViewModel, loginViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);


        LoggedInInputBoundary loggedInInteractor = new LoggedInInteractor(
                userDataAccessObject, loggedInOutputBoundary);

        return new LoggedInController(loggedInInteractor);
    }
}
