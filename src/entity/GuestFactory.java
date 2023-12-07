package entity;

public class GuestFactory implements LoginUserFactory {
    /**
     * Requires: None
     */

    public Guest create(String name, String password) {
        return new Guest();
    }
}