package use_case.signup;

public class SignUpInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;

    final private String signType;

    public SignUpInputData(String username, String password, String repeatPassword, String signType) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.signType = signType;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getSignType() {
        return signType;
    }

}
