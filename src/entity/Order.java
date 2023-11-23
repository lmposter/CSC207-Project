package entity;

public class Order
{
    private double price;
    private Product product;
    private int quantity;

    public Order(Product product, int num)
    {
        this.product = product;
        this.quantity = num;
        this.price = product.getPrice() * num;
    }
}
