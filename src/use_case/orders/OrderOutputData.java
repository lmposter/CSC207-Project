package use_case.orders;

/**
 * The OrderOutputData class represents the output data for the order use case.
 * It holds information to be presented in the view after a clicking order.
 */
public record OrderOutputData(String username, boolean successful)
{

    /**
     * Constructs a OrderOutputData object with the provided username and success status.
     *
     * @param username   The username associated with the user.
     * @param successful True if the tracking was successful, false otherwise.
     */
    public OrderOutputData
    {
    }

    /**
     * Gets the username associated with the login attempt.
     *
     * @return The username.
     */
    @Override
    public String username()
    {
        return username;
    }

    /**
     * Gets if the attempt is success.
     *
     * @return successful.
     */
    @Override
    public boolean successful()
    {
        return successful;
    }
}