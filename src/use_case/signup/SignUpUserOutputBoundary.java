package use_case.signup;

/**
 * Output boundary interface for the user signup use case.
 */
public interface SignUpUserOutputBoundary {

    /**
     * Prepares the view for successful user signup.
     *
     * @param signUpOutputData The output data containing information about the signed-up user.
     */
    void prepareSuccessView(SignUpUserOutputData signUpOutputData);

    /**
     * Prepares the view for a failed user signup with an error message.
     *
     * @param error The error message describing the reason for the signup failure.
     */
    void prepareFailView(String error);
}
