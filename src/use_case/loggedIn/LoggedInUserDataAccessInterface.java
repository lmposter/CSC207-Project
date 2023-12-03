package use_case.loggedIn;

import entity.LoginUser;

/**
 * The LoginUserDataAccessInterface interface defines methods for accessing user-related data.
 * It includes operations such as retrieving user information, checking account existence, and managing login attempts.
 */
public interface LoggedInUserDataAccessInterface {

    /**
     * Retrieve a LoginUser object based on the given username.
     *
     * @param username The username of the user to retrieve.
     * @return The LoginUser object if found, or null if the user does not exist.
     */
    LoginUser get(String username);
    /**
     * Change the user's password
     *
     * @param username The username for which to change the password.
     * @param password The password to change to.
     */
    void changePassword(String username, String password);

    boolean existsByName(String username);
}