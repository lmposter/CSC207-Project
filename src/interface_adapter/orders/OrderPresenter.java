package interface_adapter.orders;

import entity.Buyer;
import interface_adapter.AllUserPage.buyerPage.BuyerState;
import interface_adapter.ViewManagerModel;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.signup.SignupState;
import use_case.login.LoginOutputData;
import use_case.orders.OrderInputData;
import use_case.orders.OrderOutputBoundary;

public class OrderPresenter implements OrderOutputBoundary {

    private final BuyerViewModel buyerViewModel;
    private ViewManagerModel viewManagerModel;

    public OrderPresenter(ViewManagerModel viewManagerModel,
                          BuyerViewModel buyerViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.buyerViewModel = buyerViewModel;
    }


    @Override
    public void prepareSuccessView(OrderInputData orderInputData) {

    }


    @Override
    public void prepareFailView(String error) {
        // Prepare the signup view and display an error message on login failure.
        BuyerState buyerState = buyerViewModel.getState();
//        buyerState.setUsernameError("fetch properly");
        buyerViewModel.firePropertyChanged();
    }

    @Override
    public void switchPage() {
        // Switch to the signup view.
        this.viewManagerModel.setActiveView(buyerViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}