package interface_adapter.search;

import use_case.search.SearchInputBoundary;
import use_case.search.SearchInputData;

public class SearchController {
    SearchInputBoundary searchUseCaseInteractor;
    public SearchController(SearchInputBoundary searchUseCaseInteractor){
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }

    public void execute(String searchContent){
        SearchInputData searchInputData = new SearchInputData(searchContent);
        searchUseCaseInteractor.execute(searchInputData);

    }

}
