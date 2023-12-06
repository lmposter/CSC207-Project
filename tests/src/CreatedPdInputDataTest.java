package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.create_product.CreatePdInputData;

class CreatedPdInputDataTest {

    private CreatePdInputData pdInputData;

    @BeforeEach
    void setUp() {
        // Set up a new CreatePdInputData instance before each test
        pdInputData = new CreatePdInputData("Product Title", "50.00", "100", "https://example.com/image.jpg", "seller123");
    }

    @Test
    void testGetTitle() {
        assertEquals("Product Title", pdInputData.getTitle());
    }

    @Test
    void testGetPrice() {
        assertEquals("50.00", pdInputData.getPrice());
    }

    @Test
    void testGetInventory() {
        assertEquals("100", pdInputData.getInventory());
    }

    @Test
    void testGetImageUrl() {
        assertEquals("https://example.com/image.jpg", pdInputData.getImageUrl());
    }

    @Test
    void testGetUsername() {
        assertEquals("seller123", pdInputData.getUsername());
    }

    @Test
    void testTrimmedTitle() {
        CreatePdInputData trimmedTitleInputData = new CreatePdInputData("  Trimmed Title  ", "50.00", "100", "https://example.com/image.jpg", "seller123");
        assertEquals("Trimmed Title", trimmedTitleInputData.getTitle());
    }

    @Test
    void testTrimmedImageUrl() {
        CreatePdInputData trimmedImageUrlInputData = new CreatePdInputData("Product Title", "50.00", "100", "  https://example.com/image.jpg  ", "seller123");
        assertEquals("https://example.com/image.jpg", trimmedImageUrlInputData.getImageUrl());
    }
}
