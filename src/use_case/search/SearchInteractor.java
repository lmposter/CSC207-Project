package use_case.search;

import entity.Product;

import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

    private final SearchDAI searchDAO;
    private final SearchOutPutBoundary searchPresenter;

    public SearchInteractor(SearchDAI searchDAO, SearchOutPutBoundary searchPresenter) {
        this.searchDAO = searchDAO;
        this.searchPresenter = searchPresenter;
    }


    @Override
    public void execute(SearchInputData searchInputData) {
        if (searchDAO.numItemsFound(searchInputData.getContent()) == 0){
            searchPresenter.prepareNoMatchProductView("Sorry, there is no matching products. Try using other keywords.");
        } else {
            int num = searchDAO.numItemsFound(searchInputData.getContent());
            ArrayList<Product> productsList = searchDAO.getItems(searchInputData.getContent());
            SearchOutPutData searchOutPutData = new SearchOutPutData(productsList, false);
            this.searchPresenter.prepareSuccessView("{num} items found:", searchOutPutData);
        }

    }
}
