package use_case.search;

public class SearchInputData {
    private final String searchContent;
    public SearchInputData(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getContent(){return searchContent;}
}
