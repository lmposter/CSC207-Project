package src;

import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputData;
import use_case.signup.SignUpUserInputData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for SignUpUserInputData class.
 */
public class SignUpUserInputDataTest {

    @Test
    public void testUsernameGetter() {
        String expectedUsername = "testUser";
        SignUpUserInputData signUpUserInputData = new SignUpUserInputData(expectedUsername, "password123", "password123", "email");
        assertEquals(expectedUsername, signUpUserInputData.username(), "Username should match the provided value");
    }

    @Test
    public void testPasswordGetter() {
        String expectedPassword = "password123";
        SignUpUserInputData signUpUserInputData = new SignUpUserInputData("testUser", expectedPassword, "password123", "email");
        assertEquals(expectedPassword, signUpUserInputData.password(), "Password should match the provided value");
    }

    @Test
    public void testRepeatPasswordGetter() {
        String expectedRepeatPassword = "password123";
        SignUpUserInputData signUpUserInputData = new SignUpUserInputData("testUser", "password123", expectedRepeatPassword, "email");
        assertEquals(expectedRepeatPassword, signUpUserInputData.repeatPassword(), "Repeated password should match the provided value");
    }

    @Test
    public void testSignTypeGetter() {
        String expectedSignType = "guest";
        SignUpUserInputData signUpUserInputData = new SignUpUserInputData("testUser", "password123", "password123", expectedSignType);
        assertEquals(expectedSignType, signUpUserInputData.signType(), "Sign type should match the provided value");
    }

    @Test
    public void testEquality() {
        String username = "testUser";
        String id = "userId123";
        SignUpUserInputData data1 = new SignUpUserInputData(username, id, id, "buyer");
        SignUpUserInputData data2 = new SignUpUserInputData(username, id, id, "buyer");

        assertEquals(data1, data2, "Two LoginOutputData objects with the same username, id, and successful flag should be equal");
    }
}
