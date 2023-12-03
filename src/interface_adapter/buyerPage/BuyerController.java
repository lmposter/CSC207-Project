package interface_adapter.buyerPage;


import use_case.buyerPage.BuyerInputBoundary;
import use_case.buyerPage.BuyerInputData;

/**
 * The LoginController class is responsible for handling user interface actions related to the login functionality.
 * It communicates with the use case through the LoginInputBoundary and processes user input.
 */
public class BuyerController {

    private final BuyerInputBoundary buyerInteractor;

    /**
     * Constructs a LoginController with the provided LoginInputBoundary.
     *
     * @param buyerInteractor The login use case interactor responsible for handling login logic.
     */
    public BuyerController(BuyerInputBoundary buyerInteractor) {
        this.buyerInteractor = buyerInteractor;
    }
    public void switchPageLogOut(){
        buyerInteractor.switchPageLogOut();
    }

    public void switchPageSearch(String username){
        buyerInteractor.switchPageSearch(username);
    }

    public void switchPageOrder(String username){
        buyerInteractor.switchPageOrder(username);
    }

    public void switchPageShoppingCart(String username){
        buyerInteractor.switchPageShoppingCart(username);
    }

    public void switchPageStorePage(String username){
        buyerInteractor.switchPageStorePage(username);
    }
    public void changePassword(String username, String password){
        buyerInteractor.changePassword(username, password);
    }
    /**
     * Executes the login action triggered by the user interface.
     *
     * @param username The username entered by the user.
     */
    public void execute(String username) {
        // Create LoginInputData from user input
        BuyerInputData buyerInputData = new BuyerInputData(username);

        // Execute the login process through the use case interactor
        buyerInteractor.execute(buyerInputData);
    }
}