package src;

import data_access.ProductDAO;
import entity.*;
import interface_adapter.search.SearchController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.search.*;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchTest {
//    @Mock
//    private SearchDAI mockUserDataAccessObject;
//    @Mock
//    private SearchOutPutBoundary mockSearchPresenter;
//    private SearchInteractor searchInteractor;
//
//    // Setup for Mockito annotations and initializing the test object
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        searchInteractor = new SearchInteractor(
//                mockUserDataAccessObject,
//                mockSearchPresenter);
//    }
//
//    // Test case for guest user signup
//    @Test
//    void testExecute() {
//        // Arrange
//        SearchInputData inputData = new SearchInputData("apple");
//
//        // Act
//        searchInteractor.execute(inputData);
//
//        // Assert
//        verify(mockSearchPresenter).prepareSuccessView(any(String.class), any(SearchOutPutData.class));
//    }
//
//    // Test case to verify the functionality of switching pages
//    @Test
//    void testSwitchPage() {
//        // Act
//        searchInteractor.switchPage();
//
//        // Assert
//        verify(mockSearchPresenter).switchPage();
//    }

}
