package entity;

/**
 * The User interface represents a generic user in the system.
 * Users have a unique identifier, a name, and the ability to set their name.
 */
public interface User {

    /**
     * Set the name for the user.
     * The implementation of this method should allow users to change their name.
     * The specific behavior may vary for different user types.
     */
    void setName(String name);

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
}