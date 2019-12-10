
package phishinggame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginController implements Initializable {
    
    @FXML
    public TextField usernameField, passwordField;
    public Text status;
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception{
        
        //confirm in console that login attempt has been made
        System.out.println("Login attempt");
        //Read from MYSQL database to find verify login and password
        Boolean validate = loginStatus(usernameField, passwordField);
        
        //if password validates then login
        if(validate){
            status.setText("login successful");
            
            Parent newparent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            Scene newscene = new Scene(newparent);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newscene);
            window.show();
        }
        //otherwise stay in login screen
        else{
            
            status.setText("login failed");
        }
        
    }
    
    public boolean loginStatus(TextField usernameinput, TextField passwordinput){
        
        String username = usernameinput.getText();
        String password = passwordinput.getText();
        //match the inputted username and password to the mySQL database
        
        //if a match is found then allow validate
        return true;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
