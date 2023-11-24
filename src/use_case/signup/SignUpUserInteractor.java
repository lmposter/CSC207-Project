package use_case.signup;

import entity.*;

import java.util.List;

/**
 * Interactor for handling user signup use case.
 */
public class SignUpUserInteractor implements SignUpUserInputBoundary {

    private final SignUpUserDataAccessInterface userDataAccessObject;
    private final SignUpUserOutputBoundary userPresenter;
    private final BuyerFactory buyerFactory;
    private final SellerFactory sellerFactory;

    /**
     * Constructor for SignUpInteractor.
     *
     * @param signUpUserDataAccessInterface The data access object for user signup operations.
     * @param signUpUserOutputBoundary      The presenter for user signup output.
     * @param buyerFactory                  The factory for creating buyer entities.
     * @param sellerFactory                 The factory for creating seller entities.
     */
    public SignUpUserInteractor(SignUpUserDataAccessInterface signUpUserDataAccessInterface,
                                SignUpUserOutputBoundary signUpUserOutputBoundary,
                                BuyerFactory buyerFactory,
                                SellerFactory sellerFactory) {
        this.userDataAccessObject = signUpUserDataAccessInterface;
        this.userPresenter = signUpUserOutputBoundary;
        this.buyerFactory = buyerFactory;
        this.sellerFactory = sellerFactory;
    }

    /**
     * Executes the user signup use case.
     *
     * @param signUpUserInputData The input data for user signup.
     */
    @Override
    public void execute(SignUpUserInputData signUpUserInputData) {
        // Check if the user already exists
        if (userDataAccessObject.existsByName(signUpUserInputData.username())) {
            userPresenter.prepareFailView("User already exists.");
        }

        // Check if passwords match
        else if (!signUpUserInputData.password().equals(signUpUserInputData.repeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        }

        else if (!isLengthValid(signUpUserInputData.password())) {
            userPresenter.prepareFailView("Your password must be at least 8 characters long.");
        }
        else if (!isSpecialValid(signUpUserInputData.password())) {
            userPresenter.prepareFailView("Your password must contain at least one special character");
        }
        else if (!isUppercaseValid(signUpUserInputData.password())) {
            userPresenter.prepareFailView("Your password must contain at least one uppercase letter");
        }
        // Perform signup based on the user type (buyer or seller)
        else if ("seller".equals(signUpUserInputData.signType())) {
            LoginUser user = sellerFactory.create(signUpUserInputData.username(), signUpUserInputData.password());
            userDataAccessObject.save(user);
            SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signUpUserOutputData);
        } else if ("buyer".equals(signUpUserInputData.signType())) {
            // For buyers
            LoginUser user = buyerFactory.create(signUpUserInputData.username(), signUpUserInputData.password());
            userDataAccessObject.save(user);
            SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signUpUserOutputData);
        }
    }
    @Override
    public void guestView() {
        userPresenter.prepareGuestView();
    }
    @Override
    public void switchPage() {
        userPresenter.switchPage();
    }

    // Methods to check password requirements
    private boolean isLengthValid(String password) {
        // Check minimum length
        return password.length() >= 8;
    }
    private boolean isSpecialValid(String password) {
        // Check for at least one special character
        return password.matches(".*[!@#$%^&*()-_=+\\|[{]};:'\",<.>/?].*");
    }
    private boolean isUppercaseValid(String password) {
        // Check for at least one uppercase letter
        return password.matches(".*[A-Z].*");
    }
}