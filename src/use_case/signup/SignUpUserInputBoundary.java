package use_case.signup;

/**
 * Input boundary for the user signup use case.
 */
public interface SignUpUserInputBoundary {

    void execute(SignUpUserInputData signUpUserInputData);
    void switchPage();
}