import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import java.lang.RuntimeException;

public class ReciNationDemoView extends Application{


   public static void main(String[] args){
   
      launch(args);
   }
   
   @Override
   public void start(Stage stage)throws Exception{ 
      Parent root = FXMLLoader.load(getClass().getResource("ReciNation.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("ReciNation");
      stage.setScene(scene);
      stage.show();
   
   
     
   
   } 
   @Override
   public void stop() {
      System.out.println("Application Class Stoped!");
   }

   
}
