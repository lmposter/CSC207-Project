package interface_adapter.API;

import entity.LoginUser;
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
    private static final String API_TOKEN = System.getenv("API_TOKEN_MongoDB");

    public static void insertOne(LoginUser user) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = new JSONObject();
        JSONObject insert_document = new JSONObject();
        insert_document.put("username", user.getName());
        insert_document.put("id", user.getId());
        insert_document.put("password", user.getPassword());
        requestBody.put("collection", "UsersCollection");
        requestBody.put("database", "CSC207");
        requestBody.put("dataSource", "CSC207");
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
//        System.out.println(requestBody.toString());
//        System.out.println(request.headers());
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException | JSONException e){
            System.out.println("saving failed failed");
        }
    }
    public static boolean findOneByName(String name) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = new JSONObject();
        JSONObject insert_document = new JSONObject();
        insert_document.put("username", name);
        requestBody.put("collection", "UsersCollection");
        requestBody.put("database", "CSC207");
        requestBody.put("dataSource", "CSC207");
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
//        System.out.println(requestBody.toString());
//        System.out.println(request.headers());
        try {
            Response response = client.newCall(request).execute();
            String resString = response.body().string();
            boolean result = resString.contains("null");
//            System.out.println(response.body().string() + "check name " + !result);
            response.body().close();
            return !result;
        } catch (IOException | JSONException e) {
            System.out.println("Find one by Name failed failed");
            return false;
        }
    }
}
