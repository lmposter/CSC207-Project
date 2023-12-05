package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import use_case.allUser.guestPage.*;
/**
 * Test suite for GuestInteractor class.
 */
public class GuestInteractorTest {

    private GuestInteractor guestInteractor;

    @Mock
    private GuestUserDataAccessInterface userDataAccessMock;

    @Mock
    private GuestOutputBoundary guestOutputMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        guestInteractor = new GuestInteractor(userDataAccessMock, guestOutputMock);
    }

    @Test
    public void testSwitchPageLogOut() {
        guestInteractor.switchPageLogOut();

        verify(guestOutputMock).switchPageLogOut();
        // Additional verifications can be included as needed
    }

    @Test
    public void testSwitchPageSearch() {
        String username = "guestUser";

        guestInteractor.switchPageSearch(username);

        verify(guestOutputMock).switchPageSearch(username);
        // Additional verifications for the business logic can be added
    }

    // Additional test cases can be added to cover more methods or scenarios
}

