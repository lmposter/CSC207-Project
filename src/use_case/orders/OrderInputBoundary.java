package use_case.orders;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface OrderInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     *
     * @param orderInputData The input data containing product to execute.
     */
    void execute(OrderInputData orderInputData);

    void switchPage();

}