package src;

import entity.Review;
import interface_adapter.product.ProductState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class ProductStateTest {

    private ProductState productState;

    @BeforeEach
    void setUp() {
        // Initialize a sample ProductState object for testing
        String id = "123";
        String url = "sample-url";
        String title = "Sample Product";
        double price = 19.99;
        int inventory = 100;
        ArrayList<Review> reviews = new ArrayList<>();
        productState = new ProductState(id, url, title, price, inventory, reviews);
    }

    @Test
    void testGetID() {
        assertEquals("123", productState.getID());
    }

    @Test
    void testSetID() {
        productState.setID("456");
        assertEquals("456", productState.getID());
    }

    @Test
    void testSetIDError() {
        productState.setIDError("ID error message");
        assertEquals("ID error message", productState.getPdIDError());
    }

    @Test
    void testGetTitle() {
        assertEquals("Sample Product", productState.getTitle());
    }

    @Test
    void testSetTitle() {
        productState.setTitle("New Product");
        assertEquals("New Product", productState.getTitle());
    }

    @Test
    void testGetURL() {
        assertEquals("sample-url", productState.getURL());
    }

    @Test
    void testSetURL() {
        productState.setURL("new-url");
        assertEquals("new-url", productState.getURL());
    }

    @Test
    void testGetPrice() {
        assertEquals(19.99, productState.getPrice(), 0.01);
    }

    @Test
    void testSetPrice() {
        productState.setPrice(29.99);
        assertEquals(29.99, productState.getPrice(), 0.01);
    }

    @Test
    void testGetInventory() {
        assertEquals(100, productState.getInventory());
    }

    @Test
    void testSetInventory() {
        productState.setInventory(50);
        assertEquals(50, productState.getInventory());
    }

    @Test
    void testGetReviews() {
        assertNotNull(productState.getReviews());
        assertEquals(0, productState.getReviews().size());
    }

    @Test
    void testSetReviews() {
        ArrayList<Review> newReviews = new ArrayList<>();
        newReviews.add(new Review(5, "Good product"));
        productState.setReviews(newReviews);
        assertNotNull(productState.getReviews());
        assertEquals(1, productState.getReviews().size());
    }

    @Test
    void testGetProduct() {
        assertNotNull(productState.getProduct());
        assertEquals("Sample Product", productState.getProduct().getTitle());
        assertEquals("sample-url", productState.getProduct().getPhotoURL());
        assertEquals(19.99, productState.getProduct().getPrice(), 0.01);
        assertEquals(100, productState.getProduct().getInventory());
    }

    @Test
    void testGetID1() {
        productState.setID("123");
        assertEquals("123", productState.getID1());
    }

    @Test
    void testGetID2() {
        productState.setID("456");
        assertEquals("456", productState.getID2());
    }

    @Test
    void testGetID3() {
        productState.setID("789");
        assertEquals("789", productState.getID3());
    }

    @Test
    void testGetID4() {
        productState.setID("101112");
        assertEquals("101112", productState.getID4());
    }

    @Test
    void testGetID5() {
        productState.setID("131415");
        assertEquals("131415", productState.getID5());
    }

    @Test
    void testGetID6() {
        productState.setID("161718");
        assertEquals("161718", productState.getID6());
    }

    @Test
    void testGetID7() {
        productState.setID("192021");
        assertEquals("192021", productState.getID7());
    }

    @Test
    void testGetID8() {
        productState.setID("222324");
        assertEquals("222324", productState.getID8());
    }

    @Test
    void testGetID9() {
        productState.setID("252627");
        assertEquals("252627", productState.getID9());
    }

    @Test
    void testGetID10() {
        productState.setID("282930");
        assertEquals("282930", productState.getID10());
    }

    @Test
    void testGetID11() {
        productState.setID("313233");
        assertEquals("313233", productState.getID11());
    }

    @Test
    void testGetID12() {
        productState.setID("343536");
        assertEquals("343536", productState.getID12());
    }

    @Test
    void testGetID13() {
        productState.setID("373839");
        assertEquals("373839", productState.getID13());
    }

    @Test
    void testGetID14() {
        productState.setID("404142");
        assertEquals("404142", productState.getID14());
    }

    @Test
    void testGetID15() {
        productState.setID("434445");
        assertEquals("434445", productState.getID15());
    }

    @Test
    void testGetID16() {
        productState.setID("464748");
        assertEquals("464748", productState.getID16());
    }

    @Test
    void testGetID17() {
        productState.setID("495051");
        assertEquals("495051", productState.getID17());
    }

    @Test
    void testGetID18() {
        productState.setID("525354");
        assertEquals("525354", productState.getID18());
    }

    @Test
    void testGetID19() {
        productState.setID("555657");
        assertEquals("555657", productState.getID19());
    }

    @Test
    void testGetID20() {
        productState.setID("585960");
        assertEquals("585960", productState.getID20());
    }

    @Test
    void testGetID21() {
        productState.setID("616263");
        assertEquals("616263", productState.getID21());
    }

    @Test
    void testGetID22() {
        productState.setID("646566");
        assertEquals("646566", productState.getID22());
    }

    @Test
    void testGetID23() {
        productState.setID("676869");
        assertEquals("676869", productState.getID23());
    }

    @Test
    void testGetID24() {
        productState.setID("707172");
        assertEquals("707172", productState.getID24());
    }

    @Test
    void testGetID25() {
        productState.setID("737475");
        assertEquals("737475", productState.getID25());
    }

    @Test
    void testGetID26() {
        productState.setID("767778");
        assertEquals("767778", productState.getID26());
    }

    @Test
    void testGetID27() {
        productState.setID("798081");
        assertEquals("798081", productState.getID27());
    }

    @Test
    void testGetID28() {
        productState.setID("828384");
        assertEquals("828384", productState.getID28());
    }

    @Test
    void testGetID29() {
        productState.setID("858687");
        assertEquals("858687", productState.getID29());
    }

    @Test
    void testGetID30() {
        productState.setID("888990");
        assertEquals("888990", productState.getID30());
    }

    @Test
    void testGetID31() {
        productState.setID("919293");
        assertEquals("919293", productState.getID31());
    }

    @Test
    void testGetID32() {
        productState.setID("949596");
        assertEquals("949596", productState.getID32());
    }

    @Test
    void testGetID33() {
        productState.setID("979899");
        assertEquals("979899", productState.getID33());
    }

    @Test
    void testGetID34() {
        productState.setID("100101102");
        assertEquals("100101102", productState.getID34());
    }

    @Test
    void testGetID35() {
        productState.setID("103104105");
        assertEquals("103104105", productState.getID35());
    }

    @Test
    void testGetID36() {
        productState.setID("106107108");
        assertEquals("106107108", productState.getID36());
    }

    @Test
    void testGetID37() {
        productState.setID("109110111");
        assertEquals("109110111", productState.getID37());
    }

    @Test
    void testGetID38() {
        productState.setID("112113114");
        assertEquals("112113114", productState.getID38());
    }

    @Test
    void testGetID39() {
        productState.setID("115116117");
        assertEquals("115116117", productState.getID39());
    }

    @Test
    void testGetID40() {
        productState.setID("118119120");
        assertEquals("118119120", productState.getID40());
    }

    @Test
    void testGetID41() {
        productState.setID("121122123");
        assertEquals("121122123", productState.getID41());
    }

    @Test
    void testGetID42() {
        productState.setID("124125126");
        assertEquals("124125126", productState.getID42());
    }

    @Test
    void testGetID43() {
        productState.setID("127128129");
        assertEquals("127128129", productState.getID43());
    }

    @Test
    void testGetID44() {
        productState.setID("130131132");
        assertEquals("130131132", productState.getID44());
    }

    @Test
    void testGetID45() {
        productState.setID("133134135");
        assertEquals("133134135", productState.getID45());
    }

    @Test
    void testGetID46() {
        productState.setID("136137138");
        assertEquals("136137138", productState.getID46());
    }

    @Test
    void testGetID47() {
        productState.setID("139140141");
        assertEquals("139140141", productState.getID47());
    }

    @Test
    void testGetID48() {
        productState.setID("142143144");
        assertEquals("142143144", productState.getID48());
    }

    @Test
    void testGetID49() {
        productState.setID("145146147");
        assertEquals("145146147", productState.getID49());
    }

    @Test
    void testGetID50() {
        productState.setID("148149150");
        assertEquals("148149150", productState.getID50());
    }

    // ... Previous test methods ...

    @Test
    void testGetID51() {
        productState.setID("151152153");
        assertEquals("151152153", productState.getID51());
    }

    @Test
    void testGetID52() {
        productState.setID("154155156");
        assertEquals("154155156", productState.getID52());
    }

    @Test
    void testGetID53() {
        productState.setID("157158159");
        assertEquals("157158159", productState.getID53());
    }

    @Test
    void testGetID54() {
        productState.setID("160161162");
        assertEquals("160161162", productState.getID54());
    }

    @Test
    void testGetID55() {
        productState.setID("163164165");
        assertEquals("163164165", productState.getID55());
    }

    @Test
    void testGetID56() {
        productState.setID("166167168");
        assertEquals("166167168", productState.getID56());
    }

    @Test
    void testGetID57() {
        productState.setID("169170171");
        assertEquals("169170171", productState.getID57());
    }

    @Test
    void testGetID58() {
        productState.setID("172173174");
        assertEquals("172173174", productState.getID58());
    }

    @Test
    void testGetID59() {
        productState.setID("175176177");
        assertEquals("175176177", productState.getID59());
    }

    @Test
    void testGetID60() {
        productState.setID("178179180");
        assertEquals("178179180", productState.getID60());
    }

    @Test
    void testGetID61() {
        productState.setID("181182183");
        assertEquals("181182183", productState.getID61());
    }

    @Test
    void testGetID62() {
        productState.setID("184185186");
        assertEquals("184185186", productState.getID62());
    }

    @Test
    void testGetID63() {
        productState.setID("187188189");
        assertEquals("187188189", productState.getID63());
    }

    @Test
    void testGetID64() {
        productState.setID("190191192");
        assertEquals("190191192", productState.getID64());
    }

    @Test
    void testGetID65() {
        productState.setID("193194195");
        assertEquals("193194195", productState.getID65());
    }

    @Test
    void testGetID66() {
        productState.setID("196197198");
        assertEquals("196197198", productState.getID66());
    }

    @Test
    void testGetID67() {
        productState.setID("199200201");
        assertEquals("199200201", productState.getID67());
    }

    @Test
    void testGetID68() {
        productState.setID("202203204");
        assertEquals("202203204", productState.getID68());
    }

    @Test
    void testGetID69() {
        productState.setID("205206207");
        assertEquals("205206207", productState.getID69());
    }

    @Test
    void testGetID70() {
        productState.setID("208209210");
        assertEquals("208209210", productState.getID70());
    }

    @Test
    void testGetID71() {
        productState.setID("211212213");
        assertEquals("211212213", productState.getID71());
    }

    @Test
    void testGetID72() {
        productState.setID("214215216");
        assertEquals("214215216", productState.getID72());
    }

    @Test
    void testGetID73() {
        productState.setID("217218219");
        assertEquals("217218219", productState.getID73());
    }

    @Test
    void testGetID74() {
        productState.setID("220221222");
        assertEquals("220221222", productState.getID74());
    }

    @Test
    void testGetID75() {
        productState.setID("223224225");
        assertEquals("223224225", productState.getID75());
    }

    @Test
    void testGetID76() {
        productState.setID("226227228");
        assertEquals("226227228", productState.getID76());
    }

    @Test
    void testGetID77() {
        productState.setID("229230231");
        assertEquals("229230231", productState.getID77());
    }

    @Test
    void testGetID78() {
        productState.setID("232233234");
        assertEquals("232233234", productState.getID78());
    }

    @Test
    void testGetID79() {
        productState.setID("235236237");
        assertEquals("235236237", productState.getID79());
    }

    @Test
    void testGetID80() {
        productState.setID("238239240");
        assertEquals("238239240", productState.getID80());
    }

    @Test
    void testGetID81() {
        productState.setID("241242243");
        assertEquals("241242243", productState.getID81());
    }

    @Test
    void testGetID82() {
        productState.setID("244245246");
        assertEquals("244245246", productState.getID82());
    }

    @Test
    void testGetID83() {
        productState.setID("247248249");
        assertEquals("247248249", productState.getID83());
    }

    @Test
    void testGetID84() {
        productState.setID("250251252");
        assertEquals("250251252", productState.getID84());
    }

    @Test
    void testGetID85() {
        productState.setID("253254255");
        assertEquals("253254255", productState.getID85());
    }

    @Test
    void testGetID86() {
        productState.setID("256257258");
        assertEquals("256257258", productState.getID86());
    }

    @Test
    void testGetID87() {
        productState.setID("259260261");
        assertEquals("259260261", productState.getID87());
    }

    @Test
    void testGetID88() {
        productState.setID("262263264");
        assertEquals("262263264", productState.getID88());
    }

    @Test
    void testGetID89() {
        productState.setID("265266267");
        assertEquals("265266267", productState.getID89());
    }

    @Test
    void testGetID90() {
        productState.setID("268269270");
        assertEquals("268269270", productState.getID90());
    }

    @Test
    void testGetID91() {
        productState.setID("271272273");
        assertEquals("271272273", productState.getID91());
    }

    @Test
    void testGetID92() {
        productState.setID("274275276");
        assertEquals("274275276", productState.getID92());
    }

    @Test
    void testGetID93() {
        productState.setID("277278279");
        assertEquals("277278279", productState.getID93());
    }

    @Test
    void testGetID94() {
        productState.setID("280281282");
        assertEquals("280281282", productState.getID94());
    }

    @Test
    void testGetID95() {
        productState.setID("283284285");
        assertEquals("283284285", productState.getID95());
    }

    @Test
    void testGetID96() {
        productState.setID("286287288");
        assertEquals("286287288", productState.getID96());
    }

    @Test
    void testGetID97() {
        productState.setID("289290291");
        assertEquals("289290291", productState.getID97());
    }

    @Test
    void testGetID98() {
        productState.setID("292293294");
        assertEquals("292293294", productState.getID98());
    }

    @Test
    void testGetID99() {
        productState.setID("295296297");
        assertEquals("295296297", productState.getID99());
    }

    @Test
    void testGetID100() {
        productState.setID("298299300");
        assertEquals("298299300", productState.getID100());
    }
}

