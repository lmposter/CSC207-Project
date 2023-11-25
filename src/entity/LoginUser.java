package entity;

/**
 * The LoginUser interface represents a user in the system with login credentials.
 * LoginUsers have a password in addition to the basic user attributes.
 */
public interface LoginUser{
    /**
     * Set the name for the user.
     * The implementation of this method should allow users to change their name.
     * The specific behavior may vary for different user types.
     */
    void setName(String name);
    /**
     * Set the password for the login user.
     * The implementation of this method should allow users to set or change their password.
     * The specific behavior may vary for different user types.
     */
    void setPassword(String password);
    /**
     * Get the unique identifier of the user.
     *
     * @return The user's ID.
     */
    String getId();
    /**
     * Get the name of the user.
     *
     * @return The user's name.
     */
    String getName();
    /**
     * Get the password of the login user.
     *
     * @return The user's password.
     */
    String getPassword();
}