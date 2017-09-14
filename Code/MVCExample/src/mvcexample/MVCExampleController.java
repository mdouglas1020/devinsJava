/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author devincargill
 */
public class MVCExampleController implements Initializable {

    TextInputDialog dialog;
    MVCExampleModel model = new MVCExampleModel();
    
    @FXML
    private TextArea textArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void addPersonButton(ActionEvent event){
        dialog = new TextInputDialog();
        dialog.setContentText("Please enter person's name:");
        
        Optional<String> result = dialog.showAndWait();
        
        if(result.isPresent()){
            if( model.addPerson(result.get()) ){
                textArea.setText("Person: " + result.get() + " was added successfully!");
            } else {
                textArea.setText("Could not add person: " + result.get());
            }
        }
    }
    
    @FXML
    public void getEveryoneButton(ActionEvent event){
        textArea.setText(model.getEveryone().toString());
    }
    
    @FXML
    public void deleteEveryoneButton(ActionEvent event){
        if(model.deleteEveryone()) {
            textArea.setText("Everyone was deleted succesfully!");
        } else {
            textArea.setText("Could not delete everyone!");
        }
    }
    
}
