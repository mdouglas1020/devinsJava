/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor;

import javafx.animation.KeyFrame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.util.Duration;

/**
 *
 * @author devincargill
 */
public class AnalogStopWatch {
    
    private Timeline timeline;
    private KeyFrame keyframe;
    
    private StackPane rootContainer;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    
    private String dialImageName = "clockface.png";
    private String handImageName = "hand.png";
    
    private double secondsElapsed = 0;
    private double tickTimeInSeconds = 0.01; //change this to change resolution    private double rotation;
    private double angleDeltaPerSecond = 6.0;
    
           
    
    public AnalogStopWatch(){
        setupUI();
        setupTimer();
    }
    
    private void setupUI(){
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        rootContainer.getChildren().addAll(dialImageView, handImageView);  
    }
    
    private void setupTimer(){
        keyframe = new KeyFrame(Duration.millis(1000), (ActionEvent event) ->{
            update();
        });
        
    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSecond;
        handImageView.setRotate(rotation);
    }
    
    // return type is Parent so that any type of JavaFX container
    // can be returned. StackPane (.. GridPane, AnchorPane, and ... etc.)
    // all inhert from Parent
    public Parent getRootContainer(){
        return rootContainer;
    }
    
    public Double getWidth(){
        if(dialImage != null) 
            return dialImage.getWidth();
        else
            return 0.0;
    }
    
    public Double getHeight(){
        if(dialImage != null) 
            return dialImage.getHeight();
        else
            return 0.0;
    }
    
    
}
