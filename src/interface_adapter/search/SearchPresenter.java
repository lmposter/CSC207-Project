package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutPutBoundary;
import use_case.search.SearchOutPutData;

import java.util.List;

public class SearchPresenter implements SearchOutPutBoundary
{

    private final SearchViewModel searchViewModel;

    private ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel, ViewManagerModel viewManagerModel)
    {
        this.searchViewModel = searchViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareNoMatchProductView(String message)
    {
        SearchState searchState = searchViewModel.getState();
        searchState.setMessage(message);
        this.searchViewModel.setState(searchState);
    }

    @Override
    public void prepareSuccessView(String s, SearchOutPutData product)
    {
        SearchState searchState = searchViewModel.getState();
        searchState.setMessage(s);
        searchState.setProducts(product.getProducts());

        this.searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailSearchView(String error)
    {
        SearchState searchState = searchViewModel.getState();
        searchState.setProductsError(error);
        searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
    }

    @Override
    public void switchPage()
    {
        List<String> user = List.of("guest logged in", "buyer logged in", "seller logged in");
        viewManagerModel.setActiveView(user.get(searchViewModel.getState().getUser()));
        viewManagerModel.firePropertyChanged();
    }
}
