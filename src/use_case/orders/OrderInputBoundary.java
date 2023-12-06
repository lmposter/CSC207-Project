package use_case.orders;

import java.util.List;

/**
 * The LoginInputBoundary interface defines the input boundary for the login use case.
 * It specifies the methods required to handle user login inputs.
 */
public interface OrderInputBoundary {

    /**
     * Executes the login process based on the provided login input data.
     *
     */
    List<String[]> execute(String name);

    void switchPage();

}