package data_access;

import entity.BuyerFactory;
import entity.LoginUser;
import entity.Product;
import entity.SellerFactory;
import interface_adapter.API.DatabaseAPI;
import use_case.allUser.buyerPage.BuyerDataAccessInterface;
import use_case.allUser.guestPage.GuestUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.allUser.sellerPage.SellerDataAccessInterface;
import use_case.orders.OrderDAO;
import use_case.orders.OrderInputData;
import use_case.signup.SignUpUserDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDataAccessObject implements SignUpUserDataAccessInterface, LoginUserDataAccessInterface, GuestUserDataAccessInterface, BuyerDataAccessInterface, SellerDataAccessInterface, OrderDAO
{

    private final BuyerFactory buyerFactory;
    private final SellerFactory sellerFactory;

    // Constructor that takes the CSV file path and Buyer/Seller factories
    public UserDataAccessObject(BuyerFactory buyerFactory, SellerFactory sellerFactory) throws IOException
    {
        this.buyerFactory = buyerFactory;
        this.sellerFactory = sellerFactory;
    }

    // Save a user to the CSV file
    @Override
    public void save(LoginUser user)
    {
        DatabaseAPI.insertOne(user);
    }

    // Check if a user with the given email exists
    @Override
    public boolean existsByEmail(String email)
    {
        return DatabaseAPI.findOne("email", email);
    }

    @Override
    public boolean existsByName(String identifier)
    {
        return DatabaseAPI.findOne("name", identifier);
    }

    // Get a user based on the identifier (username)
    @Override
    public LoginUser getUserByIdentifier(String identifier)
    {
        return DatabaseAPI.get("id", identifier, buyerFactory, sellerFactory); // Placeholder implementation
    }

    // Get a user based on the username
    @Override
    public LoginUser get(String username)
    {
        //        return accounts.get(username);
        return DatabaseAPI.get("name", username, buyerFactory, sellerFactory);
    }


    @Override
    public void changePassword(String username, String password) {

    }

    //    @Override
    //    public void changePassword(String username, String password) {
    //        return;
    //    }

//    @Override
//    public void clearCart(String username)
//    {
//        DatabaseAPI.clearCart("name", username);
//    }

    // Delete a user based on the identifier (username)
    @Override
    public void deleteByIdentifier(String identifier)
    {
        DatabaseAPI.delete("id", identifier);
    }


    // Check if an account is locked
    @Override
    public boolean isAccountLocked(String username)
    {
        ; // Placeholder implementation
        int attempts = DatabaseAPI.getAttempts("name", username);
        return attempts >= 3;
    }

    // Increment the number of failed login attempts
    @Override
    public void incrementFailedLoginAttempts(String username)
    {
        DatabaseAPI.updateAttempts("name", username);
    }

    // Check if the maximum number of failed login attempts is reached
    @Override
    public boolean isMaxFailedAttemptsReached(String username)
    {
        int attempts = DatabaseAPI.getAttempts("name", username);
        return attempts >= 3; // Placeholder implementation
    }

    // Lock a user account
    @Override
    public void lockAccount(String username)
    {
        return;
    }

    // Reset the number of failed login attempts for a user
    @Override
    public void resetFailedLoginAttempts(String username)
    {
        DatabaseAPI.resetAttempts("name", username);
    }

    // Deactivate a user account and remove from CSV
    @Override
    public void deactivateAccount(String username)
    {
        DatabaseAPI.delete("name", username);
    }

    @Override
    public List<String[]> getProducts(String username) {
        return DatabaseAPI.findProducts(username);
    }

    @Override
    public void execute(OrderInputData orderInputData) {
        // place holder
    }


    // Save user data to the CSV file
    /**
     * Check if a user with the given username exists.
     *
     * @param identifier the username to check.
     * @return whether a user exists with the specified username
     */
}