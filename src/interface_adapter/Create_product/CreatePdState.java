package interface_adapter.Create_product;

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

    public CreatePdState(){}

    public String getTitle(){ return title;}

    public void setTitle(String title) { this.title = title;}

    public String getPrice(){ return price;}

    public void setPrice(String price) { this.price = price;}

    public String getInventory(){ return inventory;}

    public void setInventory(String inventory) { this.inventory = inventory;}

    public String getUrl(){ return url;}

    public void setUrl(String url) { this.url = url;}

    public String getMessage(){ return message;}

    public void setMessage(String message) { this.message = message;}

}
