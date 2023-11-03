package use_case.login;

import entity.LoginUser;

public interface LoginDataAccessInterface
{
    public boolean existByName(String userName);
    public LoginUser get(String userName);
}
