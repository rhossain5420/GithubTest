 //Rohed Hossain,Mohamed Abdalla,Michael Decoster
// 12/11/23
/**
This is designed to set the features, design and API call to the 
ReciNation window
*/
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
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
FXML

gets the designs made from scene builder
*/
public class ReciNationController1 {

    @FXML
    private Label Instructions;

    @FXML
    private SplitPane Scene;

    @FXML
    private Label Title;

    @FXML
    private ImageView foodImage;

    @FXML
    private Button generateButton;

    @FXML
    private Label textLabel; 

    @FXML
    private ListView<String> textList; 

    @FXML
    private Hyperlink youTube;

    private Meal meals;

    @FXML
    protected void clickVideo(ActionEvent event) {
        openYouTubeLink(meals.strYoutube);
    }

      // Call the API and display data
    @FXML
    protected void generateRecipes(ActionEvent event) {
       
        fetchDataFromApi();
        System.out.println("Button pressed");
    }
    
    // fetches data from API
    private void fetchDataFromApi() {
        try {
            String url = "https://www.themealdb.com/api/json/v1/1/random.php";

            // HttpRequest
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            // HttpClient
            HttpClient client = HttpClient.newBuilder().build();

            // HttpResponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // System.out.println("Response: " + response.statusCode());

            if (response.statusCode() == 200) {
                // Process the JSON response
                String jsonString = response.body();
                Gson gson = new Gson();
                MealsResponse mealsResponse = gson.fromJson(jsonString, MealsResponse.class);
                meals = mealsResponse.getMeals().get(0);
                
                // Display data in your UI components
                displayData();
            } else {
                textLabel.setText("Failed to fetch data from the API. Status code: " + response.statusCode());
            }
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
            textLabel.setText("IOException occurred while fetching data");
        } catch (InterruptedException e) {
            // Handle InterruptedException
            e.printStackTrace();
            textLabel.setText("InterruptedException occurred while fetching data");
        }
    }

// display the indtructions, indredients,Country name, and Dish Name
    private void displayData() {
        // this part show the text
        String istro = "Instructions : ";
        String ing = "Ingredients : ";
        textLabel.setText("Country Name: " +meals.getstrArea() + "\n" + "Dish Name: "+ meals.getstrMeal());
        
                ObservableList<String> ingredients = FXCollections.observableArrayList(
                ing, meals.strIngredient1, meals.strIngredient2, meals.strIngredient3,
                meals.strIngredient4, meals.strIngredient5, meals.strIngredient6,
                meals.strIngredient7, meals.strIngredient8, meals.strIngredient9,
                meals.strIngredient10, istro, meals.strInstructions
                       );

        textList.setItems(ingredients);
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
