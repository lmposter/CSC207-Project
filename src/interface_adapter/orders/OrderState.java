package interface_adapter.orders;

public class OrderState
{
    private String username = "";
    private String usernameError = null;


    // Because of the previous copy constructor, the default constructor must be explicit.
    public OrderState(){}

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}
