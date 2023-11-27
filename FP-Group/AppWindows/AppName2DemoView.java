import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import java.lang.RuntimeException;

public class AppName2DemoView extends Application{


   public static void main(String[] args){
   
      launch(args);
   }
   
   @Override
   public void start(Stage stage)throws Exception{ 
   
      Parent root = FXMLLoader.load(getClass().getResource("AppName2.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("RECIPE");
      stage.setScene(scene);
      stage.show();
   
   
     
   
   } 
   
   
}
