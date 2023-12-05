package interface_adapter.API;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 3adc5da1ca3d1c3d349e71a3112df8f3d4f36a44

public class DatabaseAPI
{
    private static final String INSERT_ONE_API_URL = "https://us-east-2.aws.data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/insertOne";
    private static final String FIND_ONE_API_URL = "https://us-east-2.aws.data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/findOne";

    private static final String FIND_API_URL = "https://us-east-2.aws.data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/find";

    private static final String UPDATE_ONE_API_URL = "https://us-east-2.aws.data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/updateOne";
    private static final String DELETE_ONE_API_URL = "https://data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/deleteOne";

    private static final String Find_API_URL = "https://data.mongodb-api.com/app/data-dfulc/endpoint/data/v1/action/find";
    private static final String API_TOKEN = System.getenv("API_TOKEN_MongoDB");

    private static JSONObject createResponseBody()
    {
        JSONObject requestBody = new JSONObject();
        requestBody.put("collection", "UsersCollection");
        requestBody.put("database", "CSC207");
        requestBody.put("dataSource", "CSC207");
        return requestBody;
    }
    private  static JSONObject createProductBody(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("collection", "Products");
        requestBody.put("database", "CSC207");
        requestBody.put("dataSource", "CSC207");
        return requestBody;
    }

    public static void insertOne(LoginUser user)
    {
        System.out.println("insert one");
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
        Request request = new Request.Builder().url(INSERT_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean findOne(String field, String value)
    {
        System.out.println("findone");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject projection = new JSONObject();

        projection.put("_id", 0);
        insert_document.put(field, value);
        requestBody.put("filter", insert_document);
        requestBody.put("projection", projection);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(FIND_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            boolean result = resString.contains("null");
            response.body().close();
            return !result;
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static LoginUser get(String field, String value, BuyerFactory buyerFactory, SellerFactory sellerFactory)
    {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject projection = new JSONObject();
        projection.put("_id", 0);
        insert_document.put(field, value);
        requestBody.put("projection", projection);
        requestBody.put("filter", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(FIND_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            response.body().close();
            JSONObject mainObject = new JSONObject(resString);
            JSONObject documentObject = mainObject.getJSONObject("document");
            String password = documentObject.getString("password");
            String name = documentObject.getString("name");
            String id = documentObject.getString("id");
            String cart = documentObject.getString("cart");
            if (id.startsWith("B"))
            {
                if (cart.equals("empty"))
                {
                    return new Buyer(name, password, id, new ShoppingCart());
                } else
                {
                    return new Buyer(name, password, id, new ShoppingCart());
                }
            } else
            {
                return new Seller(name, password, id);
            }
        } catch (IOException | JSONException e)
        {
//            e.printStackTrace();
            return null;
        }
    }

    public static void delete(String field, String value)
    {
        System.out.println("Delete");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        insert_document.put(field, value);
        requestBody.put("filter", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(DELETE_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
    }

    public static int getAttempts(String field, String value)
    {
        System.out.println("Get attempts");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject projection = new JSONObject();
        projection.put("_id", 0);
        insert_document.put(field, value);
        requestBody.put("projection", projection);
        requestBody.put("filter", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(FIND_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            response.body().close();
            JSONObject mainObject = new JSONObject(resString);
            JSONObject documentObject = mainObject.getJSONObject("document");
            return documentObject.getInt("attempts");
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public static void updateAttempts(String field, String value)
    {
        System.out.println("Update attempts");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject updateOperation = new JSONObject();
        JSONObject updatevalue = new JSONObject();
        updatevalue.put("attempts", 1);
        updateOperation.put("$inc", updatevalue);
        insert_document.put(field, value);
        requestBody.put("filter", insert_document);
        requestBody.put("update", updateOperation);
        requestBody.put("upsert", false);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(UPDATE_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            client.newCall(request).execute();
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
    }

    public static void resetAttempts(String field, String value)
    {
        System.out.println("Reset attempts by Name");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject updateOperation = new JSONObject();
        JSONObject updatevalue = new JSONObject();
        insert_document.put(field, value);
        updatevalue.put("attempts", 0);
        updateOperation.put("$set", updatevalue);
        requestBody.put("filter", insert_document);
        requestBody.put("update", updateOperation);
        requestBody.put("upsert", false);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(UPDATE_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
    }

    public static void buyProduct(String field, String value, String id, String title, Double price) {
        System.out.println("Bud products by Name");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        JSONObject updateOperation = new JSONObject();
        JSONObject updatevalue = new JSONObject();
        String[] product = new String[3];
        product[0] = id;
        product[1] = title;
        product[2] = String.valueOf(price);
        insert_document.put(field, value);
        updatevalue.put("products", product);
        updateOperation.put("$push", updatevalue);
        requestBody.put("filter", insert_document);
        requestBody.put("update", updateOperation);
        requestBody.put("upsert", false);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(UPDATE_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
    }
    public static List<String[]> findProducts(String username) {
        System.out.println("Find Product");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = createResponseBody();
        JSONObject insert_document = new JSONObject();
        insert_document.put("name", username);
        requestBody.put("filter", insert_document);
        RequestBody body = RequestBody.create(requestBody.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder().url(FIND_ONE_API_URL).post(body).header("Content-Type", "application/json").header("Accept", "*/*").header("Access-Control-Request-Headers", "*").header("api-key", API_TOKEN).build();
        try
        {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            response.body().close();
            System.out.println(resString);
            JSONObject mainObject = new JSONObject(resString);
            JSONObject documentObject = mainObject.getJSONObject("document");
            JSONArray documentsArray = mainObject.getJSONArray("products");
            List<JSONObject> list = jsonArrayToList(documentsArray);
        } catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }
    return  null;}

    private static List<JSONObject> jsonArrayToList(JSONArray documentsArray) {
        List<JSONObject> list = new ArrayList<>();
        for (int i = 0; i < documentsArray.length(); i++) {
            list.add(documentsArray.getJSONObject(i));
        }
        return list;
    }
}
