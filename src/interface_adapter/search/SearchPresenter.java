package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutPutBoundary;
import use_case.search.SearchOutPutData;

public class SearchPresenter implements SearchOutPutBoundary {

    private final SearchViewModel searchViewModel;

    private ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareNoMatchProductView(String message) {
    }

    @Override
    public void prepareSuccessView(SearchOutPutData product) {
    }
}
