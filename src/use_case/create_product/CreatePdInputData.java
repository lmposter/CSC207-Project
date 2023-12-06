package use_case.create_product;

import java.net.URL;

public class CreatePdInputData {
    private final String title;
    private final String price;
    private final String inventory;
    private final String imageUrl;

    private String username;

    public CreatePdInputData(String title, String price, String inventory, String imageUrl, String username) {
        this.title = title.trim();
        this.price = price;
        this.inventory = inventory;
        this.imageUrl = imageUrl.trim();
        this.username = username;
    }

    public String getTitle(){return title;}

    public String getImageUrl() {
        return imageUrl;
    }

    public String getInventory() {
        return inventory;
    }

    public String getPrice() {
        return price;
    }

    public String getUsername() {
        return username;
    }
}
