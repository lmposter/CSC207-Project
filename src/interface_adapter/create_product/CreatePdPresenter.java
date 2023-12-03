package interface_adapter.create_product;

import interface_adapter.ViewManagerModel;
import use_case.create_product.CreatePdOutPutBoundary;

public class CreatePdPresenter implements CreatePdOutPutBoundary {
    private final CreatePdViewModel createPdViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreatePdPresenter(CreatePdViewModel createPdViewModel, ViewManagerModel viewManagerModel){
        this.createPdViewModel = createPdViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareFailCreateView(String error) {
        CreatePdState createPdState = createPdViewModel.getState();
        createPdState.setMessage(error);
        createPdViewModel.setState(createPdState);
        createPdViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessCreateView(String s) {
        CreatePdState createPdState = createPdViewModel.getState();
        createPdState.setMessage(s);
        createPdViewModel.setState(createPdState);
        createPdViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(createPdViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
