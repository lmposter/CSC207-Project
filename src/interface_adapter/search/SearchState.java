package interface_adapter.search;


public class SearchState {

    private String message = "";

    private String content = "";

    private String contentError = null;

    public SearchState(SearchState copy){
        this.content = copy.content;
        this.contentError = copy.contentError;
        this.message = copy.message;
    }

    public SearchState(){}

    public String getMessage(){ return message;}

    public void setMessage(String message) { this.message = message;}

    public String getContent() {return content;}

    public void setContent(String text) {
        this.content = text;
    }
    public void setContentError(String contentError){
        this.contentError = contentError;
    }

    public String getContentError(){
        return contentError;
    }
}
