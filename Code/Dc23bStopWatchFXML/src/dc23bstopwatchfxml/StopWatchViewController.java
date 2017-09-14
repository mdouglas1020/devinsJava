/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bstopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


/**
 *
 * @author devincargill
 */
public class StopWatchViewController implements Initializable {
      
    private digitalStopWatch digitalStopWatchInstance;
    private analogStopWatch analogStopWatchInstance;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        digitalStopWatchInstance = new digitalStopWatch();
        analogStopWatchInstance = new analogStopWatch();
        setupAnalogStopWatch();
        setupDigitalStopWatch();
    }   
    
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Label timeLabel;
    @FXML
    private ImageView handImageView;
    
    @FXML
    private void handleButton1(ActionEvent event) {
        //handle start button
        if("Start".equals(button1.getText())){
            analogStopWatchInstance.getTimeLine().play();
            digitalStopWatchInstance.getTimeLine().play();
            button1.setText("Stop");
            button2.setText("Lap");
            
          //handle stop button 
        } else if("Stop".equals(button1.getText())){
            analogStopWatchInstance.getTimeLine().pause();
            digitalStopWatchInstance.getTimeLine().pause();
            button1.setText("Start");
            button2.setText("Reset");
        }
        
    }
    
    @FXML
    private void handleButton2(ActionEvent event) {
        
        //handle lap button
        if("Lap".equals(button2.getText())){
            digitalStopWatchInstance.lap();
           
          //handle reset button  
        } else if("Reset".equals(button2.getText())){
            digitalStopWatchInstance.reset();
            handImageView.setRotate(analogStopWatchInstance.reset());
            timeLabel.setText(digitalStopWatchInstance.getTimeString());
        }
    } 
    
    private void setupAnalogStopWatch(){
      analogStopWatchInstance.setKeyFrame(new KeyFrame(Duration.millis(analogStopWatchInstance.getTickTimeInSeconds() * 1000), 
              (ActionEvent event) -> {
                updateAnalog(); }));
      analogStopWatchInstance.setTimeLine(new Timeline(analogStopWatchInstance.getKeyFrame()));
      analogStopWatchInstance.getTimeLine().setCycleCount(Animation.INDEFINITE);  
    }
    
    private void setupDigitalStopWatch() {
        digitalStopWatchInstance.setKeyFrame(new KeyFrame(Duration.millis(digitalStopWatchInstance.getTickTimeInSeconds()),
                (ActionEvent event) -> {
                    updateDigital(); }));
        digitalStopWatchInstance.setTimeLine(new Timeline(digitalStopWatchInstance.getKeyFrame()));
        digitalStopWatchInstance.getTimeLine().setCycleCount(Animation.INDEFINITE);
        
    }

    private void updateAnalog() {
        analogStopWatchInstance.calculateRotation();
        handImageView.setRotate(analogStopWatchInstance.getRotation());
    }

    private void updateDigital() {
        digitalStopWatchInstance.update();
        timeLabel.setText(digitalStopWatchInstance.getTimeString());
    }
    
}
