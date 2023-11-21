package use_case.signup;

import java.util.List;

import entity.LoginUser;

/**
 * Interface for accessing data related to user signup operations.
 */
public interface SignUpUserDataAccessInterface {

    /**
     * Checks if a user with the given identifier (usually the username) already exists.
     *
     * @param identifier The unique identifier for the user (e.g., username).
     * @return true if a user with the given identifier exists, false otherwise.
     */
    boolean existsByName(String identifier);

    /**
     * Saves the user information to the data store.
     *
     * @param user The user object containing the information to be saved.
     */
    void save(LoginUser user);

    /**
     * Check if a user with the given email address already exists.
     *
     * @param email The email address of the user.
     * @return true if a user with the given email exists, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Retrieves a user by their ID.
     *
     * @param identifier The unique identifier for the user.
     * @return The user object if found, or null if not found.
     */
    LoginUser getUserByIdentifier(String identifier);

    /**
     * Deletes the user with the given identifier from the data store.
     *
     * @param identifier The unique identifier for the user to be deleted.
     */
    void deleteByIdentifier(String identifier);

    /**
     * Updates the user information in the data store.
     *
     * @param user The updated user object.
     */
    void update(LoginUser user);

    /**
     * Retrieves a list of all users in the data store.
     *
     * @return List of all users.
     */
    List<LoginUser> getAllUsers();
}