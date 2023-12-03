package interface_adapter.sellerPage;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.Orders;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import use_case.sellerPage.SellerOutputBoundary;
import use_case.sellerPage.SellerOutputData;

/**
 * The SellerPresenter class handles the presentation logic for the seller's dashboard.
 * It interacts with various view models and manages the navigation between different views.
 */
public class SellerPresenter implements SellerOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;
    private final SellerViewModel sellerViewModel;
    private final LoginViewModel loginViewModel;
    private final SearchViewModel searchViewModel;
    private final Orders orderViewModel;
    private final ShoppingCartViewModel shoppingCartViewModel;
    private final StorePageViewModel storePageViewModel;

    /**
     * Constructs a SellerPresenter with the necessary view models and models.
     *
     * @param signupViewModel       The view model for the signup view.
     * @param viewManagerModel      The model for managing the active view.
     * @param sellerViewModel       The view model for the seller's dashboard.
     * @param loginViewModel        The view model for the login view.
     * @param searchViewModel       The view model for the search view.
     * @param orderViewModel        The view model for the orders view.
     * @param shoppingCartViewModel The view model for the shopping cart view.
     * @param storePageViewModel    The view model for the store page view.
     */
    public SellerPresenter(SignupViewModel signupViewModel,
                           ViewManagerModel viewManagerModel,
                           SellerViewModel sellerViewModel,
                           LoginViewModel loginViewModel,
                           SearchViewModel searchViewModel,
                           Orders orderViewModel,
                           ShoppingCartViewModel shoppingCartViewModel,
                           StorePageViewModel storePageViewModel) {

        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.sellerViewModel = sellerViewModel;
        this.loginViewModel = loginViewModel;
        this.searchViewModel = searchViewModel;
        this.orderViewModel = orderViewModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
        this.storePageViewModel = storePageViewModel;
    }

    @Override
    public void prepareSuccessView(SellerOutputData sellerOutputData) {
        // Logic to prepare and display a successful view
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
        this.viewManagerModel.setActiveView(orderViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageShoppingCart(String username) {
        this.viewManagerModel.setActiveView(shoppingCartViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void switchPageStorePage(String username) {
        this.viewManagerModel.setActiveView(storePageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}