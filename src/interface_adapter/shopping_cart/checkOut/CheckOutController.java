package interface_adapter.shopping_cart.checkOut;

import use_case.CheckOut.CheckOutInputBoundary;
import use_case.CheckOut.CheckOutInputData;

public class CheckOutController
{
    private final CheckOutInputBoundary checkOutInteractor;

    public CheckOutController(CheckOutInputBoundary checkOutInteractor)
    {
        this.checkOutInteractor = checkOutInteractor;
    }

    public void execute(String username)
    {
        CheckOutInputData checkOutInputData = new CheckOutInputData(username);
        this.checkOutInteractor.execute(checkOutInputData);
    }

}
