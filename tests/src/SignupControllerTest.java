package src;

import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.signup.SignupController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import use_case.signup.SignUpUserInputBoundary;
import use_case.signup.SignUpUserInputData;

public class SignupControllerTest {

    @Mock
    private SignUpUserInputBoundary mockUserSignupUseCaseInteractor;

    private SignupController signupController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        signupController = new SignupController(mockUserSignupUseCaseInteractor);
    }

    @Test
    public void testExecute() {
        String username = "testuser";
        String password1 = "password123";
        String password2 = "password123";
        String type = "user";

        SignUpUserInputData expectedInputData = new SignUpUserInputData(username, password1, password2, type);

        signupController.execute(username, password1, password2, type);

        Mockito.verify(mockUserSignupUseCaseInteractor).execute(expectedInputData);
    }

    @Test
    public void testSwitchPage() {
        signupController.switchPage();
        Mockito.verify(mockUserSignupUseCaseInteractor).switchPage();
    }
}
