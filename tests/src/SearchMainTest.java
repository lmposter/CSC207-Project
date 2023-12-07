package src;

import entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.search.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchMainTest {

    private SearchDAI mockSearchDAO;
    private SearchOutPutBoundary mockSearchPresenter;
    private SearchInteractor searchInteractor;

    @BeforeEach
    void setUp() {
        mockSearchDAO = mock(SearchDAI.class);
        mockSearchPresenter = mock(SearchOutPutBoundary.class);
        searchInteractor = new SearchInteractor(mockSearchDAO, mockSearchPresenter);
    }

    @Test
    void testExecuteWithNoMatch() {
        // Arrange
        SearchInputData input = new SearchInputData("asdasjlknvcxnvcxn@!@#@!", "username");
        when(mockSearchDAO.numItemsFound("keyword")).thenReturn(0);

        // Act
        searchInteractor.execute(input);

        // Assert
        verify(mockSearchPresenter, times(1)).prepareNoMatchProductView(anyString());
        verify(mockSearchDAO, never()).getItems(anyString());
        verify(mockSearchDAO, never()).save(any(Product.class), anyString());
    }

    @Test
    void testExecuteWithMatch() {
        // Arrange
        SearchInputData input = new SearchInputData("keyword", "username");
        when(mockSearchDAO.numItemsFound("keyword")).thenReturn(1);

        // Act
        searchInteractor.execute(input);

        // Assert
        verify(mockSearchDAO, times(1)).getItems("keyword");
        verify(mockSearchDAO, times(1)).numItemsFound(eq("keyword"));
        verify(mockSearchPresenter, times(1)).prepareSuccessView(anyString(), any(SearchOutPutData.class));
        verify(mockSearchPresenter, never()).prepareFailSearchView(anyString());
    }

    @Test
    void testSwitchPage() {
        // Act
        searchInteractor.switchPage();

        // Assert
        verify(mockSearchPresenter, times(1)).switchPage();
    }
}
