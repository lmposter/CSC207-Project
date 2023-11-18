package use_case.productDetails;

public interface ProductOutPutBoundary {
    void prepareSuccessView(ProductOutputData info);
    void prepareFailView(String error);
}
