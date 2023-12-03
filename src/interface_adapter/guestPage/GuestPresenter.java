package interface_adapter.guestPage;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.guestPage.GuestOutputBoundary;
import use_case.guestPage.GuestOutputData;

public class GuestPresenter implements GuestOutputBoundary {

    private final SignupViewModel signupViewModel;

    private final ViewManagerModel viewManagerModel;
    private final GuestViewModel guestViewModel;
    private final LoginViewModel loginViewModel;
    private final SearchViewModel searchViewModel;

    public GuestPresenter(SignupViewModel signupViewModel,
                          ViewManagerModel viewManagerModel,
                          GuestViewModel guestViewModel,
                          LoginViewModel loginViewModel,
                          SearchViewModel searchViewModel) {

        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.guestViewModel = guestViewModel;
        this.loginViewModel = loginViewModel;
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareSuccessView(GuestOutputData guestOutputData) {
    }

    @Override
    public void prepareFailView(String errorMessage) {
        SignupState loginState = signupViewModel.getState();
        loginState.setUsernameError(errorMessage);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchPageLogOut() {
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageSearch(String username) {
        SearchState searchState = searchViewModel.getState();
        searchState.setUsername(username);
        this.viewManagerModel.setActiveView(searchViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
