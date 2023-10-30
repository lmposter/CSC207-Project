package entity;

public class SellerFactory implements UserFactory, LoginUserFactory {
    /**
     * Requires: password is valid.
     * @param id
     * @param name
     * @param password
     * @return
     */

    @Override
    public Seller create(String id, String name, String password) {
        return new Seller(id, name, password);
    }
}