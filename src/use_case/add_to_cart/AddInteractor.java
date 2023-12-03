package use_case.add_to_cart;

public class AddInteractor implements AddInputBoundary
{
    private final AddDataAccessInterface userDataAccess;
    private final AddOutputBoundary addPresenter;

    public AddInteractor(AddDataAccessInterface userDataAccess, AddOutputBoundary addPresenter)
    {
        this.userDataAccess = userDataAccess;
        this.addPresenter = addPresenter;
    }


    @Override
    public void execute(AddInputData input)
    {

    }
}
