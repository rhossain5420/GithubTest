import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ReciNationController2 {

    @FXML
    private Label Instructions;

    @FXML
    private SplitPane Scene;

    @FXML
    private Label Title;

    @FXML
    private AnchorPane firstBackground;

    @FXML
    private ImageView foodImage;

    @FXML
    private Button generateButton;

    @FXML
    private AnchorPane secondBackground;

    @FXML
    private Label textBox;

    @FXML
    private Hyperlink youTube;

    private HttpClient client = HttpClient.newHttpClient(); // Initialize the client
    private Meal meals;

    @FXML
    protected void clickVideo(ActionEvent event) {
        // Add logic for handling video click
    }

    @FXML
    protected void generateRecipes(ActionEvent event) {
        // Call the API and display data
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        try {
            // Replace "YOUR_API_ENDPOINT" with the actual API endpoint
            String apiUrl = "https://www.themealdb.com/api/json/v1/1/random.php";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Process the JSON response
                String jsonString = response.body();
                Gson gson = new Gson();
                MealsResponse mealsResponse = gson.fromJson(jsonString, MealsResponse.class);
                System.out.println("Random Meal \n" + mealsResponse.getMeals().toString());
                // Display data in your UI components
                displayData(mealsResponse.getMeals().get(0));
            } else {
                textBox.setText("Failed to fetch data from the API");
            }
        } catch (Exception e) {
            e.printStackTrace();
            textBox.setText("An error occurred: " + e.getMessage());
        }
    }

    private void displayData(Meal meal) {
        // Update your UI components with data from the 'meal' object
        textBox.setText(meals.strArea.toString());
    }
}
