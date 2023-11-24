package data_access;

import entity.*;
import interface_adapter.API.DatabaseAPI;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignUpUserDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserDataAccessObject implements SignUpUserDataAccessInterface, LoginUserDataAccessInterface {

    private final BuyerFactory buyerFactory;
    private final SellerFactory sellerFactory;

    // Constructor that takes the CSV file path and Buyer/Seller factories
    public UserDataAccessObject( BuyerFactory buyerFactory, SellerFactory sellerFactory) throws IOException {
        this.buyerFactory = buyerFactory;
        this.sellerFactory = sellerFactory;
    }

    // Save a user to the CSV file
    @Override
    public void save(LoginUser user) {
        DatabaseAPI.insertOne(user);
//        accounts.put(user.getName(), user);
//        this.save();
    }

    // Check if a user with the given email exists
    @Override
    public boolean existsByEmail(String email) {
        return false; // Placeholder implementation
    }

    // Get a user based on the identifier (username)
    @Override
    public LoginUser getUserByIdentifier(String identifier) {
        return null; // Placeholder implementation
    }

    // Delete a user based on the identifier (username)
    @Override
    public void deleteByIdentifier(String identifier) {
        // Placeholder implementation
    }

    // Update user information
    @Override
    public void update(LoginUser user) {
        // Placeholder implementation
    }

    // Get a list of all users
    @Override
    public List<LoginUser> getAllUsers() {
        return null; // Placeholder implementation
    }

    // Get a user based on the username
    @Override
    public LoginUser get(String username) {
//        return accounts.get(username);
        return null;
    }

    // Check if an account is locked
    @Override
    public boolean isAccountLocked(String username) {
        return false; // Placeholder implementation
    }

    // Increment the number of failed login attempts
    @Override
    public void incrementFailedLoginAttempts(String username) {
        // Placeholder implementation
    }

    // Check if the maximum number of failed login attempts is reached
    @Override
    public boolean isMaxFailedAttemptsReached(String username) {
        return false; // Placeholder implementation
    }

    // Lock a user account
    @Override
    public void lockAccount(String username) {
        // Placeholder implementation
    }

    // Reset the number of failed login attempts for a user
    @Override
    public void resetFailedLoginAttempts(String username) {
        // Placeholder implementation
    }

    // Deactivate a user account and remove from CSV
    @Override
    public void deactivateAccount(String username) {
//        LoginUser user = accounts.remove(username); // Remove the user from the map
//
//        if (user != null) {
//            // Save the changes to the CSV file (without the deactivated user)
//            save();
//        }
    }

    // Save user data to the CSV file
    /**
     * Check if a user with the given username exists.
     *
     * @param identifier the username to check.
     * @return whether a user exists with the specified username
     */
    @Override
    public boolean existsByName(String identifier) {
        return DatabaseAPI.findOneByName(identifier);
    }
}