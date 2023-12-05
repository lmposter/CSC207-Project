package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import use_case.login.LoginOutputData;

/**
 * Test class for LoginOutputData record.
 */
public class LoginOutputDataTest {

    /**
     * Test the constructor and accessors of LoginOutputData.
     */
    @Test
    public void testLoginOutputDataConstructionAndAccessors() {
        String expectedUsername = "testUser";
        String expectedId = "userId123";
        boolean expectedSuccess = true;
        LoginOutputData loginOutputData = new LoginOutputData(expectedUsername, expectedId, expectedSuccess);

        assertEquals(expectedUsername, loginOutputData.username(), "The username should match the input provided");
        assertEquals(expectedId, loginOutputData.id(), "The id should match the input provided");
        assertEquals(expectedSuccess, loginOutputData.successful(), "The successful flag should match the input provided");
    }

    /**
     * Test the equality of two LoginOutputData objects.
     */
    @Test
    public void testEquality() {
        String username = "testUser";
        String id = "userId123";
        boolean successful = true;
        LoginOutputData data1 = new LoginOutputData(username, id, successful);
        LoginOutputData data2 = new LoginOutputData(username, id, successful);

        assertEquals(data1, data2, "Two LoginOutputData objects with the same username, id, and successful flag should be equal");
    }
}
