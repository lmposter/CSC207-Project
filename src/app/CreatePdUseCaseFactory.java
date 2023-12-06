package app;

import data_access.ProductDAO;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.Create_product.CreatePdController;
import interface_adapter.Create_product.CreatePdPresenter;
import interface_adapter.Create_product.CreatePdViewModel;
import interface_adapter.ViewManagerModel;
import use_case.create_product.CreatePdDAI;
import use_case.create_product.CreatePdInputBoundary;
import use_case.create_product.CreatePdInteractor;
import use_case.create_product.CreatePdOutPutBoundary;
import view.CreatePdView;

import javax.swing.*;
import java.io.IOException;

public class CreatePdUseCaseFactory
{
    private CreatePdUseCaseFactory(){}

    public static CreatePdView create(ViewManagerModel viewManagerModel, CreatePdViewModel createPdViewModel, ProductDAO userProductDAO, SellerViewModel sellerViewModel)
    {

        try
        {
            CreatePdController createPdController = createPdUseCase(viewManagerModel, createPdViewModel, userProductDAO);
            return new CreatePdView(createPdController, createPdViewModel, sellerViewModel);
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Could not open product data file.");
        }

        return null;
    }

    private static CreatePdController createPdUseCase(ViewManagerModel viewManagerModel, CreatePdViewModel createPdViewModel, CreatePdDAI userProductDAO) throws IOException
    {
        CreatePdOutPutBoundary createPdPresenter = new CreatePdPresenter(createPdViewModel, viewManagerModel);

        CreatePdInputBoundary createPdInteractor = new CreatePdInteractor(userProductDAO, createPdPresenter);

        return new CreatePdController(createPdInteractor);
    }
}
