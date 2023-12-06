package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import use_case.orders.OrderInputData;

class OrderInputDataTest {

    @Test
    void testGetUsername() {
        // Set up valid input data
        OrderInputData orderInputData = new OrderInputData("buyer123");

        // Verify that the getUsername method returns the correct username
        assertEquals("buyer123", orderInputData.username());
    }

    @Test
    void testCreateInstanceWithValidInput() {
        // Set up valid input data
        OrderInputData orderInputData = new OrderInputData("buyer456");

        // Verify that the instance is created successfully
        assertNotNull(orderInputData);
        assertEquals("buyer456", orderInputData.username());
    }

}
