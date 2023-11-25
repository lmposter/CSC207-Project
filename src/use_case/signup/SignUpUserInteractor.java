package use_case.signup;

import entity.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class serves as an interactor for handling the user signup process.
 * It implements the SignUpUserInputBoundary interface.
 */
public class SignUpUserInteractor implements SignUpUserInputBoundary {

    private final SignUpUserDataAccessInterface userDataAccessObject;
    private final SignUpUserOutputBoundary userPresenter;
    private final GuestFactory guestFactory;
    private final BuyerFactory buyerFactory;
    private final SellerFactory sellerFactory;

    /**
     * Constructs a SignUpUserInteractor.
     *
     * @param signUpUserDataAccessInterface DAO for user signup operations.
     * @param signUpUserOutputBoundary      Presenter for user signup results.
     * @param buyerFactory                  Factory for creating Buyer entities.
     * @param sellerFactory                 Factory for creating Seller entities.
     */
    public SignUpUserInteractor(SignUpUserDataAccessInterface signUpUserDataAccessInterface,
                                SignUpUserOutputBoundary signUpUserOutputBoundary,
                                GuestFactory guestFactory,
                                BuyerFactory buyerFactory,
                                SellerFactory sellerFactory) {
        this.userDataAccessObject = signUpUserDataAccessInterface;
        this.userPresenter = signUpUserOutputBoundary;
        this.guestFactory = guestFactory;
        this.buyerFactory = buyerFactory;
        this.sellerFactory = sellerFactory;
    }

    /**
     * Executes the signup process based on the input data provided.
     *
     * @param signUpUserInputData The data required for signing up a user.
     */
    @Override
    public void execute(@NotNull SignUpUserInputData signUpUserInputData) {
        // Handle guest signup
        if ("guest".equals(signUpUserInputData.signType())) {
            LoginUser user = guestFactory.create("null", "null");
            userDataAccessObject.save(user);
            SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signUpUserOutputData);
        } else {
            // Handle existing user check
            if (userDataAccessObject.existsByName(signUpUserInputData.username())) {
                userPresenter.prepareFailView("User already exists.");
            }
            // Handle password mismatch
            else if (!signUpUserInputData.password().equals(signUpUserInputData.repeatPassword())) {
                userPresenter.prepareFailView("Passwords don't match.");
            }
            // Validate password length
            else if (!isLengthValid(signUpUserInputData.password())) {
                userPresenter.prepareFailView("Your password must be at least 8 characters long.");
            }
            // Validate special character in password
            else if (!isSpecialValid(signUpUserInputData.password())) {
                userPresenter.prepareFailView("Your password must contain at least one special character");
            }
            // Validate uppercase character in password
            else if (!isUppercaseValid(signUpUserInputData.password())) {
                userPresenter.prepareFailView("Your password must contain at least one uppercase letter");
            }
            // Handle seller signup
            else if ("seller".equals(signUpUserInputData.signType())) {
                LoginUser user = sellerFactory.create(signUpUserInputData.username(), signUpUserInputData.password());
                userDataAccessObject.save(user);
                SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData(user.getName(), false);
                userPresenter.prepareSuccessView(signUpUserOutputData);
            }
            // Handle buyer signup
            else if ("buyer".equals(signUpUserInputData.signType())) {
                LoginUser user = buyerFactory.create(signUpUserInputData.username(), signUpUserInputData.password());
                userDataAccessObject.save(user);
                SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData(user.getName(), false);
                userPresenter.prepareSuccessView(signUpUserOutputData);
            }
        }
    }

    /**
     * Triggers a page switch in the user interface.
     */
    @Override
    public void switchPage() {
        userPresenter.switchPage();
    }

    // Validates the length of the password.
    @Contract(pure = true)
    private boolean isLengthValid(@NotNull String password) {
        return password.length() >= 8;
    }

    // Validates the presence of a special character in the password.
    @Contract(pure = true)
    private boolean isSpecialValid(@NotNull String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    // Validates the presence of an uppercase letter in the password.
    @Contract(pure = true)
    private boolean isUppercaseValid(@NotNull String password) {
        return password.matches(".*[A-Z].*");
    }
}
