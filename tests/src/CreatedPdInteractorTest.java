package src;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.create_product.CreatePdInputBoundary;
import use_case.create_product.CreatePdInteractor;
import use_case.create_product.CreatePdOutPutBoundary;
import use_case.create_product.CreatePdInputData;
import use_case.create_product.CreatePdDAI;

class CreatedPdInteractorTest {

    @Test
    void testValidInput() {
        // Mock dependencies
        CreatePdOutPutBoundary mockPresenter = Mockito.mock(CreatePdOutPutBoundary.class);
        CreatePdDAI mockDAO = Mockito.mock(CreatePdDAI.class);

        // Set up interactor
        CreatePdInputBoundary interactor = new CreatePdInteractor(mockDAO, mockPresenter);

        // Set up valid input data
        CreatePdInputData validInputData = new CreatePdInputData("Valid Title Greater Than 25 characters", "50.00", "100", "https://example.com/image.jpg", "seller123");

        // Execute interactor
        interactor.execute(validInputData);

        // Verify that the presenter's success method is called
        Mockito.verify(mockPresenter).prepareSuccessCreateView("Created Successfully");
        // Verify that the DAO's save method is called
        Mockito.verify(mockDAO).save(Mockito.any(), Mockito.eq("seller123"));
    }

    @Test
    void testInvalidTitleLength() {
        // Mock dependencies
        CreatePdOutPutBoundary mockPresenter = Mockito.mock(CreatePdOutPutBoundary.class);
        CreatePdDAI mockDAO = Mockito.mock(CreatePdDAI.class);

        // Set up interactor
        CreatePdInputBoundary interactor = new CreatePdInteractor(mockDAO, mockPresenter);

        // Set up invalid input data (title length < 25)
        CreatePdInputData invalidInputData = new CreatePdInputData("Short", "50.00", "100", "https://example.com/image.jpg", "seller123");

        // Execute interactor
        interactor.execute(invalidInputData);

        // Verify that the presenter's failure method is called with the appropriate message
        Mockito.verify(mockPresenter).prepareFailCreateView("Title must be between 25 and 150 characters.");
        // Verify that the DAO's save method is not called
        Mockito.verifyNoInteractions(mockDAO);
    }

    // Add more test cases for other scenarios (invalid price, invalid inventory, invalid image URL, runtime exception)
    // ...

}
