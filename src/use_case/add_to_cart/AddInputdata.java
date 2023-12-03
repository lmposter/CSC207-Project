package use_case.add_to_cart;

public class AddInputData
{
    String username;
    String id;

    public AddInputData(String username, String id)
    {
        this.username = username;
        this.id = id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getProductId()
    {
        return this.id;
    }
}
