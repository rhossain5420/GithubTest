import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;





public class RandomMealApp extends Application {

    private Label mealLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Random Meal Generator");

        mealLabel = new Label("Click the button to generate a random meal");

        Button generateButton = new Button("Generate Random Meal");
        generateButton.setOnAction(e -> generateRandomMeal());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(generateButton, mealLabel);

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
        
    }

    private void generateRandomMeal() {
        try {
            // API call to get a random meal
            String url = "https://www.themealdb.com/api/json/v1/1/random.php";
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonString = response.body();
                Gson gson = new Gson();
                MealsResponse mealsResponse = gson.fromJson(jsonString, MealsResponse.class);
                Meal randomMeal = mealsResponse.getMeals().get(0);
                mealLabel.setText(randomMeal.toString());
            } else {
                throw new RuntimeException("Failed: HTTP error code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
