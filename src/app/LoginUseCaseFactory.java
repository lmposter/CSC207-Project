package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.buyerPage.BuyerViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.sellerPage.SellerViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

/**
 * The LoginUseCaseFactory class is responsible for creating and setting up the components required for the login user case.
 */
public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    /**
     * Creates a LoginView for the login user case with the provided components and configurations.
     *
     * @param viewManagerModel    The ViewManagerModel to manage views.
     * @param loginViewModel      The LoginViewModel for the login functionality.
     * @param signupViewModel     The SignupViewModel for the signup functionality.
     * @param buyerViewModel      The BuyerViewModel for the buyer functionality.
     * @param sellerViewModel     The SellerViewModel for the seller functionality.
     * @param userDataAccessObject The data access object for user data.
     * @return                    A LoginView instance for the login user case.
     */
    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SellerViewModel sellerViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        try {
            // Create the LoginController and pass it to the LoginView
            LoginController loginController = createLoginUseCase(
                    viewManagerModel, loginViewModel, signupViewModel,
                    buyerViewModel, sellerViewModel, userDataAccessObject);

            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates the LoginController and sets up the necessary interactions.
     *
     * @param viewManagerModel    The ViewManagerModel to manage views.
     * @param loginViewModel      The LoginViewModel for the login functionality.
     * @param signupViewModel     The SignupViewModel for the signup functionality.
     * @param buyerViewModel      The BuyerViewModel for the buyer functionality.
     * @param sellerViewModel     The SellerViewModel for the seller functionality.
     * @param userDataAccessObject The data access object for user data.
     * @return                    A LoginController instance for the login user case.
     * @throws IOException        If there is an issue with the data access object.
     */
    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            SignupViewModel signupViewModel,
            BuyerViewModel buyerViewModel,
            SellerViewModel sellerViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException {

        // Create the LoginPresenter and pass it to the LoginController
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(
                viewManagerModel, buyerViewModel, sellerViewModel, loginViewModel, signupViewModel);

        // Create the LoginInteractor and pass it to the LoginController
        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}