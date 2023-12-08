package CallRandomAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class RandomAPICall {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Add "https://" to the URL
        String url = "https://www.themealdb.com/api/json/v1/1/random.php";

        // HttpRequest
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        // HttpClient
        HttpClient client = HttpClient.newBuilder().build();

        // HttpResponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.statusCode());

        if (response.statusCode() == 200) {
            // Process the JSON response
            String jsonString = response.body();
            Gson gson = new Gson();
            MealsResponse mealsResponse = gson.fromJson(jsonString, MealsResponse.class);
            System.out.println("Random Meal \n" + mealsResponse.getMeals().toString());
            // Print the first random meal
            // if (mealsResponse.getMeals() != null && !mealsResponse.getMeals().isEmpty()) {
            //     System.out.println("First Meal: " + mealsResponse.getMeals().get(0).toString());
            // } else {
            //     System.out.println("No meals found.");
            // }
        } else {
            throw new RuntimeException("Failed: HTTP error code: " + response.statusCode());
        }
    }
}
