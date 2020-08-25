
package ist311group3;
public class User 
{
    private String username;
    private String password;
    
    
    public User(String un, String pw)
    {
         username = un;
         password = pw; 
    }
    
    //test User
    
    public String getUsername() {
        return username;
    }

   
    public String getPassword() {
        return password;
    }

  
    public void setUsername(String username) {
        this.username = username;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

   
 
}
