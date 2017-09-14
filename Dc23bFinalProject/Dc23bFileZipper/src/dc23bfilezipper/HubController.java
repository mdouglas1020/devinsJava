/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bfilezipper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author devincargill
 */
public class HubController extends Switchable implements Initializable, userAuth {
    public int logonAttempts;
    
    @FXML
    private Button logon_btn;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Label message;
    
    @Override
    public int compareUser(String input){
        if(input.equals(userAuth.appUser)){
            return 1;
        } else {
            logonAttempts++;
            return 0;
        }
    }
    
    @Override
    public int comparePass(String input){
        if(input.equals(userAuth.appPass)){
            return 1;
        } else {
            logonAttempts++;
            return 0;
        }
    }
    
    @Override
    public void messageHint(){
        if(logonAttempts > userAuth.hintAttempts){
            String m = message.getText();
            if (m.equals("logged in")) {
                
            } else {
                message.setText(userAuth.hint);
            }
        }
    }
    
    @FXML
    private void viewAppInfo(ActionEvent event){
        Switchable.switchTo("AboutFXML");
    }
    
    @FXML
    private void login_validate(ActionEvent event) {
        String inputUser = user.getText();
        String inputPass = pass.getText();

        //bug testing
        System.out.println(logonAttempts);
        // bug testing 
       
        if(compareUser(inputUser) == 1){
            if(comparePass(inputPass) == 1){
                message.setText("logged in");
                Switchable.switchTo("homeFXML");
            } else {
                message.setText(userAuth.passError);
            }
        } else {
            message.setText(userAuth.userError);
        } 
        
        messageHint();
        
    }// end login_validate
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logonAttempts = 0;
    }    
    
}
