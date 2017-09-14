 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bnotifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author devincargill
 */
public class Dc23bNotifier extends Application {
   
    public String title = "Notifier";
    public String input;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        
        TextField titleField = new TextField();
        root.add(titleField, 0 , 0);
        
        
        // creating VBOX
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0 , 20, 10, 20));

        // adding buttons to VBOX
        Button notifyButton = new Button("Notify");
        Button clearButton = new Button("Clear");
        Button printButton = new Button("Print");
        notifyButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setMaxWidth(Double.MAX_VALUE);
        printButton.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(notifyButton, clearButton, printButton);
        
        notifyButton.setOnAction((ActionEvent event) -> {
            titleField.setText("You have been notified!");
        });
        
        clearButton.setOnAction((ActionEvent event) -> {
            titleField.setText("");
        });
        
        printButton.setOnAction((ActionEvent event) -> {
            input = titleField.getText();
            System.out.println(input);
        });
        
        root.add(vbox, 1, 0);
        
        Scene scene = new Scene(root, 420, 250);
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
