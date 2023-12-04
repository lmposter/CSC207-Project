package interface_adapter.guestPage;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.guestPage.GuestOutputBoundary;
import use_case.guestPage.GuestOutputData;

/**
 * The GuestPresenter class is responsible for presenting the guest functionality and interacting with the UI.
 * It communicates with the use case through the GuestOutputBoundary to prepare views and handle user interactions.
 */
public class GuestPresenter implements GuestOutputBoundary
{

    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GuestViewModel guestViewModel;
    private final LoginViewModel loginViewModel;
    private final SearchViewModel searchViewModel;

    /**
     * Constructs a GuestPresenter with the necessary view models and models.
     *
     * @param signupViewModel  The view model for signup functionality.
     * @param viewManagerModel The model for managing the view.
     * @param guestViewModel   The view model for guest functionality.
     * @param loginViewModel   The view model for login functionality.
     * @param searchViewModel  The view model for search functionality.
     */
    public GuestPresenter(SignupViewModel signupViewModel, ViewManagerModel viewManagerModel, GuestViewModel guestViewModel, LoginViewModel loginViewModel, SearchViewModel searchViewModel)
    {
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.guestViewModel = guestViewModel;
        this.loginViewModel = loginViewModel;
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareSuccessView(GuestOutputData guestOutputData)
    {
        // Handle the successful output data if needed.
    }

    @Override
    public void prepareFailView(String errorMessage)
    {
        // Update the signup state with an error message and notify the UI.
        SignupState loginState = signupViewModel.getState();
        loginState.setUsernameError(errorMessage);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchPageLogOut()
    {
        // Switch to the login page when logging out.
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Switches to the search page with the provided username.
     *
     * @param username The username of the guest.
     */
    public void switchPageSearch(String username)
    {
        // Update the search state with the username and switch to the search page.
        SearchState searchState = searchViewModel.getState();
        searchState.setUsername(username);
        searchState.setBuyer(false);
        this.viewManagerModel.setActiveView(searchViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}