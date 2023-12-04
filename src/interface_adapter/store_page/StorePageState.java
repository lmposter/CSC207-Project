package interface_adapter.store_page;
import entity.Product;

import java.util.ArrayList;

public class StorePageState {
    private String username = "";
    private String usernameError = null;
    private String id = "";
    private String idError = null;

    private ArrayList<Product> products = new ArrayList<>();
    private String productsError = null;
    public StorePageState(StorePageState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        id = copy.id;
        idError = copy.idError;
        products = copy.products;
        productsError = copy.productsError;


    }
    public StorePageState() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getId() {
        return id;
    }

    public String getIdError() {
        return idError;
    }
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public ArrayList<Product> getProducts(){return products;}
    public String getProductsError(){return productsError;}
    public void setProducts(ArrayList<Product> products){this.products = products;}
    public void setProductsError(String error){this.productsError = error;}
}

