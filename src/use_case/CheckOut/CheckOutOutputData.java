package use_case.CheckOut;

public class CheckOutOutputData
{
    private double price;

    public CheckOutOutputData(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return this.price;
    }
}
