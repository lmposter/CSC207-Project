package use_case.CheckOut;

public class CheckOutInteractor implements CheckOutInputBoundary
{
    private final CheckOutOutputBoundary checkOutPresenter;
    private final CheckOutDataAccessInterface dataAccessObject;

    public CheckOutInteractor(CheckOutOutputBoundary checkOutPresenter, CheckOutDataAccessInterface dataAccessObject)
    {
        this.checkOutPresenter = checkOutPresenter;
        this.dataAccessObject = dataAccessObject;
    }

    @Override
    public void execute()
    {

    }
}
