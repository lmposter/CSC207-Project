package entity;

public class GuestFactory implements UserFactory {
    /**
     * Requires: None
     */

    @Override
    public User create() {
        return new Guest();
    }
}