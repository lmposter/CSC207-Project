package src;

import org.junit.jupiter.api.Test;
import use_case.allUser.guestPage.GuestOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for GuestOutputData record.
 */
public class GuestOutputDataTest {

    /**
     * Test the constructor of GuestOutputData.
     */
    @Test
    public void testConstruction() {
        String expectedUsername = "testUser";
        Boolean bool = true;
        GuestOutputData guestOutputData = new GuestOutputData(expectedUsername, true);

        assertEquals(bool, guestOutputData.successful(), "The username should match the input provided");
        assertEquals(expectedUsername, guestOutputData.username(), "The username should match the input provided");
    }

    /**
     * Test the equality of two GuestOutputData objects.
     */
    @Test
    public void testEquality() {
        String username = "testUser";
        GuestOutputData data1 = new GuestOutputData(username, true);
        GuestOutputData data2 = new GuestOutputData(username, true);

        assertEquals(data1, data2, "Two GuestOutputData objects with the same username should be equal");
    }
}