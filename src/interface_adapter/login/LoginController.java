package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInteractor;

public class LoginController
{
    private LoginInteractor loginInteractor;

    public LoginController(LoginInteractor loginInteractor)
    {
        this.loginInteractor = loginInteractor;
    }

    public void execute(String name, String password)
    {
        loginInteractor.execute(new LoginInputData(name, password));
    }
}
