/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author devincargill
 */
public class TextEditorFXMLController implements Initializable {

//    Used to tag non public controller member fields
//    and handler methods for use by FXML markup
    
    @FXML
    private TextArea textArea;
    @FXML
    private VBox root;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleOpen(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.getExtensionFilters().add(
                new ExtensionFilter("Text files", "*.txt", "*.html", "*.c")
        );
        
        fileChooser.showOpenDialog(stage);
        
        File file = fileChooser.showOpenDialog(stage);
        
        if(file != null){
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String document = "";
                String line = "";
                
                while((line = bufferedReader.readLine()) != null){
                    document += line + "\n";
                }
                
                textArea.setText(document);
                
            } catch (FileNotFoundException ex) {
                
                displayExceptionAlert(ex);
            } catch (IOException ex) {
                
                displayExceptionAlert(ex);
            } finally {
                if(bufferedReader != null){
                    try {
                        
                        bufferedReader.close();
                    } catch (IOException ex) {
                        
                        displayExceptionAlert(ex);
                    }
                    
                }
            }
        }
    }
    
    private void displayExceptionAlert(Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        //alert.setHeaderText("Exception!");
        alert.setHeaderText(ex.getClass().getCanonicalName());
        alert.setContentText(ex.getMessage());
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();
        
        Label label = new Label("The exception stacktrace was:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(true);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        
        GridPane expContent = new GridPane();
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
    
    @FXML
    public void handleSave(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) root.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        FileWriter writer = null;
        
        if(file != null){
            try {
                writer = new FileWriter(file);
                writer.write(textArea.getText());
            } catch (IOException ex) {
                displayExceptionAlert(ex);
            } catch (Exception ex){
                displayExceptionAlert(ex);
            } finally {
                if(writer != null){
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        displayExceptionAlert(ex);
                    } catch (Exception ex){
                        displayExceptionAlert(ex);
                    }
                }
            }
        }
    //end handleSave
    }
    
    @FXML
    public void handleDelete(ActionEvent Event){
        System.out.println("Delete selected");
    }
    
    @FXML
    public void handleAbout(ActionEvent Event){
        System.out.println("About selected");
    }
    
//    Model View Controller (MVC)
//      * FXML File (UI) Code -> View
//      * Java Class handles the events for UI -> Controller
//      * "Domain Objects", on the java side, that connect to the view
//         through the controller -> Model
    
}
