 //Rohed Hossain,Mohamed Abdalla,Michael Decoster
// 12/11/23
/**
This is the driver to open the ReciNation App
*/
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import java.lang.RuntimeException;

public class ReciNationDemoView extends Application{

/**
launches the app
*/
   public static void main(String[] args){
   
      launch(args);
   }
   
   /**
   start
   
   sets the FXML and displays the app
   */
   
   @Override
   public void start(Stage stage)throws Exception{ 
      Parent root = FXMLLoader.load(getClass().getResource("ReciNation.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("ReciNation");
      stage.setScene(scene);
      stage.show();
   
   
     
   
   } 
   
   /**
   stop
   stops the appliction
   */
   @Override
   public void stop() {
      System.out.println("Application Class Stoped!");
   }

   
}
