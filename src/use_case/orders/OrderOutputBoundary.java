package use_case.orders;

import use_case.login.LoginOutputData;

/**
 * The OrderOutputBoundary interface defines methods for presenting the output of the order use case.
 * It includes operations for preparing views in case of successful and failed tracking order.
 */
public interface OrderOutputBoundary
{


    /**
     * Prepare the view for a successful fetch attempt.
     *
     * @param orderInputData The output data containing user information.
     */
    void prepareSuccessView(OrderInputData orderInputData);

    /**
     * Prepare the view for a failed attempt.
     *
     * @param errorMessage The error message to be displayed.
     */
    void prepareFailView(String errorMessage);

    void switchPage();
}