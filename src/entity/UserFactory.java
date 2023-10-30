package entity;

public interface UserFactory {
    /** Pre-condition: valid id and name. */
    User create(String id, String name);
}