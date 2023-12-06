package src;

import entity.Product;
import org.junit.jupiter.api.Test;
import use_case.search.SearchOutPutData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchOutputDataTest {

    @Test
    void testGetProducts() {
        // Prepare test data
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Product1", "URL1", 10.0, 20));
        products.add(new Product("Product2","URL2", 15.0, 30));

        // Create SearchOutPutData instance
        SearchOutPutData searchOutPutData = new SearchOutPutData(products, false);

        // Check if getProducts returns the expected product list
        assertIterableEquals(products, searchOutPutData.getProducts());
    }

    @Test
    void testUseCaseFailed() {
        // Create SearchOutPutData instance with useCaseFailed set to true
        SearchOutPutData searchOutPutData = new SearchOutPutData(new ArrayList<>(), true);

        // Check if useCaseFailed returns true
        assertTrue(searchOutPutData.getUseCaseFailed());
    }

    @Test
    void testUseCaseNotFailed() {
        // Create SearchOutPutData instance with useCaseFailed set to false
        SearchOutPutData searchOutPutData = new SearchOutPutData(new ArrayList<>(), false);

        // Check if useCaseFailed returns false
        assertFalse(searchOutPutData.getUseCaseFailed());
    }
}
