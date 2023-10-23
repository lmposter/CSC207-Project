package use_case.signup;

public class SignUpInputData {
    private final String username;
    private final String password;
    private final String repeatPassword;
    private final boolean isBuyer;


    public SignUpInputData(String username, String password, String repeatPassword, Boolean isBuyer)
    {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.isBuyer = isBuyer;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getRepeatPassword()
    {
        return this.repeatPassword;
    }

    public boolean getIsBuyer()
    {
        return this.isBuyer;
    }
}
