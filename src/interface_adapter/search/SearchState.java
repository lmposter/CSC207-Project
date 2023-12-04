package interface_adapter.search;


import entity.Product;

import java.util.ArrayList;

public class SearchState
{

    private String username;
    private String message = "";

    private String content = "";

    private boolean isBuyer;

    private ArrayList<Product> products = new ArrayList<>();
    private String productsError = null;
    private String contentError = null;

    public SearchState(SearchState copy)
    {
        this.username = copy.username;
        this.content = copy.content;
        this.contentError = copy.contentError;
        this.message = copy.message;
        this.products = copy.products;
        this.productsError = copy.productsError;
    }

    public SearchState(){}

    public boolean isBuyer()
    {
        return isBuyer;
    }

    public void setBuyer(boolean buyer)
    {
        isBuyer = buyer;
    }

    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    public String getContent(){return content;}

    public void setContent(String text)
    {
        this.content = text;
    }

    public void setContentError(String contentError)
    {
        this.contentError = contentError;
    }

    public String getContentError()
    {
        return contentError;
    }

    public void setProducts(ArrayList<Product> newPds)
    {
        this.products = newPds;
    }

    public void setProductsError(String productsError)
    {
        this.productsError = productsError;
    }

    public ArrayList<Product> getProducts(){return products;}

    public String getProductsError()
    {
        return productsError;
    }

    public void setUsername(String username){this.username = username;}

    public String getUsername(){return this.username;}

}
