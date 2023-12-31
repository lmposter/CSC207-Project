package entity;

import java.util.UUID;

/**
 * The Guest class represents a guest user in the system.
 * Guests are identified by a unique ID and have a default name.
 */
public class Guest implements LoginUser {

    /**
     * Unique identifier for the guest.
     */
    private final String id;

    /**
     * Name of the guest.
     */
    private final String name;

    /**
     * Default constructor for creating a Guest.
     * Generates a unique ID for the guest and sets a default name.
     */
    public Guest() {
        this.id = "G" + UUID.randomUUID().toString();
        this.name = id;
    }

    /**
     * This method is not supported for Guest users.
     * Guest users are not allowed to change their name.
     * Calling this method will print a warning message.
     */
    public void setName(String name) {
        System.out.println("Warning: Guest users are not allowed to set password.");
    }

    @Override
    public void setPassword(String password) {
        System.out.println("Warning: Guest users are not allowed to set password.");
    }

    /**
     * Get the unique identifier of the guest.
     *
     * @return The guest ID.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Get the name of the guest.
     *
     * @return The guest name.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return "null";
    }
}