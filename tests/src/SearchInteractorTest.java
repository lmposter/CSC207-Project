package src;

import entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.search.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchInteractorTest {

    private SearchInteractor searchInteractor;
    private SearchDAI searchDAO;
    private SearchOutPutBoundary searchPresenter;

    @BeforeEach
    void setUp() {
        // Initialize mock objects
        searchDAO = mock(SearchDAI.class);
        searchPresenter = mock(SearchOutPutBoundary.class);

        // Create SearchInteractor instance
        searchInteractor = new SearchInteractor(searchDAO, searchPresenter);
    }

    @Test
    void testExecuteWithNoMatch() {
        // Prepare test data
        SearchInputData searchData = new SearchInputData("asdasjlknvcxnvcxn@!@#@!", "username");

        // Set up mock behavior
        when(searchDAO.numItemsFound(anyString())).thenReturn(0);

        // Execute the use case
        searchInteractor.execute(searchData);

        // Verify that the appropriate method on the presenter was called
        verify(searchPresenter).prepareNoMatchProductView("Sorry, there is no matching products. Try using other keywords.");
    }

//    @Test
//    void testExecuteWithMatches() {
//        // Prepare test data
//        SearchInputData searchData = new SearchInputData("existent", "username");
//        ArrayList<Product> mockProducts = new ArrayList<>();
//        mockProducts.add(new Product("Computer", "URL1", 199, 20000));
//        mockProducts.add(new Product("Keyboards", "URL2", 300, 1234));
//
//        // Set up mock behavior
//        when(searchDAO.numItemsFound(anyString())).thenReturn(2);
//        when(searchDAO.getItems(anyString())).thenReturn(mockProducts);
//
//        // Execute the use case
//        searchInteractor.execute(searchData);
//
//        // Verify that the appropriate method on the presenter was called with the correct arguments
//        verify(searchPresenter).prepareSuccessView(eq("2 items found:"), any(SearchOutPutData.class));
//    }
//
//    @Test
//    void testExecuteWithException() {
//        // Prepare test data
//        SearchInputData searchData = new SearchInputData("existent", "username");
//
//        // Set up mock behavior to simulate an exception
//        when(searchDAO.numItemsFound(anyString())).thenThrow(new RuntimeException("Simulated exception"));
//
//        // Execute the use case
//        searchInteractor.execute(searchData);
//
//        // Verify that the appropriate method on the presenter was called with the correct error message
//        verify(searchPresenter).prepareFailSearchView("OOPS! Error searching");
//    }
}
