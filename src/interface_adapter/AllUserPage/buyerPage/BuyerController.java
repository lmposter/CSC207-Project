package interface_adapter.AllUserPage.buyerPage;

import use_case.allUser.buyerPage.BuyerInputBoundary;
import use_case.allUser.buyerPage.BuyerInputData;

/**
 * The BuyerController class is responsible for handling user interface actions related to the buyer functionality.
 * It communicates with the use case through the BuyerInputBoundary and processes user input.
 */
public class BuyerController
{

    private final BuyerInputBoundary buyerInteractor;

    /**
     * Constructs a BuyerController with the provided BuyerInputBoundary.
     *
     * @param buyerInteractor The buyer use case interactor responsible for handling buyer logic.
     */
    public BuyerController(BuyerInputBoundary buyerInteractor)
    {
        this.buyerInteractor = buyerInteractor;
    }

    /**
     * Switches to the log out page.
     */
    public void switchPageLogOut()
    {
        buyerInteractor.switchPageLogOut();
    }

    /**
     * Switches to the search page.
     *
     * @param username The username of the buyer.
     */
    public void switchPageSearch(String username)
    {
        buyerInteractor.switchPageSearch(username);
    }

    /**
     * Switches to the order page.
     *
     * @param username The username of the buyer.
     */
    public void switchPageOrder(String username)
    {
        buyerInteractor.switchPageOrder(username);
    }

    /**
     * Switches to the shopping cart page.
     *
     * @param username The username of the buyer.
     */
    public void switchPageShoppingCart(String username)
    {
        buyerInteractor.switchPageShoppingCart(username);
    }

    /**
     * Switches to the store page.
     *
     * @param username The username of the buyer.
     */
    public void switchPageStorePage(String username)
    {
        buyerInteractor.switchPageStorePage(username);
    }

    /**
     * Changes the password of the buyer.
     *
     * @param username The username of the buyer.
     * @param password The new password to set.
     */
    public void changePassword(String username, String password)
    {
        buyerInteractor.changePassword(username, password);
    }

    /**
     * Executes a buyer action triggered by the user interface.
     *
     * @param username The username entered by the user.
     */
    public void execute(String username)
    {
        // Create BuyerInputData from user input
        BuyerInputData buyerInputData = new BuyerInputData(username);

        // Execute the buyer process through the use case interactor
        buyerInteractor.execute(buyerInputData);
    }
}