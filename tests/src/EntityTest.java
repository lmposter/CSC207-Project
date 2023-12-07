package src;

import entity.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntityTest
{

    /*
    Test Buyer's shopping cart works correctly (add/remove product; get the total price)
     */
    @Test
    void testBuyer()
    {
        Product product = new Product("product", "photo", 99.99, 99);
        Buyer buyer = new Buyer("name", "password", "123", new ShoppingCart());

        buyer.addProduct(product);

        assertEquals(buyer.getCart().getPrice(), 99.99);

        buyer.removeProduct(product);

        assertEquals(buyer.getCart().getPrice(), 0.0);

        assertEquals(new BuyerFactory().create("name", "password").getPassword(), "password");
    }

    /*
    Test Guest should NOT have name and password
     */
    @Test
    void testGuest()
    {
        Guest guest = new GuestFactory().create("", "");

        guest.setName("name");
        guest.setPassword("password");

        assertEquals(guest.getPassword(), "null");
    }

    /*
    Test assigning ID to product works properly
     */
    @Test
    void testProduct()
    {
        Product product = new Product("product", "photo", 99.99, 99);

        product.setID("123");

        assertEquals(product.getId(), product.getID());
    }

    /*
    Test review is correct and printing all the reviews
     */
    @Test
    void testReview()
    {
        Review review = new Review(5, "good");
        ArrayList<Review> reviews = new ArrayList<>();
        reviews.add(review);

        assertEquals(review.getStars(), 5);
        assertEquals(review.getComment(), "good");

        Review.printReviews(reviews);
    }

    /*
    Test Seller can manage its products
     */
    @Test
    void testSeller()
    {
        Seller seller = new Seller("name", "password", "123");
        Product product = new Product("product", "photo", 99.99, 99);

        seller.addProduct(product);
        seller.deletePd(product);

        assertTrue(seller.getProducts().isEmpty());
    }

    /*
    Test shopping cart works properly
     */
    @Test
    void testCart()
    {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("product", "photo", 99.99, 99);

        cart.addProduct(product);

        assertEquals(cart.getPrice(), 99.99);

        cart.removeProduct(product);

        assertTrue(cart.getCart().isEmpty());
    }

}
