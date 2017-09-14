/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author devincargill
 */
public class DigitalStopWatch {
    
    public boolean digitalRunning = false;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private final double tickTime = 1.0;
    private int miliSecondsElapsed;
    private int secondsElapsed;
    private int minutesElapsed;
    private int milisecondCounter = 0;
    private int secondCounter = 0;
    private int minuteCounter = 0;
    private int lapNum = 1;
    private StackPane rootContainer;
    private Label timeLabel;
    private String timeString;
    private String milisecondsElapsedString;
    private String secondsElapsedString;
    private String minutesElapsedString;

    public DigitalStopWatch() {
        setupTimer();
        setupUI();
    }

    private void setupUI() {
        rootContainer = new StackPane();
        timeLabel = new Label("00:00:00");
        rootContainer.getChildren().add(timeLabel);
    }

    public final void setupTimer() {
            miliSecondsElapsed = 0;
            secondsElapsed = 0;
            minutesElapsed = 0;
            keyFrame = new KeyFrame(Duration.millis(tickTime), (ActionEvent event) -> {
                update();
            });

            timeline = new Timeline(keyFrame);
            timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void update(){
        secondCounter += tickTime;
        minuteCounter += tickTime;
        milisecondCounter += tickTime;
        
        miliSecondsElapsed = milisecondCounter / 10;
        secondsElapsed = secondCounter / 1000;
        minutesElapsed = minuteCounter / 60000;
        
        if(milisecondCounter == 1000){
            milisecondCounter = 0;
        }
        
        if(secondCounter == 60000){
            secondCounter = 0;
        }

        if(miliSecondsElapsed > 99) {
            miliSecondsElapsed = 0;
          }
        
        if(miliSecondsElapsed < 10) {
            milisecondsElapsedString = "0" + Integer.toString(miliSecondsElapsed);
        }  else {
            milisecondsElapsedString = Integer.toString(miliSecondsElapsed);
           }
        
        if(secondsElapsed < 10) {
            secondsElapsedString = "0" + Integer.toString(secondsElapsed);  
        } else {
            secondsElapsedString = Integer.toString(secondsElapsed);
          }
        
        if(minutesElapsed < 10){
           minutesElapsedString = "0" + Integer.toString(minutesElapsed); 
        } else {
            minutesElapsedString = Integer.toString(minutesElapsed);
          }
        
        
        timeString = minutesElapsedString + ":" + secondsElapsedString + ":" + milisecondsElapsedString;
        timeLabel.setText(timeString);
    }
    
    public Parent getRootContainer(){
        return rootContainer;
    }

    public void start() {
        timeline.play();
        digitalRunning = true;
    }
    
    public void stop() {
        timeline.pause();
        digitalRunning = false;
    }
    
    public void reset() {
        secondCounter = 0;
        minuteCounter = 0;
        milisecondCounter = 0;
        miliSecondsElapsed = 0;
        secondsElapsed = 0;
        minutesElapsed = 0;
        lapNum = 1;
        
        milisecondsElapsedString = "0";
        secondsElapsedString = "0";
        minutesElapsedString = "0";
        
        timeString = "00:00:00";
        timeLabel.setText(timeString);
    }
    
    public void lap() {
        System.out.println("Lap " + lapNum + ": " + timeString);
        lapNum++;
    }
    
}