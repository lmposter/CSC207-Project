package src;

import static org.junit.jupiter.api.Assertions.*;

import entity.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuyerTest {

    private Buyer buyer;

    @BeforeEach
    void setUp() {
        // Set up a new Buyer instance before each test
        buyer = new Buyer("John Doe", "password123");
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", buyer.getName());
    }

    @Test
    void testSetName() {
        buyer.setName("Jane Doe");
        assertEquals("Jane Doe", buyer.getName());
    }

    @Test
    void testGetId() {
        assertNotNull(buyer.getId());
    }

    @Test
    void testGetPassword() {
        assertEquals("password123", buyer.getPassword());
    }

    @Test
    void testSetPassword() {
        buyer.setPassword("newPassword456");
        assertEquals("newPassword456", buyer.getPassword());
    }
}
