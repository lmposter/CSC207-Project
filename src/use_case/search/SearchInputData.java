package use_case.search;

public class SearchInputData {
    private final String[] searchContent;
    private final String username;
    public SearchInputData(String searchContent, String username) {
        this.searchContent = searchContent.split(" ");
        this.username = username;
    }

    public String[] getContent(){return searchContent;}

    public String getUsername() {
        return username;
    }
}
