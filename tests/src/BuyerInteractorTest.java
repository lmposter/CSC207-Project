package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.allUser.buyerPage.*;

import static org.mockito.Mockito.*;

/**
 * Test suite for BuyerInteractor class.
 */
public class BuyerInteractorTest {

    private BuyerInteractor buyerInteractor;
    private BuyerDataAccessInterface userDataAccessMock;
    private BuyerOutputBoundary buyerOutputMock;

    @BeforeEach
    public void setUp() {
        userDataAccessMock = mock(BuyerDataAccessInterface.class);
        buyerOutputMock = mock(BuyerOutputBoundary.class);
        buyerInteractor = new BuyerInteractor(userDataAccessMock, buyerOutputMock);
    }

    @Test
    public void testChangePassword() {
        String username = "user";
        String newPassword = "newPass";

        buyerInteractor.changePassword(username, newPassword);

    }

    @Test
    public void testExecute() {
        BuyerInputData buyerInputData = new BuyerInputData("/* parameters */");

        buyerInteractor.execute(buyerInputData);

        // Implement verifications based on the expected behavior of the execute method
    }

    @Test
    public void testSwitchPageLogOut() {
        buyerInteractor.switchPageLogOut();

        verify(buyerOutputMock).switchPageLogOut();
        // Additional verifications can be included as needed
    }

    @Test
    public void testSwitchPageSearch() {
        String username = "user";

        buyerInteractor.switchPageSearch(username);

        verify(buyerOutputMock).switchPageSearch(username);
    }

    @Test
    public void testSwitchPageOrder() {
        String username = "user";

        buyerInteractor.switchPageOrder(username);

        verify(buyerOutputMock).switchPageOrder(username);
    }

    @Test
    public void testSwitchPageShoppingCart() {
        String username = "user";

        buyerInteractor.switchPageShoppingCart(username);

        verify(buyerOutputMock).switchPageShoppingCart(username);
    }

    @Test
    public void testSwitchPageStorePage() {
        String username = "user";

        buyerInteractor.switchPageStorePage(username);

        verify(buyerOutputMock).switchPageStorePage(username);
    }
}

