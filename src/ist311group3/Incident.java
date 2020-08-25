
package ist311group3;


public class Incident 
{

    private int incidentID;
    private int rating;
    private Location location;
    private String description;
    private String categoryType;
    private String photo;
    
    public Incident(int rat, Location loc, String descr, String cT, String foto, int id)
    {
        rating = rat;
        location = loc;
        description = descr;
        categoryType = cT;
        photo = foto;
        incidentID = id;
    }

    public int getRating() {
        return rating;
    }

    public Location getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public int getIncidentID() {
        return incidentID;
    }

    
    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
        
    }
   
    @Override
    public String toString()
    {
        return "Incident number: " + getIncidentID();
    }
    
    
    public String toString2()
    {
        return "\nRating: " + rating + "\nLocation: " + location.toString() + "\nDescription: " + description
                + "\nCategory: " + categoryType + "\nPhoto: " + photo + "\n" + "incidentID: " + getIncidentID();
    }
   
}
