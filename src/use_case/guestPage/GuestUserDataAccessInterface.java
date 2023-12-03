package use_case.guestPage;

import entity.LoginUser;

/**
 * The LoginUserDataAccessInterface interface defines methods for accessing user-related data.
 * It includes operations such as retrieving user information, checking account existence, and managing login attempts.
 */
public interface GuestUserDataAccessInterface {

    /**
     * Retrieve a LoginUser object based on the given username.
     *
     * @param username The username of the user to retrieve.
     * @return The LoginUser object if found, or null if the user does not exist.
     */
    LoginUser get(String username);
}