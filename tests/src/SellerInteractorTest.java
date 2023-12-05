package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.allUser.sellerPage.SellerDataAccessInterface;
import use_case.allUser.sellerPage.SellerInputData;
import use_case.allUser.sellerPage.SellerInteractor;
import use_case.allUser.sellerPage.SellerOutputBoundary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test suite for SellerInteractor class.
 */
public class SellerInteractorTest {

    private SellerInteractor sellerInteractor;
    private SellerDataAccessInterface userDataAccessMock;
    private SellerOutputBoundary sellerOutputMock;

    @BeforeEach
    public void setUp() {
        userDataAccessMock = mock(SellerDataAccessInterface.class);
        sellerOutputMock = mock(SellerOutputBoundary.class);
        sellerInteractor = new SellerInteractor(userDataAccessMock, sellerOutputMock);
    }

    @Test
    public void testChangePassword() {
        String username = "user";
        String newPassword = "newPass";

        sellerInteractor.changePassword(username, newPassword);

    }

    @Test
    public void testExecute() {
        SellerInputData sellerInputData = new SellerInputData("/* parameters */");

        sellerInteractor.execute(sellerInputData);

        // Implement verifications based on the expected behavior of the execute method
    }

    @Test
    public void testSwitchPageLogOut() {
        sellerInteractor.switchPageLogOut();

        verify(sellerOutputMock).switchPageLogOut();
        // Additional verifications can be included as needed
    }

    @Test
    public void testSwitchPageSearch() {
        String username = "user";

        sellerInteractor.switchPageSearch(username);

        verify(sellerOutputMock).switchPageSearch(username);
    }

    @Test
    public void testSwitchPageOrder() {
        String username = "user";

        sellerInteractor.switchPageOrder(username);

        verify(sellerOutputMock).switchPageOrder(username);
    }

    @Test
    public void testSwitchPageShoppingCart() {
        String username = "user";

        sellerInteractor.switchPageShoppingCart(username);

        verify(sellerOutputMock).switchPageShoppingCart(username);
    }

    @Test
    public void testSwitchPageStorePage() {
        String username = "user";

        sellerInteractor.switchPageStorePage(username);

        verify(sellerOutputMock).switchPageStorePage(username);
    }
}

