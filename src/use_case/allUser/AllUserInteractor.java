package use_case.allUser;

public abstract class AllUserInteractor implements AllUserInputBoundary{
    public abstract void switchPageSearch(String username);
    public abstract void switchPageLogOut();
}
