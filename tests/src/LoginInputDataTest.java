package src;

import org.junit.jupiter.api.Test;
import use_case.login.LoginInputData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LoginInputData record.
 */
public class LoginInputDataTest {

    /**
     * Test the constructor and accessors of LoginInputData.
     */
    @Test
    public void testLoginInputDataConstructionAndAccessors() {
        String expectedUsername = "testUser";
        String expectedPassword = "testPassword";
        LoginInputData loginInputData = new LoginInputData(expectedUsername, expectedPassword);

        assertEquals(expectedUsername, loginInputData.username(), "The username should match the input provided");
        assertEquals(expectedPassword, loginInputData.password(), "The password should match the input provided");
    }

    /**
     * Test the equality of two LoginInputData objects.
     */
    @Test
    public void testEquality() {
        String username = "testUser";
        String password = "testPassword";
        LoginInputData data1 = new LoginInputData(username, password);
        LoginInputData data2 = new LoginInputData(username, password);

        assertEquals(data1, data2, "Two LoginInputData objects with the same username and password should be equal");
    }
}
