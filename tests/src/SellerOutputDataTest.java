package src;


import org.junit.jupiter.api.Test;
import use_case.allUser.sellerPage.SellerOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for SellerOutputData class.
 */
public class SellerOutputDataTest {

    @Test
    public void testConstructorAndGetterMethods() {
        String expectedUsername = "testUser";
        boolean expectedSuccess = true;

        SellerOutputData sellerOutputData = new SellerOutputData(expectedUsername, expectedSuccess);

        assertEquals(expectedUsername, sellerOutputData.username(), "The username should be correctly stored and retrieved.");
        assertEquals(expectedSuccess, sellerOutputData.successful(), "The success status should be correctly stored and retrieved.");
    }

    @Test
    public void testEquality() {
        String username = "testUser";
        SellerOutputData data1 = new SellerOutputData(username, true);
        SellerOutputData data2 = new SellerOutputData(username, true);

        assertEquals(data1, data2, "Two GuestInputData objects with the same username should be equal");
    }
}

