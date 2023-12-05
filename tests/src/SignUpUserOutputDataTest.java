package src;

import org.junit.jupiter.api.Test;
import use_case.signup.SignUpUserInputData;
import use_case.signup.SignUpUserOutputData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for SignUpUserOutputData class.
 */
public class SignUpUserOutputDataTest {

    @Test
    public void testUsernameGetter() {
        String expectedUsername = "testUser";
        SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData(expectedUsername, "123", false);
        assertEquals(expectedUsername, signUpUserOutputData.username(), "Username should match the provided value");
    }

    @Test
    public void testIdGetter() {
        String expectedId = "123";
        SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData("testUser", expectedId, false);
        assertEquals(expectedId, signUpUserOutputData.id(), "ID should match the provided value");
    }

    @Test
    public void testUseCaseFailedGetter() {
        SignUpUserOutputData signUpUserOutputData = new SignUpUserOutputData("testUser", "123", true);
        assertTrue(signUpUserOutputData.useCaseFailed(), "useCaseFailed should return true");

        signUpUserOutputData = new SignUpUserOutputData("testUser", "123", false);
        assertFalse(signUpUserOutputData.useCaseFailed(), "useCaseFailed should return false");
    }

    @Test
    public void testEquality() {
        String username = "testUser";
        String id = "userId123";
        SignUpUserOutputData data1 = new SignUpUserOutputData(username, id, true);
        SignUpUserOutputData data2 = new SignUpUserOutputData(username, id, true);

        assertEquals(data1, data2, "Two LoginOutputData objects with the same username, id, and successful flag should be equal");
    }
}