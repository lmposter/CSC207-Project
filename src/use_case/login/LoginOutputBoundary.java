package use_case.login;

public interface LoginOutputBoundary
{
    public void prepareSuccessView();

    public void prepareFailView(String msg);
}
