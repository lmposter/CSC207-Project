package data_access;

import entity.*;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignUpUserDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserDataAccessObject implements SignUpUserDataAccessInterface, LoginUserDataAccessInterface {

    // File to store user data in CSV format
    private final File csvFile;

    // Headers for the CSV file
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    // Map to store user accounts
    private final Map<String, LoginUser> accounts = new HashMap<>();

    // Factories for creating Buyer and Seller objects
    private final BuyerFactory buyerFactory;
    private final SellerFactory sellerFactory;

    // Constructor that takes the CSV file path and Buyer/Seller factories
    public UserDataAccessObject(String csvPath, BuyerFactory buyerFactory, SellerFactory sellerFactory) throws IOException {
        this.buyerFactory = buyerFactory;
        this.sellerFactory = sellerFactory;

        // Initialize CSV file and headers
        csvFile = new File(csvPath);
        headers.put("id", 0);
        headers.put("username", 1);
        headers.put("password", 2);

        // If the CSV file is empty, create it
        if (csvFile.length() == 0) {
            save();
        } else {
            // Read data from existing CSV file
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // Ensure the CSV file has the expected header format
                assert header.equals("id,username,password");

                String row;
                while ((row = reader.readLine()) != null) {
                    // Split CSV row into columns
                    String[] col = row.split(",");
                    String id = String.valueOf(col[headers.get("id")]);
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);

                    // Create a user based on the ID (Buyer or Seller)
                    LoginUser user;
                    if (id.startsWith("B")) {
                        user = buyerFactory.create(username, password);
                    } else {
                        user = sellerFactory.create(username, password);
                    }
                    // Add the user to the accounts map
                    accounts.put(username, user);
                }
            }
        }
    }

    // Save a user to the CSV file
    @Override
    public void save(LoginUser user) {
        accounts.put(user.getName(), user);
        this.save();
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
        return accounts.get(username);
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
        LoginUser user = accounts.remove(username); // Remove the user from the map

        if (user != null) {
            // Save the changes to the CSV file (without the deactivated user)
            save();
        }
    }

    // Save user data to the CSV file
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            // Write each active user to a new line in the CSV file
            for (LoginUser user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getId(), user.getName(), user.getPassword());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            // Throw a runtime exception if there is an error saving the file
            throw new RuntimeException(e);
        }
    }

    /**
     * Check if a user with the given username exists.
     *
     * @param identifier the username to check.
     * @return whether a user exists with the specified username
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }
}