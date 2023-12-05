package use_case.allUser.buyerPage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The BuyerInteractor class handles the logic for user logged-in functionality.
 * It interacts with the data access layer and presents the results through an output boundary.
 */
public class BuyerInteractor implements BuyerInputBoundary
{

    // Data access object for user-related operations
    private final BuyerDataAccessInterface userDataAccessObject;

    // Presenter responsible for displaying logged-in results
    private final BuyerOutputBoundary buyerPresenter;

    // Logger for logging logged-in activities
    private static final Logger LOGGER = Logger.getLogger(BuyerInteractor.class.getName());

    /**
     * Constructs a BuyerInteractor with the provided dependencies.
     *
     * @param userDataAccessInterface The data access object for user-related operations.
     * @param buyerOutputBoundary     The presenter for displaying logged-in results.
     */
    public BuyerInteractor(BuyerDataAccessInterface userDataAccessInterface, BuyerOutputBoundary buyerOutputBoundary)
    {
        this.userDataAccessObject = userDataAccessInterface;
        this.buyerPresenter = buyerOutputBoundary;
    }

    /**
     * Changes the password for the logged-in user.
     *
     * @param username    The username of the logged-in user.
     * @param newPassword The new password to set.
     */
    public void changePassword(String username, String newPassword) {
    }

    @Override
    public void execute(BuyerInputData buyerInputData) {

    }

    /**
     * Switches to another page in the application.
     */
    @Override
    public void switchPageLogOut() {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        buyerPresenter.switchPageLogOut();
    }

    @Override
    public void switchPageSearch(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        buyerPresenter.switchPageSearch(username);
    }

    @Override
    public void switchPageOrder(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        buyerPresenter.switchPageOrder(username);
    }

    @Override
    public void switchPageShoppingCart(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        buyerPresenter.switchPageShoppingCart(username);
    }

    @Override
    public void switchPageStorePage(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        buyerPresenter.switchPageStorePage(username);
    }
}
