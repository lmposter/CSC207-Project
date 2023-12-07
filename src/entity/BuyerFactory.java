package entity;

public class BuyerFactory implements LoginUserFactory {
    /**
     * Requires: password is valid.
     * @param name
     * @param password
     * @return
     */

    public LoginUser create(String name, String password) {
        return new Buyer(name, password);
    }
}