package interface_adapter.product;

import interface_adapter.ViewManagerModel;

import use_case.productDetails.ProductOutPutBoundary;
import use_case.productDetails.ProductOutputData;


public class ProductPresenter implements ProductOutPutBoundary{
    private final ProductViewModel productViewModel;
    private ViewManagerModel viewManagerModel;

    public ProductPresenter(ViewManagerModel viewManagerModel,
                           ProductViewModel productViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.productViewModel = productViewModel;
    }

    @Override
    public void prepareSuccessView(ProductOutputData response) {

        ProductState productState = productViewModel.getState();
        productState.setID(response.getPdID());
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
