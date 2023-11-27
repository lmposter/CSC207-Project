package use_case.CheckOut;

import entity.Buyer;
import entity.Product;

import java.util.HashMap;

public class CheckOutInteractor implements CheckOutInputBoundary
{
    private final CheckOutOutputBoundary checkOutPresenter;
    private final CheckOutUserDataAccessInterface userDataAccess;

    private final CheckOutProductDataAccessInterface productDataAccess;

    public CheckOutInteractor(CheckOutOutputBoundary checkOutPresenter, CheckOutUserDataAccessInterface userDataAccess, CheckOutProductDataAccessInterface productDataAccess)
    {
        this.checkOutPresenter = checkOutPresenter;
        this.userDataAccess = userDataAccess;
        this.productDataAccess = productDataAccess;
    }

    @Override
    public void execute(CheckOutInputData checkOutInputData)
    {
        String username = checkOutInputData.getUsername();
        Buyer user = (Buyer) userDataAccess.get(username);
        HashMap<Product, Integer> products = user.getCart().getCart();
        for (Product i : products.keySet())
        {
            if (productDataAccess.getInvertory(i.getId()) < products.get(i))
            {
                this.checkOutPresenter.soldOutView();
                return;
            }
        }
        CheckOutOutputData outputData = new CheckOutOutputData(user.getCart().getPrice());
        userDataAccess.clearCart(username);
        this.checkOutPresenter.prepareSuccessView(outputData);

    }
}
