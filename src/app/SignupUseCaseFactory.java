package app;

import entity.GuestFactory;
import interface_adapter.guestPage.GuestViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignUpUserDataAccessInterface;
import interface_adapter.*;
import use_case.signup.SignUpUserInputBoundary;
import use_case.signup.SignUpUserInteractor;
import use_case.signup.SignUpUserOutputBoundary;
import view.SignupView;
import entity.SellerFactory;
import entity.BuyerFactory;

import javax.swing.*;
import java.io.IOException;

/**
 * Factory class for creating instances related to the Signup use case.
 * This class handles the setup of controllers, presenters, and views for the signup process.
 */
public class SignupUseCaseFactory {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private SignupUseCaseFactory() {}

    /**
     * Creates and returns a SignupView instance with all necessary dependencies.
     *
     * @param viewManagerModel     Model for managing views.
     * @param loginViewModel       ViewModel associated with login.
     * @param signupViewModel      ViewModel for signup.
     * @param guestViewModel    ViewModel for logged in state.
     * @param userDataAccessObject Data access object for user data.
     * @return SignupView instance or null in case of failure.
     */
    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, GuestViewModel guestViewModel, SignUpUserDataAccessInterface userDataAccessObject) {
        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, guestViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Private helper method to create a SignupController.
     * Sets up the necessary interactions and dependencies for the signup process.
     *
     * @param viewManagerModel     Model for managing views.
     * @param signupViewModel      ViewModel for signup.
     * @param loginViewModel       ViewModel associated with login.
     * @param guestViewModel    ViewModel for logged in state.
     * @param userDataAccessObject Data access object for user data.
     * @return SignupController instance.
     * @throws IOException If there is an issue accessing user data.
     */
    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, GuestViewModel guestViewModel, SignUpUserDataAccessInterface userDataAccessObject) throws IOException {

        // Create presenter for signup.
        SignUpUserOutputBoundary signupUserOutputBoundary =
                new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel, guestViewModel);

        // Factories for different user types.
        GuestFactory guestFactory = new GuestFactory();
        BuyerFactory buyerFactory = new BuyerFactory();
        SellerFactory sellerFactory = new SellerFactory();

        // Create the interactor for user signup.
        SignUpUserInputBoundary userSignupInteractor = new SignUpUserInteractor(
                userDataAccessObject, signupUserOutputBoundary, guestFactory, buyerFactory, sellerFactory);

        // Return a new controller for the signup.
        return new SignupController(userSignupInteractor);
    }

}