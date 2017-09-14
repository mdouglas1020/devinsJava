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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles
 */
public class AnalogStopWatch {
    
    public boolean analogRunning = false;
    private double tickTimeInSeconds = 0.01;
    private final double angleDeltaPerSeconds = 6.0;
    private double secondsElapsed = 0;
    private double rotation;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private StackPane rootContainer;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private final String dialImageName = "clockface.png";
    private final String handImageName = "hand.png";
    
    
    public AnalogStopWatch() {
        setupUI();
        setupTimer(tickTimeInSeconds);
    }
    
    public Parent getRootContainer() {
        return rootContainer;
    }
    
    public void reset(){
        handImageView.setRotate(0);
        secondsElapsed = 0;
    }
    
    public void setTickTimeInSeconds(Double tickTime) {
        this.tickTimeInSeconds = tickTime;
        setupTimer(tickTime);
    }
    
    public final void setupTimer(double tickTime) {
        keyFrame = new KeyFrame(Duration.millis(tickTime * 1000), (ActionEvent event) -> {
            update(tickTime);
        });
        
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    private void setupUI() {
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();    
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        rootContainer.getChildren().addAll(dialImageView, handImageView);
    }
    
    public void start() {
        timeline.play();
        analogRunning = true;
    }
    
    public void stop(){
        timeline.pause();
        analogRunning = false;
    }
    
    private void update(double tickTime) {
        secondsElapsed += tickTime;
        rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);
    }
}
