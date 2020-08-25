
package ist311group3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NavigationController 
{

    public void setStage(Stage stage) 
    {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("NavigationFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Navigation Homescreen");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                     System.out.println("Error cannot open Naviagtion Screen");
                } 
    }
    
}
