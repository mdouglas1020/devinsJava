/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;



/**
 *
 * @author devincargill
 */
public class DocumentEditor extends Application {
    
    public String title = "Document Editor";
    
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle(title);
        
        VBox root = new VBox();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        //root.setHgap(20);
        
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10);
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField);
        
        grid.add(titleFieldBox, 0 , 0);
        
//        HTMLEditor editor = new HTMLEditor();
//        editor.setPrefSize(600, 500);
//        root.add(editor, 0, 1);
        
        TextArea editor = new TextArea();
        editor.setPrefColumnCount(45);
        editor.setPrefRowCount(25);
        grid.add(editor, 0, 1);
        
        Button saveButton = new Button("Save");
        HBox saveButtonBox = new HBox();
        saveButtonBox.setAlignment(Pos.CENTER_RIGHT);
        saveButtonBox.getChildren().add(saveButton);
        
//        saveButton.setRotate(45);
        
        grid.add(saveButtonBox, 0, 2);
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        fileMenu.getItems().add(openMenuItem); 
        fileMenu.getItems().add(saveMenuItem);
        
       openMenuItem.setOnAction((ActionEvent event) -> {
            System.out.println("Open Chosen");
            FileChooser fileOpenChooser = new FileChooser();
            fileOpenChooser.setTitle("Open Resource File");
            fileOpenChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileOpenChooser.showOpenDialog(primaryStage);
            
    });
        
        saveMenuItem.setOnAction((ActionEvent event) -> {
            System.out.println("Save Chosen");
            FileChooser fileSaveChooser = new FileChooser();
            fileSaveChooser.setTitle("Save Resource File");
            fileSaveChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileSaveChooser.showSaveDialog(primaryStage);
    });
        
        
        
        root.getChildren().add(menuBar);
        root.getChildren().add(grid);
        
        
        
        
        
        Scene scene = new Scene(root, 800, 700);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
