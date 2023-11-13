package use_case.signup;

import entity.User;

import java.util.List;

/**
 * Input boundary for the user signup use case.
 */
public interface SignUpUserInputBoundary {

    void execute(SignUpUserInputData signUpUserInputData);

    /**
     * Handles the request to check if a user with the given identifier (usually the username) already exists.
     *
     * @param identifier The unique identifier for the user (e.g., username).
     * @return true if a user with the given identifier exists, false otherwise.
     */
    boolean checkUserExists(String identifier);

    /**
     * Handles the request to save user information.
     *
     * @param user The user object containing the information to be saved.
     */
    void saveUser(User user);

    /**
     * Handles the request to check if a user with the given email address already exists.
     *
     * @param email The email address of the user.
     * @return true if a user with the given email exists, false otherwise.
     */
    boolean checkUserExistsByEmail(String email);

    /**
     * Handles the request to retrieve a user by their unique identifier (e.g., username).
     *
     * @param identifier The unique identifier for the user.
     * @return The user object if found, or null if not found.
     */
    User getUserByIdentifier(String identifier);

    /**
     * Handles the request to delete the user with the given identifier.
     *
     * @param identifier The unique identifier for the user to be deleted.
     */
    void deleteUserByIdentifier(String identifier);

    /**
     * Handles the request to update user information.
     *
     * @param user The updated user object.
     */
    void updateUser(User user);

    /**
     * Handles the request to retrieve a list of all users.
     *
     * @return List of all users.
     */
    List<User> getAllUsers();
}