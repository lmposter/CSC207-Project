package use_case.allUser.sellerPage;

import use_case.allUser.AllUserInteractor;

import java.util.logging.Logger;

/**
 * The SellerInteractor class handles the logic for user logged-in functionality.
 * It interacts with the data access layer and presents the results through an output boundary.
 */
public class SellerInteractor extends AllUserInteractor implements SellerInputBoundary {

    // Data access object for user-related operations
    private final SellerDataAccessInterface userDataAccessObject;

    // Presenter responsible for displaying logged-in results
    private final SellerOutputBoundary sellerPresenter;

    // Logger for logging logged-in activities
    private static final Logger LOGGER = Logger.getLogger(SellerInteractor.class.getName());

    /**
     * Constructs a SellerInteractor with the provided dependencies.
     *
     * @param userDataAccessInterface The data access object for user-related operations.
     * @param sellerOutputBoundary  The presenter for displaying logged-in results.
     */
    public SellerInteractor(SellerDataAccessInterface userDataAccessInterface,
                            SellerOutputBoundary sellerOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.sellerPresenter = sellerOutputBoundary;
    }

    /**
     * Changes the password for the logged-in user.
     *
     * @param username    The username of the logged-in user.
     * @param newPassword The new password to set.
     */
    public void changePassword(String username, String newPassword) {
//        if (!userDataAccessObject.existsByName(username)) {
//            loggedInPresenter.prepareFailView("Attempted change password on a non-existent account: " + username);
//            LOGGER.log(Level.WARNING, "Attempted change password on a non-existent account: " + username);
//        } else {
//            // Retrieve stored password from the data access object
//            String storedPassword = userDataAccessObject.get(username).getPassword();
//
//            // Check if the provided password matches the stored password
//            if (!newPassword.equals(storedPassword)) {
//                loggedInPresenter.prepareFailView("Cannot reset to the same password: " + newPassword);
//                LOGGER.log(Level.WARNING, "Cannot reset to the same password: " + newPassword);
//            } else {
//                userDataAccessObject.changePassword(username, newPassword);
//                loggedInPresenter.prepareFailView("Password changed to " + newPassword);
//                LOGGER.log(Level.INFO, "Password changed to " + newPassword);
//            }
//        }
    }

    /**
     * Switches to another page in the application.
     */
    @Override
    public void switchPageLogOut() {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        sellerPresenter.switchPageLogOut();
    }

    @Override
    public void switchPageSearch(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        sellerPresenter.switchPageSearch(username);
    }

    @Override
    public void switchPageOrder(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        sellerPresenter.switchPageOrder(username);
    }

    @Override
    public void switchPageShoppingCart(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        sellerPresenter.switchPageShoppingCart(username);
    }

    @Override
    public void switchPageStorePage(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        sellerPresenter.switchPageStorePage(username);
    }

    @Override
    public void execute(SellerInputData sellerInputData) {

    }
}
