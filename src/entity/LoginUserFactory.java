package entity;

public interface LoginUserFactory{
    /** Pre-condition: valid id, name and password. */
    LoginUser create(String name, String pwd);
}