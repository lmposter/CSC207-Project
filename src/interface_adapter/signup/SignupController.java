package interface_adapter.signup;

import use_case.signup.SignUpUserInputBoundary;
import use_case.signup.SignUpUserInputData;

public class SignupController {

    final SignUpUserInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignUpUserInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2, String type) {
        SignUpUserInputData signupUserInputData = new SignUpUserInputData(
                username, password1, password2, type);

        userSignupUseCaseInteractor.execute(signupUserInputData);
    }
}
