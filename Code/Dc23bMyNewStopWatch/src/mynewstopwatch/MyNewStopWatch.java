/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class MyNewStopWatch extends Application {
    
    private final String appName = "My New Stop Watch";
    private GridPane rootContainer;
    
    @Override
    public void start(Stage primaryStage) {

        rootContainer = new GridPane();
        DigitalStopWatch digitalStopWatch = new DigitalStopWatch();
        AnalogStopWatch analogStopWatch = new AnalogStopWatch();
    
        Button fourTwentyButton = new Button("Start");
        Button snoopDogButton = new Button("Lap");
        
        //Left Button Action
        fourTwentyButton.setOnAction((ActionEvent event) -> {
            if(analogStopWatch.analogRunning != true && 
                digitalStopWatch.digitalRunning != true){
                
                analogStopWatch.start();
                digitalStopWatch.start();
                fourTwentyButton.setText("Stop");
                snoopDogButton.setText("Lap");
            } else {
                
                analogStopWatch.stop();
                digitalStopWatch.stop();
                fourTwentyButton.setText("Start");
                snoopDogButton.setText("Reset");
            }  
        });
        
        //Right Button Action
        snoopDogButton.setOnAction((ActionEvent event) -> {
            if(analogStopWatch.analogRunning != true &&
                digitalStopWatch.digitalRunning != true){
            
                analogStopWatch.reset();
                digitalStopWatch.reset();
                snoopDogButton.setText("Lap");
            } else {
                digitalStopWatch.lap();
            } 
        });
        
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(25);
        buttonBox.getChildren().addAll(fourTwentyButton, snoopDogButton);
        
        rootContainer.add(analogStopWatch.getRootContainer(), 0, 0);
        rootContainer.add(digitalStopWatch.getRootContainer(), 0, 1);
        rootContainer.add(buttonBox, 0, 2);
        
        Scene scene = new Scene(rootContainer, 
                                300, 
                                375);
        
        primaryStage.setTitle(appName);
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
