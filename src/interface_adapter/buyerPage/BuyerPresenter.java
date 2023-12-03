package interface_adapter.buyerPage;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.buyerPage.BuyerOutputBoundary;
import use_case.buyerPage.BuyerOutputData;


public class BuyerPresenter implements BuyerOutputBoundary {

    private final SignupViewModel signupViewModel;

    private final ViewManagerModel viewManagerModel;
    private final BuyerViewModel buyerViewModel;
    private final LoginViewModel loginViewModel;
    private final SearchViewModel searchViewModel;
    private final Orders orderViewModel;
    private final ShoppingCartViewModel shoppingCartViewModel;
    private final StorePageViewModel storePageViewModel;

    public BuyerPresenter(SignupViewModel signupViewModel,
                          ViewManagerModel viewManagerModel,
                          BuyerViewModel buyerViewModel,
                          LoginViewModel loginViewModel,
                          SearchViewModel searchViewModel,
                          Orders orderViewModel,
                          ShoppingCartViewModel shoppingCartViewModel,
                          StorePageViewModel storePageViewModel) {

        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.buyerViewModel = buyerViewModel;
        this.loginViewModel = loginViewModel;
        this.searchViewModel = searchViewModel;
        this.orderViewModel = orderViewModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.storePageViewModel = storePageViewModel;
    }

    @Override
    public void prepareSuccessView(BuyerOutputData buyerOutputData) {
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

    public void switchPageOrder(String username) {
//        SearchState searchState = searchViewModel.getState();
//        searchState.setUsername(username);
        this.viewManagerModel.setActiveView(orderViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageShoppingCart(String username) {
//        SearchState searchState = searchViewModel.getState();
//        searchState.setUsername(username);
        this.viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageStorePage(String username) {
//        SearchState searchState = searchViewModel.getState();
//        searchState.setUsername(username);
        this.viewManagerModel.setActiveView(storePageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
