package interface_adapter.create_product;

public class CreatePdState {
    private String title = "";
    private String titleError = null;

    private String url = "";
    private String urlError = null;
    private String price = "";
    private String priceError = null;
    private String inventory = "";
    private String inventoryError = null;
    private String message = "";

    public CreatePdState(CreatePdState copy){
        this.title = copy.title;
        this.titleError = copy.titleError;
        this.priceError = copy.priceError;
        this.inventoryError = copy.inventoryError;
        this.urlError = copy.urlError;
        this.url = copy.url;
        this.price = copy.price;
        this.inventory = copy.inventory;
        this.message = copy.message;
    }

    public CreatePdState(){}

    public String getTitle(){ return title;}

    public void setTitle(String title) { this.title = title;}

    public String getTitleError(){ return titleError;}

    public void setTitleError(String titleError) { this.titleError = titleError;}

    public String getPrice(){ return price;}

    public void setPrice(String price) { this.price = price;}

    public String getPriceError(){ return priceError;}

    public void setPriceError(String priceError) { this.priceError = priceError;}
    public String getInventory(){ return inventory;}

    public void setInventory(String inventory) { this.inventory = inventory;}

    public String getInventoryError(){ return inventoryError;}

    public void setInventoryError(String inventoryError) { this.inventoryError = inventoryError;}
    public String getUrl(){ return url;}

    public void setUrl(String url) { this.url = url;}

    public String getUrlError(){ return urlError;}

    public void setUrlError(String inventoryError) { this.urlError = urlError;}

    public String getMessage(){ return message;}

    public void setMessage(String message) { this.message = message;}

}
