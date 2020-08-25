
package ist311group3;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ViewReportUIController implements Initializable {

   
   @FXML
   private PieChart categoryPie;
   @FXML
   public AnchorPane piePanel;
   @FXML
   private AnchorPane piePaner;
   ArrayList<Incident> incidentsList;
   @FXML
   private Label totalLabel;
   @FXML
   private PieChart ratingPie;
   @FXML
   private Button goBack;
    
    
    public ViewReportUIController()
    {
        IncidentUIController inx = new IncidentUIController();
        incidentsList = inx.incidentList;
    }
    public void ratingPie()
    {
        ObservableList<PieChart.Data> chartList = FXCollections.observableArrayList();
        IndexedLinkedHashMap<Integer, Integer> Rating = new IndexedLinkedHashMap<>();
        IndexedLinkedHashMap<Integer, ArrayList<Integer>> totals = new IndexedLinkedHashMap<>();
        LinkedHashMap<Integer, Integer> official = new LinkedHashMap<>();
        
        for (int i = 0; i < incidentsList.size(); i++) 
        {
            Rating.put(incidentsList.get(i).getRating(), 1);
        }
        for (int i = 0; i < Rating.keySet().size(); i++) 
        {
            ArrayList<Integer> ratings = new ArrayList<>();
            for (int j = 0; j < incidentsList.size(); j++) 
            {
                if (Rating.getKeyAtIndex(i).equals(incidentsList.get(j).getRating())) 
                {
                    if (Rating.size() == (incidentsList.size())) 
                    {
                        ratings.add(0);
                    } else 
                    {
                        ratings.add(1);
                    }
                }
            }
            totals.put(Rating.getKeyAtIndex(i), ratings);
        }
        for (int x = 0; x < totals.keySet().size(); x++) 
        {
            int total = 0;
            for (int y = 0; y < totals.getValueAtIndex(x).size(); y++) 
            {
                total += totals.getValueAtIndex(x).get(y);
            }
            official.put(totals.getKeyAtIndex(x), total);
        }
        
        for (int key : official.keySet()) 
        {
            chartList.add(new PieChart.Data(key+"", official.get(key)));
        }

        ratingPie = new PieChart(chartList);
        ratingPie.setTitle("Incident data report\nbased on rating");
        piePanel.getChildren().add(ratingPie);
        chartList.forEach(data ->
        data.nameProperty().bind(
                Bindings.concat("Rating: ",
                        data.getName(), " Amount: ", ((int)data.pieValueProperty().doubleValue()), " "
                )
        )
);
        
    }
    
    public void categoryPie()
    {
        ObservableList<PieChart.Data> chartList = FXCollections.observableArrayList();
        IndexedLinkedHashMap<String, Integer> category = new IndexedLinkedHashMap<>();
        IndexedLinkedHashMap<String, ArrayList<Integer>> totals = new IndexedLinkedHashMap<>();
        LinkedHashMap<String, Integer> official = new LinkedHashMap<>();
        
        for (int i = 0; i < incidentsList.size(); i++) 
        {
            category.put(incidentsList.get(i).getCategoryType(), 1);
        }
        for (int i = 0; i < category.keySet().size(); i++) 
        {
            ArrayList<Integer> tally = new ArrayList<>();
            for (int j = 0; j < incidentsList.size(); j++) 
            {
                if (category.getKeyAtIndex(i).equals(incidentsList.get(j).getCategoryType())) 
                {
                    if (category.size() == (incidentsList.size())) 
                    {
                        tally.add(0);
                    } else 
                    {
                        tally.add(1);
                    }
                }
            }
            totals.put(category.getKeyAtIndex(i), tally);
        }
        for (int x = 0; x < totals.keySet().size(); x++) 
        {
            int total = 0;
            for (int y = 0; y < totals.getValueAtIndex(x).size(); y++) 
            {
                total += totals.getValueAtIndex(x).get(y);
            }
            official.put(totals.getKeyAtIndex(x), total);
            System.out.println(official);
        }
        
        for (String key : official.keySet()) 
        {
            chartList.add(new PieChart.Data(key, official.get(key)));
        }

        categoryPie = new PieChart(chartList);
        categoryPie.setTitle("Incident data report\nbased on category");
        chartList.forEach(data ->
        data.nameProperty().bind(
                Bindings.concat(
                        data.getName(), " Total: ", ((int)data.pieValueProperty().doubleValue()), " "
                )
        )
);
        piePaner.getChildren().add(categoryPie);
    }
    public void handleGoBack()
    {
         
        NavigationController newController  = new NavigationController();
        newController.setStage((Stage)goBack.getScene().getWindow());
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        ratingPie();
        categoryPie();
        totalLabel.setText("Total Incidents: " + incidentsList.size());
        totalLabel.setStyle("-fx-font-family:'Avenir';-fx-font-size:14px");
        
        
    }  
}
