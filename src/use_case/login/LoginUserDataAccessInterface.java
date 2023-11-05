package use_case.login;

import entity.LoginUser;

/**
 * The LoginUserDataAccessInterface interface defines methods for accessing user-related data.
 * It includes operations such as retrieving user information, checking account existence, and managing login attempts.
 */
public interface LoginUserDataAccessInterface {

    /**
     * Check if a user with the given username exists.
     *
     * @param username The username to check.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByName(String username);

    /**
     * Retrieve a LoginUser object based on the given username.
     *
     * @param username The username of the user to retrieve.
     * @return The LoginUser object if found, or null if the user does not exist.
     */
    LoginUser get(String username);

    /**
     * Check if the account associated with the given username is locked.
     *
     * @param username The username to check for account lock status.
     * @return True if the account is locked, false otherwise.
     */
    boolean isAccountLocked(String username);

    /**
     * Increment the number of failed login attempts for the given username.
     *
     * @param username The username for which to increment failed login attempts.
     */
    void incrementFailedLoginAttempts(String username);

    /**
     * Check if the maximum number of failed login attempts is reached for the given username.
     *
     * @param username The username to check for maximum failed login attempts.
     * @return True if the maximum failed attempts are reached, false otherwise.
     */
    boolean isMaxFailedAttemptsReached(String username);

    /**
     * Lock the account associated with the given username.
     *
     * @param username The username for which to lock the account.
     */
    void lockAccount(String username);

    /**
     * Reset the number of failed login attempts for the given username.
     *
     * @param username The username for which to reset failed login attempts.
     */
    void resetFailedLoginAttempts(String username);

    /**
     * Deactivate the account associated with the given username.
     *
     * @param username The username for which to deactivate the account.
     */
    void deactivateAccount(String username);
}