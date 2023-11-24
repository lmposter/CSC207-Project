package use_case.signup;

import entity.User;

import java.util.List;

/**
 * Input boundary for the user signup use case.
 */
public interface SignUpUserInputBoundary {

    void execute(SignUpUserInputData signUpUserInputData);
    void switchPage();
    void guestView();
}