/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author thanh
 */
public class ViewIncidentController {
    

    
    public ViewIncidentController()
            {

                
            }
    public void setStage(Stage stage) 
    {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("IncidentUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("View Incident");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                     System.out.println("Error cannot open View Incident UI");
                } 
        
    }
    
}
