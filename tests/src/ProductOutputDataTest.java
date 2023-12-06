package src;

import entity.Product;
import entity.Review;
import org.junit.jupiter.api.Test;
import use_case.productDetails.ProductOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOutputDataTest {

    @Test
    void testProductOutputData() {
        // Prepare test data
        String photoURL = "https://example.com/product.jpg";
        String title = "Product1";
        double price = 19.99;
        int inventory = 50;

        // Create a Product instance
        Product product = new Product(title, photoURL, price, inventory);

        // Create a ProductOutputData instance
        ProductOutputData productOutputData = new ProductOutputData(product);

        // Verify that the ProductOutputData instance has the correct values
        assertEquals(photoURL, productOutputData.getPhotoURL());
        assertEquals(title, productOutputData.getTitle());
        assertEquals(price, productOutputData.getPrice());
        assertEquals(inventory, productOutputData.getInventory());
    }
}
