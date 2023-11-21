package interface_adapter.product;

import entity.Review;
import interface_adapter.ViewManagerModel;

import use_case.productDetails.ProductOutPutBoundary;
import use_case.productDetails.ProductOutputData;


public class ProductPresenter implements ProductOutPutBoundary{
    private final ProductViewModel productViewModel;
    private final ViewManagerModel viewManagerModel;

    public ProductPresenter(ViewManagerModel viewManagerModel,
                           ProductViewModel productViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.productViewModel = productViewModel;
    }

    @Override
    public void prepareSuccessView(ProductOutputData response) {

        ProductState productState = productViewModel.getState();
        productState.setID(response.getPdID());
        productState.setTitle(response.getTitle());
        productState.setPrice(response.getPrice());
        productState.setInventory(response.getInventory());
        productState.setReviews(response.getReviews());
        this.productViewModel.setState(productState);
        productViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(productViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ProductState productState = productViewModel.getState();
        productState.setIDError(error);
        productViewModel.firePropertyChanged();
    }
}
