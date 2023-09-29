# Full-Stack-Shopping-App (Group 132)
## Project Domain
The problem domain our team is tentatively wanting to focus on is e-commerce and online shopping. We are considering developing a full-stack shopping application that will allow users to browse, search for, and purchase products from various online retailers.
## Description of the application
- User Registration and Profiles: Users will be able to create accounts, manage their profiles, and track their order history.
- Product Catalog: The application will have a comprehensive product catalog, categorizing items for easy navigation. Users can filter and sort products based on various criteria.
- Shopping Cart: Users can add products to their shopping carts, review items, adjust quantities, and proceed to checkout.
- Payments Simulation: The application will be able to simulate payments.
- Order Management: Users can track the status of their orders.
- Reviews and Ratings: Users can leave reviews and ratings for products, helping others make informed decisions.
- Search Functionality: A robust search feature will enable users to find products quickly, using keywords, filters, and sorting options.
- Recommendations and Personalization: The app may offer product recommendations based on user preferences and purchase history.
- Seller Dashboard: An administrative panel will allow retailers to manage their product listings, track sales, and handle customer inquiries.
- Mobile Platform: The application will be built with Andriod Studio, ensuring a seamless mobile shopping experience on Andriod devices.
## Tools Used
- Java
- UML
- Android Studio
- FireBase

## Image of trying out the weather API on postman
![TryAPI](https://github.com/lmposter/Full-Stack-Shopping-App/assets/144400489/0eceb9f2-0a01-4bbc-aed8-e4bfa8c2909b)
## API Documentation
[Weather API](https://openweathermap.org/api)
## API Description
Integrating a weather API into a shopping app can enhance user experience by providing real-time weather information, allowing personalized product recommendations based on current season/weather conditions.
## Example Code
```java

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
```
## Output
```java
{"coord":{"lon":-60,"lat":60},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"base":"stations","main":{"temp":277.02,"feels_like":277.02,"temp_min":277.02,"temp_max":277.02,"pressure":1020,"humidity":75,"sea_level":1020,"grnd_level":1020},"visibility":10000,"wind":{"speed":0.72,"deg":85,"gust":0.91},"clouds":{"all":100},"dt":1696015048,"sys":{"sunrise":1695981601,"sunset":1696023642},"timezone":-14400,"id":0,"name":"","cod":200}
```
## Interpretation
```java
import org.json.JSONObject;

public class WeatherParser {

    public static void main(String[] args) {
        // Example Weather API response
        String weatherApiResponse = "{\"coord\":{\"lon\":-60,\"lat\":60},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":277.02,\"feels_like\":277.02,\"temp_min\":277.02,\"temp_max\":277.02,\"pressure\":1020,\"humidity\":75,\"sea_level\":1020,\"grnd_level\":1020},\"visibility\":10000,\"wind\":{\"speed\":0.72,\"deg\":85,\"gust\":0.91},\"clouds\":{\"all\":100},\"dt\":1696015048,\"sys\":{\"sunrise\":1695981601,\"sunset\":1696023642},\"timezone\":-14400,\"id\":0,\"name\":\"\",\"cod\":200}";

        // Parse the JSON response
        JSONObject weatherData = new JSONObject(weatherApiResponse);

        // Extract relevant information
        double temperature = weatherData.getJSONObject("main").getDouble("temp");
        String description = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
        double windSpeed = weatherData.getJSONObject("wind").getDouble("speed");
        int humidity = weatherData.getJSONObject("main").getInt("humidity");
        int visibility = weatherData.getInt("visibility");

        // Example usage in a shopping app context
        System.out.println("Current temperature: " + temperature + " K");
        System.out.println("Weather description: " + description);
        System.out.println("Wind speed: " + windSpeed + " m/s");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Visibility: " + visibility + " meters");
    }
}
```
We will use these extracted values to make decisions or display information within the shopping app based on the weather conditions. For instance, weather-appropriate clothing or display relevant promotions based on the current weather.