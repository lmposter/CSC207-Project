package use_case.orders;

/**
 * The OrderInputData class represents the input data for the user tracking order process.
 * It holds information such as the username and password.
 */
public record OrderInputData(String username)
{

    /**
     * Gets the username.
     *
     * @return The username for the user.
     */
    @Override
    public String username()
    {
        return username;
    }
}