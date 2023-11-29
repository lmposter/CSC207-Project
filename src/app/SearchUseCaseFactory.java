package app;

import data_access.ProductDAO;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import use_case.search.SearchDAI;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutPutBoundary;
import view.SearchView;

import javax.swing.*;
import java.io.IOException;

public class SearchUseCaseFactory {
    private SearchUseCaseFactory(){}

    public static SearchView create(
            ViewManagerModel viewManagerModel, SearchViewModel searchViewModel,
            ProductDAO userProductDAO) {

        try{
            SearchController searchController = createUserSearchUseCase(viewManagerModel, searchViewModel, userProductDAO);
            return new SearchView(searchController, searchViewModel);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Could not open product data file.");
        }

        return null;
    }

    private static SearchController createUserSearchUseCase(ViewManagerModel viewManagerModel,
                                                            SearchViewModel searchViewModel, SearchDAI userProductDAO)
    throws IOException{
        SearchOutPutBoundary searchOutPutBoundary = new SearchPresenter(searchViewModel, viewManagerModel);

        SearchInputBoundary userSearchInteractor = new SearchInteractor(userProductDAO, searchOutPutBoundary);

        return new SearchController(userSearchInteractor);
    }
}
