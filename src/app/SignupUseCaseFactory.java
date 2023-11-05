package app;

import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignUpDataAccessInterface;
import interface_adapter.*;
import view.SignupView;
import entity.GuestFactory;
import entity.SellerFactory;
import entity.BuyerFactory;

import javax.swing.*;
import java.io.IOException;
// need to add dao later
public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignUpDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignUpDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
//        SignUpOutputBoundary signupOutputBoundary = null;
//        new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
//        BuyerFactory buyerFactory = new BuyerFactory();
//        SellerFactory sellerFactory = new SellerFactory();
//        GuestFactory guestFactory = new GuestFactory();
//        SignUpInputBoundary userSignupInteractor = new SignupInteractor(
//                userDataAccessObject, signupOutputBoundary, userFactory, buyerFactory);
        //userSignupInteractor
        return new SignupController();
    }

}
