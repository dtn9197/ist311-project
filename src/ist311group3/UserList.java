
package ist311group3;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserList 
{
    private ArrayList <User> userList;
   
    public UserList()
    {
        userList = new ArrayList<>();
        userList.add(new User("test" , "test"));
    }
    public ArrayList<User> getUserList() {
        return userList;
    }

   
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    @FXML
    public boolean authenticate(TextField username, PasswordField password) 
    {
        boolean authenticate = false;
   
            for (int i = 0; i < userList.size(); i++) 
            {
                authenticate = username.getText().equals(userList.get(i).getUsername()) && 
                        password.getText().equals(userList.get(i).getPassword());
            }
            
        return authenticate;
     } 
}
