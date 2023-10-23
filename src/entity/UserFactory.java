package entity;

public interface UserFactory {
    /** Pre-condition: valid password. */
    User create(String name, String pwd);
}
