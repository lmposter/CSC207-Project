package use_case.login;

import entity.LoginUser;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The LoginInteractor class handles the logic for user login functionality.
 * It interacts with the data access layer and presents the results through an output boundary.
 */
public class LoginInteractor implements LoginInputBoundary {

    // Data access object for user-related operations
    final LoginUserDataAccessInterface userDataAccessObject;

    // Presenter responsible for displaying login results
    final LoginOutputBoundary loginPresenter;

    // Logger for logging login activities
    private static final Logger LOGGER = Logger.getLogger(LoginInteractor.class.getName());

    /**
     * Constructs a LoginInteractor with the provided dependencies.
     *
     * @param userDataAccessInterface The data access object for user-related operations.
     * @param loginOutputBoundary     The presenter for displaying login results.
     */
    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    /**
     * Executes the login process based on the provided login input data.
     *
     * @param loginInputData The input data containing username and password for login.
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.username();
        String password = loginInputData.password();

        // Check if the account is locked
        if (userDataAccessObject.isAccountLocked(username)) {
            loginPresenter.prepareFailView(username + ": Account is locked.");
            LOGGER.log(Level.WARNING, "Attempted login to locked account: " + username);
            return;
        }

        // Check if the account exists
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView("Attempted login to non-existent account: " + username);
            LOGGER.log(Level.WARNING, "Attempted login to non-existent account: " + username);
        } else {
            // Retrieve stored password from the data access object
            String storedPassword = userDataAccessObject.get(username).getPassword();

            // Check if the provided password matches the stored password
            if (!password.equals(storedPassword)) {
                loginPresenter.prepareFailView("Incorrect password for " + username);
                LOGGER.log(Level.WARNING, "Incorrect password for account: " + username);

                // Increment failed login attempts
                userDataAccessObject.incrementFailedLoginAttempts(username);

                // Lock the account if the maximum number of failed attempts is reached
                if (userDataAccessObject.isMaxFailedAttemptsReached(username)) {
                    userDataAccessObject.lockAccount(username);
                    LOGGER.log(Level.WARNING, "Account locked due to multiple failed login attempts: " + username);
                }

            } else {
                // Reset failed login attempts on successful login
                userDataAccessObject.resetFailedLoginAttempts(username);

                // Retrieve user information and prepare success view
                LoginUser user = userDataAccessObject.get(loginInputData.username());
                LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
                loginPresenter.prepareSuccessView(loginOutputData);

                LOGGER.log(Level.INFO, "Successful login for account: " + username);
            }
        }
    }

    /**
     * Deactivates the user account.
     *
     * @param username The username of the account to be deactivated.
     * @param password The password for account deactivation.
     */
    public void deactivateAccount(String username, String password) {
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView("Attempted deactivate a non-existent account: " + username);
            LOGGER.log(Level.WARNING, "Attempted deactivate a non-existent account: " + username);
        } else {
            // Retrieve stored password from the data access object
            String storedPassword = userDataAccessObject.get(username).getPassword();

            // Check if the provided password matches the stored password
            if (!password.equals(storedPassword)) {
                loginPresenter.prepareFailView("Incorrect password for " + username);
                LOGGER.log(Level.WARNING, "Incorrect password for account: " + username);
            } else {
                userDataAccessObject.deactivateAccount(username);
                loginPresenter.prepareFailView("Account: " + username + " Deactivated");
                LOGGER.log(Level.INFO, "Account: " + username + " Deactivated");
            }
        }
    }

    /**
     * Switches the page using the login presenter.
     */
    @Override
    public void switchPage() {
        loginPresenter.switchPage();
    }
}