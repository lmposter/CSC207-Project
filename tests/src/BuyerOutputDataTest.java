package src;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import use_case.allUser.buyerPage.*;
import use_case.allUser.guestPage.GuestInputData;

/**
 * Test suite for BuyerOutputData class.
 */
public class BuyerOutputDataTest {

    @Test
    public void testConstructorAndGetterMethods() {
        String expectedUsername = "testUser";
        boolean expectedSuccess = true;

        BuyerOutputData buyerOutputData = new BuyerOutputData(expectedUsername, expectedSuccess);

        assertEquals(expectedUsername, buyerOutputData.username(), "The username should be correctly stored and retrieved.");
        assertEquals(expectedSuccess, buyerOutputData.successful(), "The success status should be correctly stored and retrieved.");
    }

    @Test
    public void testEquality() {
        String username = "testUser";
        BuyerOutputData data1 = new BuyerOutputData(username, true);
        BuyerOutputData data2 = new BuyerOutputData(username, true);

        assertEquals(data1, data2, "Two GuestInputData objects with the same username should be equal");
    }
}

