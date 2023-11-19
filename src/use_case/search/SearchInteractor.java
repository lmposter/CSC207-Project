package use_case.search;

import entity.Product;
import interface_adapter.API.WalmartAPI;

import java.io.IOException;
import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

    private final SearchDAI searchDAO;
    private final SearchOutPutBoundary searchPresenter;
    private final WalmartAPI walmartAPI;

    public SearchInteractor(SearchDAI searchDAO, SearchOutPutBoundary searchPresenter) {
        this.searchDAO = searchDAO;
        this.searchPresenter = searchPresenter;
        this.walmartAPI = new WalmartAPI();
    }


    @Override
    public void execute(SearchInputData searchInputData) {
        int sumNum = 0;
        ArrayList<Product> walmartItems = walmartAPI.searchWalmart(searchInputData.getContent());
        for (String i : searchInputData.getContent()) {
            sumNum += searchDAO.numItemsFound(i);
            sumNum += walmartItems.size();}
        if (sumNum == 0){
            searchPresenter.prepareNoMatchProductView("Sorry, there is no matching products. Try using other keywords.");
        } else {
            try {
                ArrayList<Product> productsList = new ArrayList<>();
                for (String i : searchInputData.getContent()) {
                    productsList.addAll(searchDAO.getItems(i));
                }
                productsList.addAll(walmartItems);
                SearchOutPutData searchOutPutData = new SearchOutPutData(productsList, false);
                this.searchPresenter.prepareSuccessView("{num} items found:", searchOutPutData);
            }catch (RuntimeException e){
                searchPresenter.prepareFailSearchView("OOPS! Error searching");

            }
        }

    }
}
