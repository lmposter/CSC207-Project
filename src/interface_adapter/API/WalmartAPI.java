package interface_adapter.API;
import entity.Product;
import entity.ProductFactory;
import entity.Review;
import entity.Tag;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class WalmartAPI {

    public static ArrayList<Product> searchWalmart(String[] searchItems)  {
        try {

            HttpURLConnection connection = getHttpURLConnection(searchItems);

            //GET the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code:" + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                //read the JSON response
                JSONArray searchResults = getSearchResults(connection);
                ArrayList<Product> productList = new ArrayList<>();
                ProductFactory productFactory = new ProductFactory();
                for (int i = 0; i < searchResults.length(); i++) {
                    JSONObject result = searchResults.getJSONObject(i);
                    // Extract individual fields from each object in the array
                    JSONObject product = result.getJSONObject("product");
                    String title = product.getString("title");
                    String id = product.getString("product_id");
                    String photo = product.getString("main_image");
                    int stars = product.getInt("rating");
                    JSONObject inventory = result.getJSONObject("inventory");
                    boolean inStock = inventory.getBoolean("in_stock");
                    int numInventory = 0;
                    if (inStock){numInventory = 1;}
                    JSONObject offers = result.getJSONObject("offers");
                    JSONObject primary = offers.getJSONObject("primary");
                    double price = primary.getDouble("price");
                    Product pd = productFactory.create(title, photo, price, numInventory, new ArrayList<Tag>());
                    Review review = new Review(stars, "This user doesn't leave a comment");
                    pd.addReview(review);
                    pd.setID(id);
                    productList.add(pd);
                }

                return productList;
//              String body = jsonObject.getString("body");
            } else {
                System.out.println("HTTP GET request failed");
            }
            // Disconnect the connection
            connection.disconnect();

    } catch (IOException e) {
            throw new RuntimeException(e);
    } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JSONArray getSearchResults(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        //Parse the JSON response using org.json
        JSONObject jsonObject = new JSONObject(content.toString());
//                System.out.println(jsonObject);

        JSONArray searchResults = jsonObject.getJSONArray("search_results");
        return searchResults;
    }

    private static HttpURLConnection getHttpURLConnection(String[] searchItems) throws IOException {
        String contentS = searchItems[0];
        for (int i = 1; i < searchItems.length; i++){
            contentS = contentS.concat("+").concat(searchItems[i]);
        }

//        System.out.println(contentS);
        String apiToken = System.getenv("API_TOKEN_WAL");
        String urll = "https://api.bluecartapi.com/request?api_key=".concat(apiToken).concat("&search_term=").concat(contentS).concat("&type=search");
        //"https://api.bluecartapi.com/request?api_key={apiToken}&type=search&search_term=".concat(contentS)
//        System.out.println(photoURL);
        URL url = new URL(urll);
        //open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the HTTP request method to GET
        connection.setRequestMethod("GET");
        return connection;
    }

    public static void main(String[] args) {
//        code for testing, uncomment to test
////        String apiToken = System.getenv("API_TOKEN_WAL");
////        System.out.println(apiToken);
////
//        String[] x = new String[2];
//        x[0] = "pen";
//        x[1] = "apple";
//        System.out.println(searchWalmart(x));
    }
    public WalmartAPI(){}
}
