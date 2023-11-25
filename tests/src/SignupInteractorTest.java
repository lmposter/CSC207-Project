package src;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.signup.*;

import static org.mockito.Mockito.*;

class SignupInteractorTest {

    // Mocked dependencies for the SignUpUserInteractor
    @Mock
    private SignUpUserDataAccessInterface mockUserDataAccessObject;
    @Mock
    private SignUpUserOutputBoundary mockUserPresenter;
    @Mock
    private GuestFactory mockGuestFactory;
    @Mock
    private BuyerFactory mockBuyerFactory;
    @Mock
    private SellerFactory mockSellerFactory;

    private SignUpUserInteractor signUpUserInteractor;

    // Setup for Mockito annotations and initializing the test object
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signUpUserInteractor = new SignUpUserInteractor(
                mockUserDataAccessObject,
                mockUserPresenter,
                mockGuestFactory,
                mockBuyerFactory,
                mockSellerFactory);
    }

    // Test case for guest user signup
    @Test
    void testExecuteForGuest() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("guest", "", "", "guest");
        Guest mockUser = new Guest();
        when(mockGuestFactory.create("null", "null")).thenReturn(mockUser);

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserDataAccessObject).save(mockUser);
        verify(mockUserPresenter).prepareSuccessView(any(SignUpUserOutputData.class));
    }

    // Test case for buyer signup
    @Test
    void testExecuteForBuyer() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("buyer", "Pabc123!", "Pabc123!", "buyer");
        LoginUser mockUser = new Buyer("buyer", "Pabc123!");
        when(mockBuyerFactory.create("buyer", "Pabc123!")).thenReturn(mockUser);
        when(mockUserDataAccessObject.existsByName("buyer")).thenReturn(false);

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareSuccessView(any(SignUpUserOutputData.class));
    }

    // Test case for seller signup
    @Test
    void testExecuteForSeller() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("seller", "Pabc123!", "Pabc123!", "seller");
        LoginUser mockUser = new Seller("seller", "Pabc123!");
        when(mockSellerFactory.create("seller", "Pabc123!")).thenReturn(mockUser);
        when(mockUserDataAccessObject.existsByName("sellerUser")).thenReturn(false);

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareSuccessView(any(SignUpUserOutputData.class));
    }

    // Test case for handling an existing user during signup
    @Test
    void testExecuteForExistingUser() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("buyer", "Pabc123!", "Pabc123!", "buyer");
        when(mockUserDataAccessObject.existsByName("buyer")).thenReturn(true);

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareFailView("User already exists.");
    }

    // Test case for password mismatch during signup
    @Test
    void testExecuteForPasswordMismatch() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("buyer", "pass321", "pass123", "buyer");

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareFailView("Passwords don't match.");
    }

    // Test case for validating minimum password length
    @Test
    void testExecuteForInvalidPasswordLength() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("buyer", "123", "123", "buyer");

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareFailView("Your password must be at least 8 characters long.");
    }

    // Test case for validating special character in password
    @Test
    void testExecuteForInvalidPasswordSpecialCharacter() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("buyer", "A2345678", "A2345678", "buyer");

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareFailView("Your password must contain at least one special character");
    }

    // Test case for validating uppercase letter in password
    @Test
    void testExecuteForInvalidPasswordUppercase() {
        // Arrange
        SignUpUserInputData inputData = new SignUpUserInputData("buyer", "abcd123?", "abcd123?", "buyer");

        // Act
        signUpUserInteractor.execute(inputData);

        // Assert
        verify(mockUserPresenter).prepareFailView("Your password must contain at least one uppercase letter");
    }

    // Test case to verify the functionality of switching pages
    @Test
    void testSwitchPage() {
        // Act
        signUpUserInteractor.switchPage();

        // Assert
        verify(mockUserPresenter).switchPage();
    }
}