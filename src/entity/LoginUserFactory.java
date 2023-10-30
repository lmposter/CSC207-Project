package entity;

public interface LoginUserFactory extends UserFactory {
    /** Pre-condition: valid id, name and password. */
    LoginUser create(String id, String name, String pwd);
}