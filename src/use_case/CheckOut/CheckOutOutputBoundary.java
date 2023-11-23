package use_case.CheckOut;

public interface CheckOutOutputBoundary
{

    void prepareSuccessView(CheckOutOutputData checkOutOutputData);

    void soldOutView();
}
