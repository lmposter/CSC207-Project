package use_case.orders;

import java.util.List;

/**
 * The OrderInputBoundary interface defines the input boundary for tracking order use case.
 * It specifies the methods required to handle inputs.
 */
public interface OrderInputBoundary {

    /**
     * Executes the login process based on the provided user input data.
     *
     */
    List<String[]> findProducts(String name);

    void switchPage();

}