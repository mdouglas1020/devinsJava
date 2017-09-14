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
public class analogStopWatch {
    private final double tickTimeInSeconds = 0.01;
    private final double angleDeltaPerSeconds = 6.0;
    private double secondsElapsed = 0;
    private double rotation;
    private Timeline timeline;
    private KeyFrame keyFrame;

    
    public analogStopWatch() {

    }
    
    double reset(){
        secondsElapsed = 0;
        return 0.0;
    }
    
    void calculateRotation() {
        secondsElapsed += tickTimeInSeconds;
        rotation = secondsElapsed * angleDeltaPerSeconds;
    }

    double getTickTimeInSeconds() {
        return tickTimeInSeconds;
    }

    void setKeyFrame(KeyFrame keyFrame) {
        this.keyFrame = keyFrame;
    }

    KeyFrame getKeyFrame() {
        return keyFrame;
    }

    Timeline getTimeLine() {        
        return timeline;
    
    }

    void setTimeLine(Timeline timeline) {        
        this.timeline = timeline;
    }

    double getRotation() {
        return rotation;
    }
}
