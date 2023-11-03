package entity;

public class SellerFactory implements LoginUserFactory {
    /**
     * Requires: password is valid.
     *
     * @param name
     * @param password
     * @return
     */

    @Override
    public LoginUser create(String name, String password) {
        return new Seller(name, password);
    }
}