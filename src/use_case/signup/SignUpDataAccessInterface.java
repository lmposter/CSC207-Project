package use_case.signup;

public interface SignUpDataAccessInterface {
    boolean existById(String id);

    boolean save();
}
