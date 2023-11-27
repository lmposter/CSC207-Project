package src;

import entity.Product;
import entity.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.productDetails.*;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class ProductInteractorTest {

    private ProductDetailsDAI mockProductDetailsDAO;
    private ProductOutPutBoundary mockUserPresenter;
    private ProductInteractor productInteractor;

    @BeforeEach
    void setUp() {
        // Mock dependencies for ProductInteractor
        mockProductDetailsDAO = Mockito.mock(ProductDetailsDAI.class);
        mockUserPresenter = Mockito.mock(ProductOutPutBoundary.class);
        // Create instance of ProductInteractor with mocked dependencies
        productInteractor = new ProductInteractor(mockProductDetailsDAO, mockUserPresenter);
    }

    @Test
    void execute_productDoesNotExist() {
        // Test scenario: Product does not exist in the database
        // Arrange
        ProductInputData inputData = new ProductInputData("1"); // Assuming 1 is the product ID
        when(mockProductDetailsDAO.productExists(inputData.getID())).thenReturn(false);

        // Act
        productInteractor.execute(inputData);

        // Assert
        // Verify that the presenter is called with a fail view message
        verify(mockUserPresenter).prepareFailView("Product does not exist.");
    }

    @Test
    void execute_productExists() {
        // Test scenario: Product exists in the database
        // Arrange
        ProductInputData inputData = new ProductInputData("1"); // Assuming 1 is the product ID
        when(mockProductDetailsDAO.productExists(inputData.getID())).thenReturn(true);
        // Create a dummy product with a tag
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag("a"));
        Product product = new Product("xxx", "https://media.licdn.com/dms/image/D5603AQGFgLHQTCZDQA/profile-displayphoto-shrink_800_800/0/1695674562884?e=1706745600&v=beta&t=rkqFw5hQmo6dWk17kmSOt3zkYhg1nCvlxKEsjkMqnUA", -999999999, 2, tags); // Assuming Product is the entity
        when(mockProductDetailsDAO.getPd(inputData.getID())).thenReturn(product);

        // Act
        productInteractor.execute(inputData);

        // Assert
        // Verify that the presenter is called with a success view message and the product data
        verify(mockUserPresenter).prepareSuccessView(any(ProductOutputData.class));
    }
}