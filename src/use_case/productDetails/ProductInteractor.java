package use_case.productDetails;

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
}
