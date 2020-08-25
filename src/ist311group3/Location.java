
package ist311group3;

public class Location 
{
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    
    
    public Location(String street, String c, String stat, int z)
    {   
        streetAddress = street;
        city = c;
        state = stat;
        zip = z;
  
        
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
    
    
    @Override
    public String toString()
    {
        return streetAddress + " " + city + ", " + state + " " + zip + " ";
    }
}