import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RecipeApp extends Application {

    private ObservableList<String> recipes;
    private ListView<String> recipeListView;
    private TextArea recipeDetailsTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize data
        recipes = FXCollections.observableArrayList();
        recipes.addAll("Pasta with Tomato Sauce", "Chicken Stir Fry", "Chocolate Cake");

        // Create UI components
        recipeListView = new ListView<>(recipes);
        recipeDetailsTextArea = new TextArea();
        recipeDetailsTextArea.setEditable(false);

        // Set up event handlers
        recipeListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showRecipeDetails(newValue));

        // Create layout
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(recipeListView);
        borderPane.setCenter(recipeDetailsTextArea);

        // Set up the scene
        Scene scene = new Scene(borderPane, 700, 700);

        // Set up the stage
        primaryStage.setTitle("Recipe App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showRecipeDetails(String recipeName) {
        // Dummy method for displaying recipe details
        String details = getDummyRecipeDetails(recipeName);
        recipeDetailsTextArea.setText(details);
    }

    private String getDummyRecipeDetails(String recipeName) {
        // Dummy method for generating recipe details
        switch (recipeName) {
            case "Pasta with Tomato Sauce":
                return "Ingredients:\n- Pasta\n- Tomato Sauce\n\nInstructions:\n1. Cook pasta\n2. Mix with tomato sauce";
            case "Chicken Stir Fry":
                return "Ingredients:\n- Chicken\n- Vegetables\n- Soy Sauce\n\nInstructions:\n1. Cook chicken\n2. Stir fry with vegetables and soy sauce";
            case "Chocolate Cake":
                return "Ingredients:\n- Flour\n- Sugar\n- Cocoa Powder\n\nInstructions:\n1. Mix dry ingredients\n2. Bake in the oven";
            default:
                return "No details available for " + recipeName;
        }
    }
}
