/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kelliacockerill
 */
public class LoginUIController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button submitButton;
    
    @FXML
    public void handleSubmitAction() {
        System.out.println("Submit!");
       UserList list = new UserList();
        if (list.authenticate(username, password) == true)
            { 
                label.setText("Valid!");
                NavigationController newController = new NavigationController();
                newController.setStage((Stage)label.getScene().getWindow());
            } 
        else
            {
                label.setText("Invalid. Try again.");
            }
        
    }
    @FXML
    public void handleCancelAction(ActionEvent event) {
        System.out.println("Cancel");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
