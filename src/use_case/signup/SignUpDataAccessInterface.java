package use_case.signup;

import entity.User;

public interface SignUpDataAccessInterface {
    boolean existByName(String Name);

    boolean save(User user);
}
