package use_case.search;

public class SearchInputData {
    private final String[] searchContent;
    public SearchInputData(String searchContent) {
        this.searchContent = searchContent.split(" ");
    }

    public String[] getContent(){return searchContent;}
}
