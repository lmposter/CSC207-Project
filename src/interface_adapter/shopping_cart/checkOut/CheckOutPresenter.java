package interface_adapter.shopping_cart.checkOut;

import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import use_case.CheckOut.CheckOutOutputBoundary;
import use_case.CheckOut.CheckOutOutputData;

public class CheckOutPresenter implements CheckOutOutputBoundary
{
    private ViewManagerModel viewManagerModel;
    private ShoppingCartViewModel shoppingCartViewModel;

    public CheckOutPresenter(ViewManagerModel viewManagerModel, ShoppingCartViewModel shoppingCartViewModel)
    {
        this.viewManagerModel = viewManagerModel;
        this.shoppingCartViewModel = shoppingCartViewModel;
    }

    @Override
    public void prepareSuccessView(CheckOutOutputData checkOutOutputData)
    {

    }

    @Override
    public void soldOutView()
    {

    }
}
