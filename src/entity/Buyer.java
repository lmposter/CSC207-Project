package entity;

public class Buyer implements User, LoginUser{
    private String name;
    private String id;
    private String password;
    private ShoppingCart cart;
    public Buyer(String name, String id, String password)
    {
        this.name = name;
        this.password = password;
        this.cart = new ShoppingCart();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
