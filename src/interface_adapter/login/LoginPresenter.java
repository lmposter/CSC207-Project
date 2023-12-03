package interface_adapter.login;

import interface_adapter.ViewManagerModel;
//import interface_adapter.buyerPage.BuyerViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
//import interface_adapter.buyerPage.BuyerState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
//    private final BuyerViewModel buyerViewModel;
//    private final SellerViewModel sellerViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
//                          BuyerViewModel buyerViewModel,
//                          SellerViewModel sellerViewModel,
                          LoginViewModel loginViewModel,
                          SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
//        this.buyerViewModel = buyerViewModel;
//        this.sellerViewModel = sellerViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
//        if (response.id().startsWith("B")){
//            BuyerState guestState = BuyerViewModel.getState();
//            guestState.setUsername(response.username());
//            this.buyerViewModel.setState(guestState);
//            this.buyerViewModel.firePropertyChanged();
//
//            this.viewManagerModel.setActiveView(buyerViewModel.getViewName());
//            this.viewManagerModel.firePropertyChanged();
//        } else {
//            // On success, switch to the logged in view.
//            SellerState sellerState = sellerViewModel.getState();
//            sellerState.setUsername(response.username());
//            this.sellerViewModel.setState(loggedInState);
//            this.sellerViewModel.firePropertyChanged();
//
//            this.viewManagerModel.setActiveView(sellerViewModel.getViewName());
//            this.viewManagerModel.firePropertyChanged();
//        }
    }

    @Override
    public void prepareFailView(String error) {
        SignupState loginState = signupViewModel.getState();
        loginState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchPage() {
        this.viewManagerModel.setActiveView(signupViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
