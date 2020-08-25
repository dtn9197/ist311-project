
package ist311group3;

import java.util.ArrayList;
import java.util.List;

public class IncidentList 
{
    private  ArrayList<Incident> incidents = new ArrayList<>();
    public IncidentList()
    {
        
       
    }
    public ArrayList<Incident> getIncidents() 
    {
        return incidents;
    }

    public void setIncidents(ArrayList<Incident> incidents) 
    {
        this.incidents = incidents;
    }
    
      /**
      * Adds a new incident to incident list
      * @param in incident to add
      */                        
    public void fillIncidentList(Incident in)
    {
        incidents.add(in);
        //System.out.println(incidents.toString());
    }
    
    /**
     * Fill a list with category types
     * @param categories List to fill
     */
    public void fillCategoryTypesList(List<String> categories)
    {
        categories.add("Flood");
        categories.add("Road Block");
        categories.add("Other"); 
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        for(int i = 0; i < incidents.size(); i++)
        {
            str +=  "incident " + (i + 1) + ":" + incidents.get(i).toString() + "\n\n";
        }
        
        return str;
    }
}
