package src;

import interface_adapter.Create_product.CreatePdPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.create_product.*;
import static org.junit.jupiter.api.Assertions.*;


class CreatedPdInteractorTest {

    private CreatePdInputBoundary createPdInteractor;
    private CreatePdOutPutBoundary createPdPresenter;

    @BeforeEach
    void setUp() {
        // Set up the CreatePdDAI and CreatePdOutPutBoundary (mocked or real instances)
        CreatePdDAI createPdDAO = Mockito.mock(CreatePdDAI.class);
        createPdPresenter = Mockito.mock(CreatePdOutPutBoundary.class);
        createPdInteractor = new CreatePdInteractor(createPdDAO, createPdPresenter);
    }

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
    @Test
    void testCreateProductSuccess() {
        // Prepare test data for a successful create operation
        String username = "john_doe";
        String title = "Product Title";
        String price = "25.99";
        String inventory = "100";
        String imageUrl = "https://example.com/product.jpg";

        // Create CreatePdInputData instance
        CreatePdInputData createPdInputData = new CreatePdInputData(title, price, inventory, imageUrl, username);

        // Execute the create operation
        createPdInteractor.execute(createPdInputData);
        assertDoesNotThrow(() -> createPdInteractor.execute(createPdInputData));
    }

    @Test
    void testInvalidURL() {
        // Mock dependencies
        CreatePdOutPutBoundary mockPresenter = Mockito.mock(CreatePdOutPutBoundary.class);
        CreatePdDAI mockDAO = Mockito.mock(CreatePdDAI.class);

        // Set up interactor
        CreatePdInputBoundary interactor = new CreatePdInteractor(mockDAO, mockPresenter);

        // Set up invalid input data (title length < 25)
        CreatePdInputData invalidInputData = new CreatePdInputData("VALID TITLE VALID TITLE VALID TITLE", "50.00", "100", "abc", "seller123");

        // Execute interactor
        interactor.execute(invalidInputData);

        // Verify that the presenter's failure method is called with the appropriate message
        Mockito.verify(mockPresenter).prepareFailCreateView("URL not valid.");
        // Verify that the DAO's save method is not called
        Mockito.verifyNoInteractions(mockDAO);
    }

    @Test
    void testInvalidInventory() {
        // Mock dependencies
        CreatePdOutPutBoundary mockPresenter = Mockito.mock(CreatePdOutPutBoundary.class);
        CreatePdDAI mockDAO = Mockito.mock(CreatePdDAI.class);

        // Set up interactor
        CreatePdInputBoundary interactor = new CreatePdInteractor(mockDAO, mockPresenter);

        // Set up invalid input data (title length < 25)
        CreatePdInputData invalidInputData = new CreatePdInputData("Short LONG SHORT LONG VALID", "50.00", "100.0", "https://example.com/image.jpg", "seller123");

        // Execute interactor
        interactor.execute(invalidInputData);

        // Verify that the presenter's failure method is called with the appropriate message
        Mockito.verify(mockPresenter).prepareFailCreateView("Inventory must be a valid integer.");
        // Verify that the DAO's save method is not called
        Mockito.verifyNoInteractions(mockDAO);
    }

    @Test
    void testInvalidPrice() {
        // Mock dependencies
        CreatePdOutPutBoundary mockPresenter = Mockito.mock(CreatePdOutPutBoundary.class);
        CreatePdDAI mockDAO = Mockito.mock(CreatePdDAI.class);

        // Set up interactor
        CreatePdInputBoundary interactor = new CreatePdInteractor(mockDAO, mockPresenter);

        // Set up invalid input data (title length < 25)
        CreatePdInputData invalidInputData = new CreatePdInputData("Short LONG SHORT LONG VALID", "invalid price", "100.0", "https://example.com/image.jpg", "seller123");

        // Execute interactor
        interactor.execute(invalidInputData);

        // Verify that the presenter's failure method is called with the appropriate message
        Mockito.verify(mockPresenter).prepareFailCreateView("Price must be a valid number.");
        // Verify that the DAO's save method is not called
        Mockito.verifyNoInteractions(mockDAO);
    }

}
