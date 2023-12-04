package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.AllUserPage.buyerPage.BuyerState;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.AllUserPage.sellerPage.SellerState;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The LoginPresenter class is responsible for preparing and displaying views based on login outcomes.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final BuyerViewModel buyerViewModel;
    private final SellerViewModel sellerViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a LoginPresenter with the required view models and view manager model.
     *
     * @param viewManagerModel The view manager model for managing views.
     * @param buyerViewModel   The view model for the buyer.
     * @param sellerViewModel  The view model for the seller.
     * @param loginViewModel   The view model for login.
     * @param signupViewModel  The view model for signup.
     */
    public LoginPresenter(ViewManagerModel viewManagerModel,
                          BuyerViewModel buyerViewModel,
                          SellerViewModel sellerViewModel,
                          LoginViewModel loginViewModel,
                          SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.buyerViewModel = buyerViewModel;
        this.sellerViewModel = sellerViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        if (response.id().startsWith("B")) {
            // Prepare the buyer view and switch to it on successful login.
            BuyerState buyerState = buyerViewModel.getState();
            buyerState.setUsername(response.username());
            this.buyerViewModel.setState(buyerState);
            this.buyerViewModel.firePropertyChanged();

            this.viewManagerModel.setActiveView(buyerViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        } else {
            // Prepare the seller view and switch to it on successful login.
            SellerState sellerState = sellerViewModel.getState();
            sellerState.setUsername(response.username());
            this.sellerViewModel.setState(sellerState);
            this.sellerViewModel.firePropertyChanged();

            this.viewManagerModel.setActiveView(sellerViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void prepareFailView(String error) {
        // Prepare the signup view and display an error message on login failure.
        SignupState loginState = signupViewModel.getState();
        loginState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchPage() {
        // Switch to the signup view.
        this.viewManagerModel.setActiveView(signupViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}