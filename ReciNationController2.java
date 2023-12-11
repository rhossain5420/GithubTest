import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ReciNationController2 {

    @FXML
    private Label Instructions;

    @FXML
    private Label List;

    @FXML
    private ListView<String> List1; // Specify the type of ListView

    @FXML
    private SplitPane Scene;

    @FXML
    private Label Title;

    @FXML
    private ImageView foodImage;

    @FXML
    private Button generateButton;

    @FXML
    private String youtubeLink; // Store YouTube link as a class variable

    private Meal meals;

    @FXML
    void clickVideo(ActionEvent event) {
        openYouTubeLink(youtubeLink);
    }

    @FXML
    void generateRecipes(ActionEvent event) {
        // Call the API and display data
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        try {
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
                meals = mealsResponse.getMeals().get(0);
                youtubeLink = meals.getStrYoutube(); // Store YouTube link for later use
                // Display data in your UI components
                displayData();
            } else {
                List1.getItems().clear(); // Clear the ListView
                List1.getItems().add("Failed to fetch data from the API");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error from fetching data!");
        }
    }

    private void displayData() {
        // this part show the text
        List1.getItems().clear(); // Clear the ListView
        List1.getItems().add(meals.toString());
        // this part show the image
        try {
            Image image = new Image(meals.getStrMealThumb());
            foodImage.setImage(image);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // this part handle the YouTube link and video
    private void openYouTubeLink(String youtubeLink) {
        if (youtubeLink != null && !youtubeLink.isEmpty()) {
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(youtubeLink));
            } catch (java.io.IOException | java.net.URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("YouTube link not available");
        }
    }
}
