
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

public class API_Example {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=60&lon=-60&appid=2211b12b2ec1af2ed9d08bb36ff48ecb"))
                .header("appid", "2211b12b2ec1af2ed9d08bb36ff48ecb")
                .header("lat", "60.45")
                .header("lon", "-60.45")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            return;
        } catch (InterruptedException e) {
            return;
        }
        System.out.println(response.body());
    }
}