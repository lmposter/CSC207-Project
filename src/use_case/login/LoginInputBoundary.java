package use_case.login;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface LoginInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     *
     * @param loginInputData The input data containing username and password for login.
     */
    void execute(LoginInputData loginInputData);
}