package use_case.create_product;

public interface CreatePdOutPutBoundary {
    void prepareFailCreateView(String s);

    void prepareSuccessCreateView(String s);

}
