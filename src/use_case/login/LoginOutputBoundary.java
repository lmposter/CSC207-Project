package use_case.login;

/**
 * The LoginOutputBoundary interface defines methods for presenting the output of the login use case.
 * It includes operations for preparing views in case of successful and failed login attempts.
 */
public interface LoginOutputBoundary {

    /**
     * Prepare the view for a successful login attempt.
     *
     * @param loginOutputData The output data containing user information.
     */
    void prepareSuccessView(LoginOutputData loginOutputData);

    /**
     * Prepare the view for a failed login attempt.
     *
     * @param errorMessage The error message to be displayed.
     */
    void prepareFailView(String errorMessage);
}