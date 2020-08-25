
package ist311group3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ReportIncidentController 
{
    public ReportIncidentController()
    {
        
    }
  
    public void setStage(Stage stage) 
    {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("ReportIncidentFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Report Incident");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                     System.out.println("Error cannot open Report incident UI");
                } 
    }
}
