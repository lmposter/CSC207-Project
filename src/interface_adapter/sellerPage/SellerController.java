package interface_adapter.sellerPage;

import use_case.sellerPage.SellerInputBoundary;
import use_case.sellerPage.SellerInputData;

/**
 * The SellerController class is responsible for handling user interface actions related to the seller's functionality.
 * It communicates with the use case through the SellerInputBoundary and processes user input.
 */
public class SellerController {

    private final SellerInputBoundary sellerInteractor;

    /**
     * Constructs a SellerController with the provided SellerInputBoundary.
     *
     * @param sellerInteractor The seller use case interactor responsible for handling seller-related logic.
     */
    public SellerController(SellerInputBoundary sellerInteractor) {
        this.sellerInteractor = sellerInteractor;
    }

    /**
     * Initiates the logout process for the seller.
     */
    public void switchPageLogOut() {
        sellerInteractor.switchPageLogOut();
    }

    /**
     * Initiates the search page navigation for the seller.
     *
     * @param username The username of the seller.
     */
    public void switchPageSearch(String username) {
        sellerInteractor.switchPageSearch(username);
    }

    /**
     * Initiates the orders page navigation for the seller.
     *
     * @param username The username of the seller.
     */
    public void switchPageOrder(String username) {
        sellerInteractor.switchPageOrder(username);
    }

    /**
     * Initiates the shopping cart page navigation for the seller.
     *
     * @param username The username of the seller.
     */
    public void switchPageShoppingCart(String username) {
        sellerInteractor.switchPageShoppingCart(username);
    }

    /**
     * Initiates the store page navigation for the seller.
     *
     * @param username The username of the seller.
     */
    public void switchPageStorePage(String username) {
        sellerInteractor.switchPageStorePage(username);
    }

    /**
     * Changes the password of the seller.
     *
     * @param username The username of the seller.
     * @param password The new password to set.
     */
    public void changePassword(String username, String password) {
        sellerInteractor.changePassword(username, password);
    }

    /**
     * Executes seller-related actions triggered by the user interface.
     *
     * @param username The username entered by the user.
     */
    public void execute(String username) {
        // Create SellerInputData from user input
        SellerInputData sellerInputData = new SellerInputData(username);

        // Execute seller-related actions through the use case interactor
        sellerInteractor.execute(sellerInputData);
    }
}