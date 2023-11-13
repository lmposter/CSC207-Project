package data_access;
import entity.User;
import use_case.signup.SignUpUserDataAccessInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDataAcessObject implements SignUpUserDataAccessInterface {
    private final Map<String, User> users = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param user the data to save
     */
    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public User getUserByIdentifier(String identifier) {
        return null;
    }

    @Override
    public void deleteByIdentifier(String identifier) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
