package app;

import data_access.ProductDAO;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_cart.AddController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductPresenter;
import interface_adapter.product.ProductViewModel;

import interface_adapter.search.SearchViewModel;
import use_case.productDetails.ProductDetailsDAI;
import use_case.productDetails.ProductInputBoundary;
import use_case.productDetails.ProductInteractor;
import use_case.productDetails.ProductOutPutBoundary;

import view.ProductView;


import javax.swing.*;
import java.io.IOException;

public class ProductDetailsUseCaseFactory
{
    private ProductDetailsUseCaseFactory(){}

    public static ProductView createForBuyer(ViewManagerModel viewManagerModel, ProductViewModel productViewModel, ProductDAO userProductDAO, SearchViewModel searchViewModel, LoggedInViewModel loggedInViewModel, AddController addController)
    {

        try
        {
            ProductController productController = createUserProductUseCase(viewManagerModel, productViewModel, userProductDAO);
            return new ProductView(productController, productViewModel, loggedInViewModel, true, searchViewModel, addController);
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Could not open product data file.");
        }

        return null;
    }

    public static ProductView createForSeller(ViewManagerModel viewManagerModel, ProductViewModel productViewModel, ProductDAO userProductDAO, LoggedInViewModel loggedInViewModel)
    {

        try
        {
            ProductController productController = createUserProductUseCase(viewManagerModel, productViewModel, userProductDAO);
            return new ProductView(productController, productViewModel, loggedInViewModel, false, null, null);
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Could not open product data file.");
        }

        return null;
    }

    private static ProductController createUserProductUseCase(ViewManagerModel viewManagerModel, ProductViewModel productViewModel, ProductDetailsDAI userProductDAO) throws IOException
    {
        ProductOutPutBoundary productOutPutBoundary = new ProductPresenter(viewManagerModel, productViewModel);

        ProductInputBoundary userProductInteractor = new ProductInteractor(userProductDAO, productOutPutBoundary);

        return new ProductController(userProductInteractor);
    }
}
