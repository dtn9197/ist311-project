/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kelliacockerill
 */
public class ViewReportController 
{
    public ViewReportController()
    {
        
    }
    
    public void setStage(Stage stage)    
    {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("ViewReportFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("All Incidents Report");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                     System.out.println("Error cannot open View Report UI");
                } 
    }
}
