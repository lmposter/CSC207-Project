package interface_adapter.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignUpUserOutputBoundary;
import use_case.signup.SignUpUserOutputData;

public class SignupPresenter implements SignUpUserOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(SignUpUserOutputData response) {
        // On success, switch to the login view.

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.username());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void switchPage(){
        LoginState loginState = loginViewModel.getState();
        this.loginViewModel.setState(loginState);

        loginViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
//need edit here
