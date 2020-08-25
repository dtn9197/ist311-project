
package ist311group3;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ReportIncidentUIController implements Initializable {
    @FXML
    private ComboBox category;
    @FXML 
    private TextArea description;
    @FXML
    private TextField rating;
    @FXML
    private TextField streetAddress;
    @FXML
    private TextField city;
    @FXML
    private TextField zip;
    @FXML
    private TextField state;
    @FXML
    private Button submitButton;
    @FXML
    private Label label;
    @FXML 
    AnchorPane pane;
    @FXML
    private Button uploadFileButton;
    @FXML
    private Button goHome;
    @FXML
    Label idLabel;
    int rate;
    String cat; 
    public int id; 
    String descrip;
    String street;
    String cit; 
    String stat;
    int z;
    String pho;
    
    
    public static IncidentList inL = new IncidentList();
    public String photoString;
    public File photo;
    private final ObservableList<String> categories;
   
    
    public ReportIncidentUIController()
    {
       /* Fill observable list with categories */
       categories = FXCollections.observableArrayList();
       inL.fillCategoryTypesList(categories);   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       category.setItems(categories); //fill combo box
    }  
   
    public void handleUploadFile()
    {
        
        FileChooser fileChooser = new FileChooser();

        uploadFileButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(uploadFileButton.getScene().getWindow());
            photo = selectedFile;
            photoString = selectedFile.toString();
        });
    }
    
    /**
     * Get variables from FXML and store into incident object
     * @return Incident
     */
    public Incident getVariables()
    {
        rate = Integer.parseInt(rating.getText());
        street = streetAddress.getText();
        cit = city.getText();
        stat = state.getText();
        z =  Integer.parseInt(zip.getText());
        descrip = description.getText();
        pho = photo.getName();
        cat = category.getValue().toString();
        
        if(!inL.getIncidents().isEmpty())
        {
            for(int i = 0; i < inL.getIncidents().size(); i++)
            {
            inL.getIncidents().get(i).setIncidentID((int)(Math.random() * (18203-12345) + 12345));
            }
        } 
        Location loc = new Location(street, cit, stat, z);
        Incident in = new Incident(rate, loc, descrip, cat, pho, getId());
        return in;         
    }
    
    /**
     * Adds incident to database
     */
    public void handleSubmitButton()
    {
        Incident in = getVariables();
        inL.fillIncidentList(in);
        System.out.println(inL.getIncidents().toString());
    }
    /**
     * returns to navigation home screen when button is pressed
     */
    public void handleGoBackButton()
    {
         
        NavigationController newController  = new NavigationController();
        newController.setStage((Stage)goHome.getScene().getWindow());
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
