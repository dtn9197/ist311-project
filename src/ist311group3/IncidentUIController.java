
package ist311group3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class IncidentUIController implements Initializable {

    @FXML
    private ListView<Incident> listView;
    @FXML
    private ObservableList<Incident> listViewData;
    @FXML
    private Label idLabel;
    @FXML
    private Label CategoryLabel;
    @FXML
    private Label RatingLabel;
    @FXML
    private Label LocationLabel;
    @FXML 
    private Button goHome;
    @FXML
    private Button deleteButton;
    @FXML 
    private Label description;
    @FXML
    Pane pane;
    @FXML
    private Label nameLabel;
    @FXML 
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Button editButton;
    @FXML
    private AnchorPane photoPane;
    ArrayList<Incident> incidentList;
    
    public IncidentUIController()
    {
        incidentList = ReportIncidentUIController.inL.getIncidents();
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        loadIncident();
    }
    
    public void loadIncident()
    {
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? 
                extends Incident> observable, Incident oldValue, Incident newValue) -> {
            
           Incident selectedIncident = listView.getSelectionModel().getSelectedItem();
           if(incidentList.size( )<= 0)
           {
            idLabel.setText(" ");
            CategoryLabel.setText(" ");
            RatingLabel.setText(" ");
            LocationLabel.setText(" ");
            description.setText(" ");
            idLabel.setText(" "); 
           }
           else
           {
            idLabel.setText("Incident ID");
            CategoryLabel.setText(selectedIncident.getCategoryType());
            RatingLabel.setText(Integer.toString(selectedIncident.getRating()));
            LocationLabel.setText(selectedIncident.getLocation().toString());
            description.setText(selectedIncident.getDescription());
            idLabel.setText("Incident ID: " + selectedIncident.getIncidentID()); 
           }
        });  
//loads all the incidents in the database into a list view
        loadIncidentList();
    }
    public void removeButtonClicked()
    {
            listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
            CategoryLabel.setText(" ");
            
            if(!incidentList.isEmpty())
            {
                for (int i = 0; i < incidentList.size(); i++)
                {
                    if(incidentList.get(i).getIncidentID()== (listView
                            .getSelectionModel().getSelectedItem().getIncidentID()))
                    {
                    this.incidentList.remove(i);
                    idLabel.setText(" ");
                    CategoryLabel.setText(" ");
                    RatingLabel.setText(" ");
                    LocationLabel.setText(" ");
                    description.setText(" ");
                    idLabel.setText(" "); 
                    }
                }
            }
        //test that the item was removed
        
        System.out.println(incidentList.toString());
    
    }
    
    public void goBackButtonClicked() 
    {
        NavigationController newController  = new NavigationController();
        newController.setStage((Stage)goHome.getScene().getWindow());
      
    }
    
    public void loadIncidentList() 
    {
        //loads incidents into observablelist
        listViewData = FXCollections.observableArrayList();
        for (int  i = 0; i < incidentList.size(); i++) {
            listViewData.add(incidentList.get(i));
        }
        listView.setItems(listViewData);
        //add observablelist into listview
    }
    public void handleEditButton()
    {
            TextField text = new TextField();
            pane.getChildren().add(text);
            
            Button button = new Button();
            button.setText("Submit Change");
           
            pane2.getChildren().add(button);
            
           button.setOnAction((ActionEvent event2)->
           {
            Label label3 = new Label();
            label3.setText("Thank you. This incident has been updated.");
            
            String replacedDescription = text.getText();
            
            if(incidentList.size() >= 1)
            {
                for(int i = 0; i < incidentList.size(); i++)
                {   
                    if(incidentList.get(i).getDescription().equals(listView.getSelectionModel().getSelectedItem().getDescription()))
                    {
                        incidentList.get(i).setDescription(replacedDescription);
                    }
                    System.out.println(incidentList.get(i).toString2());
                }
            }
            description.setText(replacedDescription);
            pane1.getChildren().add(label3);
            });
     
    }
   
    
    
}
 