
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ReciNationController {

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
    //private HttpClient client;
    private Meal meals;


    @FXML
    protected void clickVideo(ActionEvent event) {
        openYouTubeLink(meals.strYoutube);
    }

    @FXML
    protected void generateRecipes(ActionEvent event) {
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
                // Display data in your UI components
                 displayData();
            } else {
                textBox.setText("Failed to fetch data from the API");
            }
        } catch (Exception e) {
            System.out.println("Error from fatching data!");
        }
    }

     private void displayData() {
         // this part show the text
         textBox.setText(meals.toString());
         // this part show the image
         try {
        Image image = new Image(meals.strMealThumb);
        foodImage.setImage(image);
    } catch (Exception e) {
        System.out.println("Error");
    }
        
     }
     // this part handle the youtube link and video
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



