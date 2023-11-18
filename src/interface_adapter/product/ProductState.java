package interface_adapter.product;

import interface_adapter.search.SearchState;

public class ProductState {
    private String message = "";

    private String pdID = "";

    private String pdIDError = null;

    public ProductState(ProductState copy){
        this.pdID = copy.pdID;
        this.pdIDError = copy.pdIDError;
        this.message = copy.message;
    }

    public ProductState(){}

    public String getMessage(){ return message;}

    public void setMessage(String message) { this.message = message;}
    public String getID() {return pdID;}
    public void setID(String ID) {this.pdID = ID;}
    public void setIDError(String IDError) {
        this.pdIDError = pdIDError;
    }

    public String getPdIDError(){
        return pdIDError;
    }
}
