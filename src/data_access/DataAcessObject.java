package data_access;

import entity.LoginUser;
import use_case.login.LoginDataAccessInterface;

public class DataAcessObject implements LoginDataAccessInterface
{
    @Override
    public boolean existByName(String userName)
    {
        return false;
    }

    @Override
    public LoginUser get(String userName)
    {
        return null;
    }
}