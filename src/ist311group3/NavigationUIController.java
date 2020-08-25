
package ist311group3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class NavigationUIController implements Initializable {

    @FXML
    private Button checkLocalButton;
     @FXML
    private Button reportIncidentButton;
    @FXML
    Button viewIncidentListButton;
    @FXML
    private Button viewTotalButton;
    
    
    public NavigationUIController()
    {
        
    }
    
    public void handleReportButton()
    {
        System.out.println("Report Button Selected");
     
            ReportIncidentController newController = new ReportIncidentController();
            newController.setStage((Stage)reportIncidentButton.getScene().getWindow());
      
        
    }
    public void handleCheckLocalButton()
    {
        System.out.println("Check Local Incidents Selected");
        CheckLocalController newController = new CheckLocalController();
        newController.setStage((Stage)reportIncidentButton.getScene().getWindow());
        
        
    }
    public void handleViewIncidentListButton()
    {
        System.out.println("View Incident List Selected");
      
           ViewIncidentController newController = new ViewIncidentController();
           newController.setStage((Stage) reportIncidentButton.getScene().getWindow());
        
    }
    public void handleViewTotalButton()
    {
        System.out.println("View Total Incidents Selected");
      
           ViewReportController newController = new ViewReportController();
           newController.setStage((Stage)viewTotalButton.getScene().getWindow());
       
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
