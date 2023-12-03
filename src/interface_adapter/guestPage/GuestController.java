package interface_adapter.guestPage;

import use_case.guestPage.GuestInputBoundary;
import use_case.guestPage.GuestInputData;

/**
 * The LoginController class is responsible for handling user interface actions related to the login functionality.
 * It communicates with the use case through the LoginInputBoundary and processes user input.
 */
public class GuestController {

    private final GuestInputBoundary guestInteractor;


    public GuestController(GuestInputBoundary guestInteractor) {
        this.guestInteractor = guestInteractor;
    }
    public void switchPageLogOut(){
        guestInteractor.switchPageLogOut();
    }

    public void switchPageSearch(String username){
        guestInteractor.switchPageSearch(username);
    }
}