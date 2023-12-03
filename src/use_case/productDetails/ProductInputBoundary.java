package use_case.productDetails;

public interface ProductInputBoundary {
    void execute(ProductInputData productInputData);

    void buyProduct(String username, String pId, String pTitle, Double pPrice);
}
