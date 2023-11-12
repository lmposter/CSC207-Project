package use_case.signup;

public class SignUpOutputData {

    private final String username;
    private boolean useCaseFailed;

    public SignUpOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }
}
