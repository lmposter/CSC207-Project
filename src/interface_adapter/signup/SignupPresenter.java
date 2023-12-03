package interface_adapter.signup;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignUpUserOutputBoundary;
import use_case.signup.SignUpUserOutputData;

/**
 * Presenter for the signup process in an MVP architecture.
 * Handles the presentation logic for signup, including updating the view model and managing view transitions.
 */
public class SignupPresenter implements SignUpUserOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;

    /**
     * Constructor for SignupPresenter.
     *
     * @param viewManagerModel    Model for managing views.
     * @param signupViewModel     ViewModel associated with signup.
     * @param loginViewModel      ViewModel associated with login.
     * @param loggedInViewModel   ViewModel for logged in state.
     */
    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel,
                           LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    /**
     * Prepares and displays the success view after signup.
     * Updates the relevant state and transitions to the next view.
     *
     * @param response Contains data related to the successful signup.
     */
    @Override
    public void prepareSuccessView(SignUpUserOutputData response) {
        // On success, switch to the login view or logged-in view based on the response.
        if (response.username().startsWith("Guest")){
            // Setup and transition to the logged-in view for guest users.
            LoggedInState loggedInState = loggedInViewModel.getState();
            loggedInState.setUsername(response.username());
            this.loggedInViewModel.setState(loggedInState);
            this.loggedInViewModel.firePropertyChanged();

            this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        } else {
            // Setup and transition to the login view for regular users.
            LoginState loginState = loginViewModel.getState();
            loginState.setUsername(response.username());
            this.loginViewModel.setState(loginState);
            loginViewModel.firePropertyChanged();

            viewManagerModel.setActiveView(loginViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    }

    /**
     * Switches to the login page.
     * This method can be used for transitioning from the signup view to the login view.
     */
    public void switchPage(){
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares and displays the failure view when signup fails.
     * Updates the signup state with the error message.
     *
     * @param error Error message indicating the cause of failure.
     */
    @Override
    public void prepareFailView(String error) {
        // Update the signup state with the provided error message.
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}