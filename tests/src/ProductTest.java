package src;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import entity.Product;
import entity.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        // Set up a new Product instance with some initial values before each test
        product = new Product("Laptop", "laptop.jpg", 999.99, 10);
    }

    @Test
    void testGetId() {
        assertNotNull(product.getId());
    }

    @Test
    void testSetTitle() {
        product.updateTitle("New Laptop");
        assertEquals("New Laptop", product.getTitle());
    }

    @Test
    void testSetPhotoURL() {
        product.updatePhoto("new_laptop.jpg");
        assertEquals("new_laptop.jpg", product.getURL());
    }

    @Test
    void testSetPrice() {
        product.updatePrice(1299.99);
        assertEquals(1299.99, product.getPrice(), 0.001); // using delta for double comparison
    }

    @Test
    void testSetInventory() {
        product.setInventory(20);
        assertEquals(20, product.getInventory());
    }

    @Test
    void testAddReview() {
        Review review = new Review(5, "Great product!");
        product.addReview(review);
        assertEquals(1, product.getReview().size());
        assertEquals(review, product.getReview().get(0));
    }
}