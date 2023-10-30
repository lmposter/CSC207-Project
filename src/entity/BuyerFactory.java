package entity;

public class BuyerFactory implements UserFactory, LoginUserFactory {
    /**
     * Requires: password is valid.
     * @param id
     * @param name
     * @param password
     * @return
     */

    @Override
    public Buyer create(String id, String name, String password) {
        return new Buyer(id, name, password);
    }
}