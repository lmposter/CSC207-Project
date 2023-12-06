package src;

import org.junit.jupiter.api.Test;
import use_case.search.SearchInputData;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInputTest {

    @Test
    void testGetContent() {
        SearchInputData searchData = new SearchInputData("search term", "username");

        // Check if getContent returns the expected array
        assertArrayEquals(new String[]{"search", "term"}, searchData.getContent());
    }

    @Test
    void testGetUsername() {
        SearchInputData searchData = new SearchInputData("search term", "username");

        // Check if getUsername returns the expected username
        assertEquals("username", searchData.getUsername());
    }

    @Test
    void testGetContentWithMultipleWords() {
        SearchInputData searchData = new SearchInputData("multiple word search", "username");

        // Check if getContent returns the expected array for multiple words
        assertArrayEquals(new String[]{"multiple", "word", "search"}, searchData.getContent());
    }
}
