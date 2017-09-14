/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bfilezipper;

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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author devincargill
 */
public class HomeController extends Switchable implements Initializable {
    private zipModel zipper;
    private Stage stage;
    private File source;
    private File destination;
    
    @FXML
    private Label sourceLabel;
    @FXML
    private Label destinationLabel;
    @FXML
    private TextArea message;
    @FXML
    private ProgressBar progressBar;
    
    @FXML 
    private void handleLogout(Event event){
        Switchable.switchTo("HubFXML");
    }
    
    @FXML
    private void handleSave(Event event){
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) root.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        FileWriter writer = null;
        
        if(file != null){
            try {
                writer = new FileWriter(file + ".txt");
                writer.write(message.getText());
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
    }
    
    @FXML
    private void handleOpen(Event event){
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) root.getScene().getWindow();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text files", "*.txt")
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
                message.setText(document);
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
    
    
    @FXML
    private void handleSelectSourceDirectory(Event event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(stage);
        if (directory != null) {
            sourceLabel.setText(directory.getPath());
            source = directory;
        }
    }
    
    @FXML
    private void handleSelectDestinationDirectory(Event event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(stage);
        if (directory != null) {
            destinationLabel.setText(directory.getPath());
            destination = directory;
        }
    }
    
    @FXML
    private void handleZip(Event event) {
        
        progressBar.setProgress(0);
        message.setText("Starting your zip");
        
        if (source == null) {
            message.setText("The source directory is not set.\n");
            return;
        }
        if (destination == null) {
            message.setText("The destination directory is not set.\n");
            return;
        }
        //creating the thread
        zipper = new zipModel(source, destination);
        
        zipper.setOnNotification(new Notification() {
           @Override
           public void handle(double percentZipped, zipState state, String msg){
               if(state.equals(zipState.RUNNING)){
                   progressBar.setProgress(percentZipped);
                   msg =  msg + "\n" + message.getText();
                   message.setText(msg);
               } else if(state.equals(zipState.ENDED)) {
                   progressBar.setProgress(percentZipped);
                   msg =  msg + "\n" + message.getText();
                   message.setText(msg);
               }
               
           }
        });
        
        zipper.start();
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
