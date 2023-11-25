package entity;

public class GuestFactory implements LoginUserFactory {
    /**
     * Requires: None
     */
    @Override
    public LoginUser create(String name, String password) {
        return new Guest();
    }
}