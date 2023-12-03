package use_case.signup;

/**
 * Data class representing output data for the user signup use case.
 */
public record SignUpUserOutputData(String username, String id, boolean useCaseFailed) {

    /**
     * Constructor for SignUpUserOutputData.
     *
     * @param username      The username of the signed-up user.
     * @param useCaseFailed Indicates whether the use case (signup) has failed.
     */
    public SignUpUserOutputData {
    }

    /**
     * Gets the username of the signed-up user.
     *
     * @return The username.
     */
    @Override
    public String username() {
        return username;
    }

    /**
     * Gets the username of the signed-up user.
     *
     * @return The id.
     */
    @Override
    public String id(){
        return id;
    }

    /**
     * Checks if the use case (signup) has failed.
     *
     * @return true if the use case has failed, false otherwise.
     */
    @Override
    public boolean useCaseFailed() {
        return useCaseFailed;
    }
}