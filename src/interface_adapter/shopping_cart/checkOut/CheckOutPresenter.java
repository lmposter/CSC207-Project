package interface_adapter.shopping_cart.checkOut;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.CheckOut.CheckOutOutputBoundary;

public class CheckOutPresenter implements CheckOutOutputBoundary
{
    private ViewManagerModel viewManagerModel;
    private ShoppingCartViewModel shoppingCartViewModel;

    public CheckOutPresenter(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel)
    {
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }
}
