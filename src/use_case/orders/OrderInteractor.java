package use_case.orders;

import entity.Product;
import entity.ProductFactory;
import interface_adapter.API.WalmartAPI;
import use_case.search.SearchDAI;
import use_case.search.SearchInputData;
import use_case.search.SearchOutPutBoundary;
import use_case.search.SearchOutPutData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class OrderInteractor implements OrderInputBoundary{

    private final OrderOutputBoundary orderPresenter;
    private final OrderDAO orderDAO;

    public OrderInteractor(OrderDAO orderDAO, OrderOutputBoundary orderPresenter) {
        this.orderDAO = orderDAO;
        this.orderPresenter = orderPresenter;
    }

    @Override
    public void execute(OrderInputData orderInputData) {
        orderDAO.execute(orderInputData);
        orderDAO.getProducts(orderInputData.username());
    }

    @Override
    public void switchPage() {
        orderPresenter.switchPage();
    }
}
