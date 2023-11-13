package interface_adapter.login;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The LoginPresenter class is responsible for presenting the output of the login use case.
 * It updates the UI based on the results of login attempts.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a LoginPresenter with the provided dependencies.
     *
     * @param viewManagerModel The view manager model to control the active view.
     * @param loggedInViewModel The view model for the logged-in state.
     * @param loginViewModel The view model for the login state.
     */
    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the view for a successful login attempt.
     *
     * @param response The output data containing user information.
     */
    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged-in view.

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.username());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed login attempt.
     *
     * @param error The error message to be displayed.
     */
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
