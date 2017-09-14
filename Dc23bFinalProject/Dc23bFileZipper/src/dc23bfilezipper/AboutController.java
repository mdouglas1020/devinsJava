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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author devincargill
 */
public class AboutController extends Switchable implements Initializable {

    @FXML TextArea instructions;
    
    @FXML
    private void back(ActionEvent event){
        Switchable.switchTo("HubFXML");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instructions.setEditable(false);
    }    
    
}
