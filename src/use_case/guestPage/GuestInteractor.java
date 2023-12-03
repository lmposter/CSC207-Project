package use_case.guestPage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The LoggedInInteractor class handles the logic for user logged-in functionality.
 * It interacts with the data access layer and presents the results through an output boundary.
 */
public class GuestInteractor implements GuestInputBoundary {

    // Data access object for user-related operations
    private final GuestUserDataAccessInterface userDataAccessObject;

    // Presenter responsible for displaying logged-in results
    private final GuestOutputBoundary GuestPresenter;

    // Logger for logging logged-in activities
    private static final Logger LOGGER = Logger.getLogger(GuestInteractor.class.getName());

    /**
     * Constructs a LoggedInInteractor with the provided dependencies.
     *
     * @param userDataAccessInterface The data access object for user-related operations.
     * @param guestOutputBoundary  The presenter for displaying logged-in results.
     */
    public GuestInteractor(GuestUserDataAccessInterface userDataAccessInterface,
                           GuestOutputBoundary guestOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.GuestPresenter = guestOutputBoundary;
    }

    /**
     * Switches to another page in the application.
     */
    @Override
    public void switchPageLogOut() {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        GuestPresenter.switchPageLogOut();
    }

    @Override
    public void switchPageSearch(String username) {
        // Business logic for switching to another page
        // ...

        // Notify the user interface about the page switch
        GuestPresenter.switchPageSearch(username);
    }
}
