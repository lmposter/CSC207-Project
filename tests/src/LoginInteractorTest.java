package src;

import entity.Buyer;
import entity.LoginUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.login.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Test suite for LoginInteractor class.
 */
public class LoginInteractorTest {

    private LoginInteractor loginInteractor;
    private LoginUserDataAccessInterface userDataAccessMock;
    private LoginOutputBoundary loginOutputMock;

    @BeforeEach
    public void setUp() {
        userDataAccessMock = mock(LoginUserDataAccessInterface.class);
        loginOutputMock = mock(LoginOutputBoundary.class);
        loginInteractor = new LoginInteractor(userDataAccessMock, loginOutputMock);
    }

    @Test
    public void testExecuteWithNonExistentAccount() {
        // Setup
        when(userDataAccessMock.existsByName(anyString())).thenReturn(false);

        // Execute
        loginInteractor.execute(new LoginInputData("user", "pass"));

        // Verify
        verify(loginOutputMock).prepareFailView(anyString());
        // Additional verifications can be added
    }

    @Test
    public void testExecuteWithCorrectCredentials() {
        // Setup
        when(userDataAccessMock.existsByName(anyString())).thenReturn(true);
        when(userDataAccessMock.isAccountLocked(anyString())).thenReturn(false);
        when(userDataAccessMock.get(anyString())).thenReturn(new Buyer("user", "pass"));

        // Execute
        loginInteractor.execute(new LoginInputData("user", "pass"));

        // Verify
        verify(loginOutputMock).prepareSuccessView(any(LoginOutputData.class));
        // Additional verifications can be added
    }

    @Test
    public void testExecuteWithIncorrectPassword() {
        when(userDataAccessMock.existsByName("user")).thenReturn(true);
        when(userDataAccessMock.isAccountLocked("user")).thenReturn(false);
        when(userDataAccessMock.get("user")).thenReturn(new Buyer("user", "correctPass"));

        loginInteractor.execute(new LoginInputData("user", "wrongPass"));

        verify(userDataAccessMock).incrementFailedLoginAttempts("user");
        verify(loginOutputMock).prepareFailView(contains("Incorrect password"));
    }

    @Test
    public void testExecuteWithExceededFailedAttempts() {
        when(userDataAccessMock.existsByName("user")).thenReturn(true);
        when(userDataAccessMock.isAccountLocked("user")).thenReturn(false);
        when(userDataAccessMock.get("user")).thenReturn(new Buyer("user", "correctPass"));
        when(userDataAccessMock.isMaxFailedAttemptsReached("user")).thenReturn(true);

        loginInteractor.execute(new LoginInputData("user", "wrongPass"));

        verify(userDataAccessMock).lockAccount("user");
        verify(loginOutputMock).prepareFailView(contains("Account locked"));
    }

    @Test
    public void testDeactivateAccountSuccessfully() {
        when(userDataAccessMock.existsByName("user")).thenReturn(true);
        when(userDataAccessMock.get("user")).thenReturn(new Buyer("user", "pass"));

        loginInteractor.deactivateAccount("user", "pass");

        verify(userDataAccessMock).deactivateAccount("user");
        verify(loginOutputMock).prepareFailView(contains("Account: user Deactivated"));
    }

    @Test
    public void testDeactivateAccountWrongPassword() {
        when(userDataAccessMock.existsByName("user")).thenReturn(true);
        when(userDataAccessMock.get("user")).thenReturn(new Buyer("user", "pass"));

        loginInteractor.deactivateAccount("user", "nope");

        verify(loginOutputMock).prepareFailView(contains("Incorrect password for "));
    }

    @Test
    public void testDeactivateAccountWithAccountAlreadyDeactivated() {
        when(userDataAccessMock.existsByName("user")).thenReturn(false);

        loginInteractor.deactivateAccount("user", "pass");

        verify(loginOutputMock).prepareFailView(contains("Attempted deactivate a non-existent account: "));
    }

    @Test
    public void testSwitchPage() {
        loginInteractor.switchPage();
        verify(loginOutputMock).switchPage();
    }

}
