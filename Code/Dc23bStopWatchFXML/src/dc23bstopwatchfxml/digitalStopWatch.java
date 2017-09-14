/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bstopwatchfxml;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 *
 * @author devincargill
 */
public class digitalStopWatch {
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
    private String timeString = "00:00:00";
    private String milisecondsElapsedString;
    private String secondsElapsedString;
    private String minutesElapsedString;

    public digitalStopWatch() {
     
    }

    void update(){
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
    }
    
    String getTimeString(){
        return timeString;
    }

    void start() {
        timeline.play();
    }
    
    void stop() {
        timeline.pause();
    }
    
    void reset() {
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
    }
    
    void lap() {
        System.out.println("Lap " + lapNum + ": " + timeString);
        lapNum++;
    }

    double getTickTimeInSeconds() {
        return tickTime;
    }

    void setKeyFrame(KeyFrame keyFrame) {
        this.keyFrame = keyFrame;
    }

    KeyFrame getKeyFrame() {
        return keyFrame;
    }

    void setTimeLine(Timeline timeline) {
        this.timeline = timeline;
    }

    Timeline getTimeLine() {
        return timeline;
    }
    
}
