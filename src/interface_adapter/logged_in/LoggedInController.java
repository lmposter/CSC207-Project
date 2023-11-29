package interface_adapter.logged_in;

import use_case.loggedIn.LoggedInInputBoundary;
import use_case.loggedIn.LoggedInInputData;

/**
 * The LoginController class is responsible for handling user interface actions related to the login functionality.
 * It communicates with the use case through the LoginInputBoundary and processes user input.
 */
public class LoggedInController {

    private final LoggedInInputBoundary loggedInInteractor;

    /**
     * Constructs a LoginController with the provided LoginInputBoundary.
     *
     * @param loggedInInteractor The login use case interactor responsible for handling login logic.
     */
    public LoggedInController(LoggedInInputBoundary loggedInInteractor) {
        this.loggedInInteractor = loggedInInteractor;
    }
    public void switchPageLogOut(){
        loggedInInteractor.switchPageLogOut();
    }

    public void switchPageSearch(){
        loggedInInteractor.switchPageSearch();
    }

    public void switchPageOrder(){
        loggedInInteractor.switchPageOrder();
    }

    public void switchPageShoppingCart(){
        loggedInInteractor.switchPageShoppingCart();
    }

    public void switchPageStorePage(){
        loggedInInteractor.switchPageStorePage();
    }
    public void changePassword(String username, String password){
        loggedInInteractor.changePassword(username, password);
    }
    /**
     * Executes the login action triggered by the user interface.
     *
     * @param username The username entered by the user.
     */
    public void execute(String username) {
        // Create LoginInputData from user input
        LoggedInInputData loggedInInputData = new LoggedInInputData(username);

        // Execute the login process through the use case interactor
        loggedInInteractor.execute(loggedInInputData);
    }
}