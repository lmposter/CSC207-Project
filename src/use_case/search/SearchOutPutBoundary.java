package use_case.search;

public interface SearchOutPutBoundary {
    void prepareNoMatchProductView(String message);

    void prepareSuccessView(SearchOutPutData product);
}
