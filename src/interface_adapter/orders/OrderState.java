package interface_adapter.orders;

public class OrderState
{
    private String username = "";
    private String usernameError = null;

    public OrderState(OrderState copy)
    {
        username = copy.username;
        usernameError = copy.usernameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OrderState(){}

    public String getUsername()
    {
        return username;
    }

    public String getUsernameError()
    {
        return usernameError;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setUsernameError(String usernameError)
    {
        this.usernameError = usernameError;
    }

}
