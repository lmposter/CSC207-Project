package interface_adapter.AllUserPage.guestPage;

import use_case.allUser.guestPage.GuestInputBoundary;

/**
 * The GuestController class is responsible for handling user interface actions related to the guest functionality.
 * It communicates with the use case through the GuestInputBoundary and processes user input.
 */
public class GuestController {

    private final GuestInputBoundary guestInteractor;

    /**
     * Constructs a GuestController with the provided GuestInputBoundary.
     *
     * @param guestInteractor The guest use case interactor responsible for handling guest logic.
     */
    public GuestController(GuestInputBoundary guestInteractor) {
        this.guestInteractor = guestInteractor;
    }

    /**
     * Switches to the log out page.
     */
    public void switchPageLogOut() {
        guestInteractor.switchPageLogOut();
    }

    /**
     * Switches to the search page.
     *
     * @param username The username of the guest.
     */
    public void switchPageSearch(String username) {
        guestInteractor.switchPageSearch(username);
    }
}