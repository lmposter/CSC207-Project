package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.orders.*;

class OrderInteractorTest {

    @Test
    void testExecuteWithValidInput() {
        // Mock dependencies
        OrderOutputBoundary mockPresenter = Mockito.mock(OrderOutputBoundary.class);
        OrderDAO mockDAO = Mockito.mock(OrderDAO.class);

        // Set up interactor
        OrderInputBoundary interactor = new OrderInteractor(mockDAO, mockPresenter);

        // Set up valid input data
        OrderInputData validInputData = new OrderInputData("buyer123");

        // Execute interactor
        interactor.execute(validInputData);

        // Verify that the DAO's execute method is called with the correct input
        Mockito.verify(mockDAO).execute(Mockito.eq(validInputData));
    }

    @Test
    void testSwitchPage() {
        // Mock dependencies
        OrderOutputBoundary mockPresenter = Mockito.mock(OrderOutputBoundary.class);
        OrderDAO mockDAO = Mockito.mock(OrderDAO.class);

        // Set up interactor
        OrderInputBoundary interactor = new OrderInteractor(mockDAO, mockPresenter);

        // Execute switchPage method
        interactor.switchPage();

        // Verify that the presenter's switchPage method is called
        Mockito.verify(mockPresenter).switchPage();
    }

    // Add more test cases as needed

}
