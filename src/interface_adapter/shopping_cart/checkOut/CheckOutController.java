package interface_adapter.shopping_cart.checkOut;

import use_case.CheckOut.CheckOutInputBoundary;

public class CheckOutController
{
    private final CheckOutInputBoundary checkOutInteractor;

    public CheckOutController(CheckOutInputBoundary checkOutInteractor)
    {
        this.checkOutInteractor = checkOutInteractor;
    }

    public void execute()
    {
        this.checkOutInteractor.execute();
    }

}
