package use_case.login;

public class LoginInteractor implements LoginInputBoundary
{
    private LoginDataAccessInterface userDataAccessObject;
    private LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginDataAccessInterface userDataAccessObject, LoginOutputBoundary loginPresenter)
    {
        this.loginPresenter = loginPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    public void execute(LoginInputData loginInputData)
    {
        if (!userDataAccessObject.existByName(loginInputData.getName()))
        {
            loginPresenter.prepareFailView("User does not exist");
        } else if (userDataAccessObject.get(loginInputData.getName()).getPassword().equals(loginInputData.getPassword()))
        {
            loginPresenter.prepareFailView("Incorrect Password");
        } else loginPresenter.prepareSuccessView();
    }
}
