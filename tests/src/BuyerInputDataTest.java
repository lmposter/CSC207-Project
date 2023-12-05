package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import use_case.allUser.buyerPage.*;
/**
 * Test suite for BuyerInputData class.
 */
public class BuyerInputDataTest {

    @Test
    public void testConstructorAndGetter() {
        String expectedUsername = "testUser";

        BuyerInputData buyerInputData = new BuyerInputData(expectedUsername);

        assertEquals(expectedUsername, buyerInputData.username(), "The username should be correctly stored and retrieved.");
    }

    @Test
    public void testEquality() {
        String username = "testUser";
        BuyerInputData data1 = new BuyerInputData(username);
        BuyerInputData data2 = new BuyerInputData(username);

        assertEquals(data1, data2, "Two GuestInputData objects with the same username should be equal");
    }
}

