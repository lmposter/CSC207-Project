package entity;

public class GuestFactory implements UserFactory {
    /**
     * Requires: password is valid.
     * @param id
     * @param name
     * @return
     */

    @Override
    public Guest create(String id, String name) {
        return new Guest(id, name);
    }
}