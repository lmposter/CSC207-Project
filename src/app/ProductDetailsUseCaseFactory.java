package app;

import data_access.ProductDAO;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.ViewManagerModel;
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

    public static ProductView createForBuyer(ViewManagerModel viewManagerModel, ProductViewModel productViewModel, ProductDAO userProductDAO, SearchViewModel searchViewModel, BuyerViewModel buyerViewModel)
    {

        try
        {
            ProductController productController = createUserProductUseCase(viewManagerModel, productViewModel, userProductDAO);
            return new ProductView(productController, productViewModel, true, searchViewModel, buyerViewModel);
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Could not open product data file.");
        }

        return null;
    }

    public static ProductView createForSeller(ViewManagerModel viewManagerModel, ProductViewModel productViewModel, ProductDAO userProductDAO)
    {

        try
        {
            ProductController productController = createUserProductUseCase(viewManagerModel, productViewModel, userProductDAO);
            return new ProductView(productController, productViewModel, false, null, null);
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