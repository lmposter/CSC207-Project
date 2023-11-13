package app;

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
// need to add dao later
public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignUpUserDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignUpUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignUpUserOutputBoundary signupUserOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        BuyerFactory buyerFactory = new BuyerFactory();
        SellerFactory sellerFactory = new SellerFactory();

        SignUpUserInputBoundary userSignupInteractor = new SignUpUserInteractor(
                userDataAccessObject, signupUserOutputBoundary, buyerFactory, sellerFactory);

        return new SignupController(userSignupInteractor);
    }

}
