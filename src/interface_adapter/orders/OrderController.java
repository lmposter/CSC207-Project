package interface_adapter.orders;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
import use_case.orders.OrderInputBoundary;
import use_case.orders.OrderInputData;
import use_case.orders.OrderInteractor;

import java.util.List;

public class OrderController
{

    private final OrderInputBoundary orderInteractor;

    public OrderController(OrderInputBoundary orderInteractor)
    {
        this.orderInteractor = orderInteractor;
    }

    public void switchPage()
    {
        orderInteractor.switchPage();
    }

    public List<String[]> findProducts(String username)
    {
        return orderInteractor.findProducts(username);
    }
}