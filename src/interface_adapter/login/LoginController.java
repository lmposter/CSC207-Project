package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * The LoginController class is responsible for handling user interface actions related to the login functionality.
 * It communicates with the use case through the LoginInputBoundary and processes user input.
 */
public class LoginController {

    private final LoginInputBoundary loginInteractor;

    /**
     * Constructs a LoginController with the provided LoginInputBoundary.
     *
     * @param loginInteractor The login use case interactor responsible for handling login logic.
     */
    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    /**
     * Executes the login action triggered by the user interface.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     */
    public void execute(String username, String password) {
        // Create LoginInputData from user input
        LoginInputData loginInputData = new LoginInputData(username, password);

        // Execute the login process through the use case interactor
        loginInteractor.execute(loginInputData);
    }
}