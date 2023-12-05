package src;

import org.junit.jupiter.api.Test;
import use_case.allUser.sellerPage.SellerInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for SellerInputData class.
 */
public class SellerInputDataTest {

    @Test
    public void testConstructorAndGetter() {
        String expectedUsername = "testUser";

        SellerInputData sellerInputData = new SellerInputData(expectedUsername);

        assertEquals(expectedUsername, sellerInputData.username(), "The username should be correctly stored and retrieved.");
    }

    @Test
    public void testEquality() {
        String username = "testUser";
        SellerInputData data1 = new SellerInputData(username);
        SellerInputData data2 = new SellerInputData(username);

        assertEquals(data1, data2, "Two GuestInputData objects with the same username should be equal");
    }
}

