package use_case.loggedIn;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The LoggedInInteractor class handles the logic for user logged-in functionality.
 * It interacts with the data access layer and presents the results through an output boundary.
 */
public class LoggedInInteractor implements LoggedInInputBoundary {

    // Data access object for user-related operations
    private final LoggedInUserDataAccessInterface userDataAccessObject;

    // Presenter responsible for displaying logged-in results
    private final LoggedInOutputBoundary loggedInPresenter;

    // Logger for logging logged-in activities
    private static final Logger LOGGER = Logger.getLogger(LoggedInInteractor.class.getName());

    /**
     * Constructs a LoggedInInteractor with the provided dependencies.
     *
     * @param userDataAccessInterface The data access object for user-related operations.
     * @param loggedInOutputBoundary  The presenter for displaying logged-in results.
     */
    public LoggedInInteractor(LoggedInUserDataAccessInterface userDataAccessInterface,
                              LoggedInOutputBoundary loggedInOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loggedInPresenter = loggedInOutputBoundary;
    }

    /**
     * Executes a logged-in action based on the provided input data.
     *
     * @param loggedInInputData The input data containing information for the logged-in action.
     */
    @Override
    public void execute(LoggedInInputData loggedInInputData) {
        // Business logic for executing logged-in actions
        // ...

        // Notify the user interface about the action result
//        loggedInPresenter.actionExecuted(loggedInInputData);
    }

    /**
     * Changes the password for the logged-in user.
     *
     * @param username    The username of the logged-in user.
     * @param newPassword The new password to set.
     */
    public void changePassword(String username, String newPassword) {
        if (!userDataAccessObject.existsByName(username)) {
            loggedInPresenter.prepareFailView("Attempted change password on a non-existent account: " + username);
            LOGGER.log(Level.WARNING, "Attempted change password on a non-existent account: " + username);
        } else {
            // Retrieve stored password from the data access object
            String storedPassword = userDataAccessObject.get(username).getPassword();

            // Check if the provided password matches the stored password
            if (!newPassword.equals(storedPassword)) {
                loggedInPresenter.prepareFailView("Cannot reset to the same password: " + newPassword);
                LOGGER.log(Level.WARNING, "Cannot reset to the same password: " + newPassword);
            } else {
                userDataAccessObject.changePassword(username, newPassword);
                loggedInPresenter.prepareFailView("Password changed to " + newPassword);
                LOGGER.log(Level.INFO, "Password changed to " + newPassword);
            }
        }
    }

    /**
     * Switches to another page in the application.
     */
    @Override
    public void switchPageLogOut() {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        loggedInPresenter.switchPageLogOut();
    }

    @Override
    public void switchPageSearch(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        loggedInPresenter.switchPageSearch(username);
    }

    @Override
    public void switchPageOrder(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        loggedInPresenter.switchPageOrder(username);
    }

    @Override
    public void switchPageShoppingCart(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        loggedInPresenter.switchPageShoppingCart(username);
    }

    @Override
    public void switchPageStorePage(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        loggedInPresenter.switchPageStorePage(username);
    }
}
