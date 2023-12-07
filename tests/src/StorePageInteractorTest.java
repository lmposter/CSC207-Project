package src;

import data_access.ProductDAO;
import entity.LoginUser;
import entity.Product;
import entity.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;
import use_case.storePage.StorePageInteractor;
import use_case.storePage.StorePageInputBoundary;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StorePageInteractorTest {

    private ProductDAO mockProductDAO;
    private LoginUserDataAccessInterface mockLoginUserDataAccessInterface;
    private StorePageInputBoundary storePageInteractor;

    @BeforeEach
    void setUp() {
        mockProductDAO = mock(ProductDAO.class);
        mockLoginUserDataAccessInterface = mock(LoginUserDataAccessInterface.class);
        storePageInteractor = new StorePageInteractor(mockProductDAO, mockLoginUserDataAccessInterface);
    }

    @Test
    void testGetUser() {
        // Arrange
        String username = "testUser";
        LoginUser expectedUser = new Seller("testUser", "Test Seller");
        when(mockLoginUserDataAccessInterface.get(username)).thenReturn(expectedUser);

        // Act
        LoginUser result = storePageInteractor.get(username);

        // Assert
        assertEquals(expectedUser, result);
        verify(mockLoginUserDataAccessInterface, times(1)).get(username);
    }

    @Test
    void testFindProducts() {
        // Arrange
        String username = "testUser";
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("1", "Product 1 URL", 10.0, 50));
        expectedProducts.add(new Product("2", "Product 2 URL", 20.0, 30));
        when(mockProductDAO.findProducts(username)).thenReturn((ArrayList<Product>) expectedProducts);

        // Act
        List<Product> result = storePageInteractor.findProducts(username);

        // Assert
        assertEquals(expectedProducts, result);
        verify(mockProductDAO, times(1)).findProducts(username);
    }

    @Test
    void testGetDAO() {
        // Act
        ProductDAO result = storePageInteractor.getDAO();

        // Assert
        assertEquals(mockProductDAO, result);
    }
}
