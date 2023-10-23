package use_case.signup;

import entity.User;
import entity.UserFactory;

public class SignUpInteractor implements SignUpInputBoundary{
    public final SignUpDataAccessInterface userDAO;
    public final SignUpOutputBoundary userPresenter;
    public final UserFactory userFactory;

    public SignUpInteractor(SignUpDataAccessInterface userDAO, SignUpOutputBoundary userPresenter, UserFactory userFactory) {
        this.userDAO = userDAO;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }


    @Override
    public void execute(SignUpInputData signUpInputData) {
        if (userDAO.existByName(signUpInputData.getUsername())){
            userPresenter.prepareFailView("Username already exist. Choose a different name!");
        }else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Your passwords look different.");
        }else {
            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
            userDAO.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getName());
            userPresenter.prepareSuccessView(signupOutputData);
        }


    }
}
