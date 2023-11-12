package interface_adapter.signup;

import use_case.signup.SignUpInputBoundary;
import use_case.signup.SignUpInputData;

public class SignupController {

    final SignUpInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignUpInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2, String type) {
        SignUpInputData signupInputData = new SignUpInputData(
                username, password1, password2, type);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
