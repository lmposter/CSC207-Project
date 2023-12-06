package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import use_case.orders.OrderOutputData;
import java.lang.reflect.RecordComponent;


class OrderOutputDataTest {

    @Test
    void testCreateInstanceWithValidInput() {
        // Set up valid input data
        OrderOutputData orderOutputData = new OrderOutputData("buyer123", true);

        // Verify that the instance is created successfully
        assertNotNull(orderOutputData);
        assertEquals("buyer123", orderOutputData.username());
        assertTrue(orderOutputData.successful());
    }

    @Test
    void testGetUsername() {
        // Set up valid input data
        OrderOutputData orderOutputData = new OrderOutputData("buyer456", false);

        // Verify that the getUsername method returns the correct username
        assertEquals("buyer456", orderOutputData.username());
    }

    @Test
    void testGetSuccessfulStatus() {
        // Set up valid input data
        OrderOutputData orderOutputData = new OrderOutputData("buyer789", true);

        // Verify that the getSuccessfulStatus method returns the correct status
        assertTrue(orderOutputData.successful());
    }

    @Test
    void testRecord(){
        OrderOutputData orderOutputData = new OrderOutputData("123", false);
        OrderOutputData orderOutputData1 = new OrderOutputData("123", false);
        assertEquals(orderOutputData, orderOutputData1);
    }

}
