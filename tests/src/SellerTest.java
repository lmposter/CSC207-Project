package src;

import static org.junit.jupiter.api.Assertions.*;

import entity.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellerTest {

    private Seller seller;

    @BeforeEach
    void setUp() {
        // Set up a new Seller instance before each test
        seller = new Seller("Jane Smith", "sellerPassword123");
    }

    @Test
    void testGetName() {
        assertEquals("Jane Smith", seller.getName());
    }

    @Test
    void testSetName() {
        seller.setName("John Doe");
        assertEquals("John Doe", seller.getName());
    }

    @Test
    void testGetId() {
        assertNotNull(seller.getId());
    }

    @Test
    void testGetPassword() {
        assertEquals("sellerPassword123", seller.getPassword());
    }

    @Test
    void testSetPassword() {
        seller.setPassword("newSellerPassword456");
        assertEquals("newSellerPassword456", seller.getPassword());
    }

    // Add more tests as needed for specific behaviors or edge cases

}
