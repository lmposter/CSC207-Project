package interface_adapter.AllUserPage.buyerPage;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.OrderPresenter;
import interface_adapter.orders.OrderState;
import interface_adapter.orders.OrderViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.allUser.buyerPage.BuyerOutputBoundary;
import use_case.allUser.buyerPage.BuyerOutputData;

public class BuyerPresenter implements BuyerOutputBoundary
{
    // Fields for various view models and models
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;
    private final BuyerViewModel buyerViewModel;
    private final LoginViewModel loginViewModel;
    private final SearchViewModel searchViewModel;
    private final OrderViewModel orderViewModel;
    private final ShoppingCartViewModel shoppingCartViewModel;
    private final StorePageViewModel storePageViewModel;

    // Constructor to initialize the presenter with required dependencies
    public BuyerPresenter(SignupViewModel signupViewModel, ViewManagerModel viewManagerModel, BuyerViewModel buyerViewModel, LoginViewModel loginViewModel, SearchViewModel searchViewModel, OrderViewModel orderViewModel, ShoppingCartViewModel shoppingCartViewModel, StorePageViewModel storePageViewModel)
    {
        // Initialize view models and models
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.buyerViewModel = buyerViewModel;
        this.loginViewModel = loginViewModel;
        this.searchViewModel = searchViewModel;
        this.orderViewModel = orderViewModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.storePageViewModel = storePageViewModel;
    }

    // Implementing interface method to prepare the view for successful operation
    @Override
    public void prepareSuccessView(BuyerOutputData buyerOutputData)
    {
        // Implement this method to handle the view when a successful operation occurs
    }

    // Implementing interface method to prepare the view for a failed operation
    @Override
    public void prepareFailView(String errorMessage)
    {
        // Set the error message in the signup view model and notify of the property change
        SignupState loginState = signupViewModel.getState();
        loginState.setUsernameError(errorMessage);
        signupViewModel.firePropertyChanged();
    }

    // Method to switch to the login page when the user logs out
    @Override
    public void switchPageLogOut()
    {
        // Set the active view to the login view and notify of the property change
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    // Methods to switch to different pages in the application
    public void switchPageSearch(String username)
    {
        // Set the username in the search view model and switch to the search page
        SearchState searchState = searchViewModel.getState();
        searchState.setUsername(username);
        searchState.setUser(1);
        this.viewManagerModel.setActiveView(searchViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageOrder(String username)
    {
        // Switch to the order page
        OrderState orderState = orderViewModel.getState();
        orderState.setUsername(username);
        orderViewModel.setState(orderState);
        this.viewManagerModel.setActiveView(orderViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageShoppingCart(String username)
    {
        // Switch to the shopping cart page
        this.viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageStorePage(String username)
    {
        // Switch to the store page
        this.viewManagerModel.setActiveView(storePageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}