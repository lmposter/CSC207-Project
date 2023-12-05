package src;

import use_case.allUser.guestPage.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for GuestInputData record.
 */
public class GuestInputDataTest {

    /**
     * Test the constructor of GuestInputData.
     */
    @Test
    public void testConstruction() {
        String expectedUsername = "testUser";
        GuestInputData guestInputData = new GuestInputData(expectedUsername);

        assertEquals(expectedUsername, guestInputData.username(), "The username should match the input provided");
    }

    /**
     * Test the equality of two GuestInputData objects.
     */
    @Test
    public void testEquality() {
        String username = "testUser";
        GuestInputData data1 = new GuestInputData(username);
        GuestInputData data2 = new GuestInputData(username);

        assertEquals(data1, data2, "Two GuestInputData objects with the same username should be equal");
    }
}