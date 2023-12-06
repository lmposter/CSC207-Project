package use_case.productDetails;

import interface_adapter.API.DatabaseAPI;

public class ProductInteractor implements ProductInputBoundary {

    final ProductDetailsDAI productDetailsDAO;
    final ProductOutPutBoundary userPresenter;

    public ProductInteractor(ProductDetailsDAI productDetailsDAO, ProductOutPutBoundary userPresenter) {
        this.productDetailsDAO = productDetailsDAO;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(ProductInputData productInputData) {
        if (!productDetailsDAO.productExists(productInputData.getID())){
            userPresenter.prepareFailView("Product does not exist.");
        } else {
            ProductOutputData productOutputData = new ProductOutputData(productDetailsDAO.getPd(productInputData.getID()));
            userPresenter.prepareSuccessView(productOutputData);
        }
    }

    public void buyProduct(String name, String ID, String title, Double price){
        DatabaseAPI.buyProduct("name", name, ID, title, price);
//        productDetailsDAO.buyProduct(name, ID, title, price);
        userPresenter.prepareSuccessView(null);
    }
}
