package interface_adapter.API;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DatabaseAPI {
    private static final String INSERT_ONE_API_URL = "https://us-east-2.aws.data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/insertOne";
    private static final String FIND_ONE_API_URL = "https://us-east-2.aws.data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/findOne";

    private static final String DELETE_ONE_API_URL = "https://data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/deleteOne";
    private static final String API_TOKEN = System.getenv("API_TOKEN_MongoDB");

    private static JSONObject createResponseBody(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("collection", "UsersCollection");
        requestBody.put("database", "CSC207");
        requestBody.put("dataSource", "CSC207");
        return requestBody;
    }
    public static void insertOne(LoginUser user) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();

        insert_document.put("name", user.getName());
        insert_document.put("attempts", 0);
        insert_document.put("id", user.getId());
        insert_document.put("password", user.getPassword());
        insert_document.put("cart", "empty");
        requestBody.put("document", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(INSERT_ONE_API_URL)
                .post(body)
                .header("Content-Type", "application/json")
                .header("Accept","*/*")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", API_TOKEN)
                .build();
//        testing
//        System.out.println(requestBody.toString());
//        System.out.println(request.headers());
        try {
            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
        } catch (IOException | JSONException e){
            System.out.println("saving failed failed");
            e.printStackTrace();
        }
    }
    public static boolean findOne(String field, String value) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject projection = new JSONObject();

        projection.put("_id", 0);
        insert_document.put(field, value);
        requestBody.put("filter", insert_document);
        requestBody.put("projection", projection);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(FIND_ONE_API_URL)
                .post(body)
                .header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", API_TOKEN)
                .build();
//        Testing :
//        System.out.println(requestBody.toString());
//        System.out.println(request.headers());
        try {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            boolean result = resString.contains("null");
            response.body().close();
            return !result;
        } catch (IOException | JSONException e) {
            System.out.println("Find one by Name failed");
            e.printStackTrace();
            return false;
        }
    }

    public static LoginUser get(String field, String value, BuyerFactory buyerFactory, SellerFactory sellerFactory) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject projection = new JSONObject();
        projection.put("_id", 0);
        insert_document.put(field, value);
        requestBody.put("projection", projection);
        requestBody.put("filter", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(FIND_ONE_API_URL)
                .post(body)
                .header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", API_TOKEN)
                .build();
//        Testing :
//        System.out.println(requestBody.toString());
//        System.out.println(request.headers());
        try {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            response.body().close();
            JSONObject mainObject = new JSONObject(resString);
            JSONObject documentObject = mainObject.getJSONObject("document");
            String password = documentObject.getString("password");
            String name = documentObject.getString("name");
            String id = documentObject.getString("id");
            String cart = documentObject.getString("cart");
            if (id.startsWith("B")){
                if (cart.equals("empty")){
                return new Buyer(name, password, id, new ShoppingCart());
                }
                else {
                    return new Buyer(name, password, id, new ShoppingCart());
                }
            } else {
                return new Seller(name, password, id);
            }
        } catch (IOException | JSONException e) {
            System.out.println("Create one by Name failed");
            e.printStackTrace();
            return null;
        }
    }
    public static void delete(String field, String value) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        insert_document.put(field, value);
        requestBody.put("filter", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(DELETE_ONE_API_URL)
                .post(body)
                .header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", API_TOKEN)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException | JSONException e) {
            System.out.println("Delete one by Name failed");
            e.printStackTrace();
        }
    }
}
