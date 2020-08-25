
package ist311group3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CheckLocalController {

    public CheckLocalController() 
    {
        
    }
    public void setStage(Stage stage)
    {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("CheckLocalFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Check Local Incidents");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                     System.out.println("Error cannot open Check local incident UI");
                } 
    }
    
}
