/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstloginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author devincargill
 */
public class MyFirstLoginForm extends Application {
    
    public String title = "My JavaFX Login";
    public int width = 600;
    public int height = 400;
    
    private String fontStyle = "Comic Sans MS";
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle(title);
        
        //object of the GridPane class ad assigning it to grid var
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text sceneTitle = new Text("Welcome Please Login");
        sceneTitle.setFont(Font.font(fontStyle, FontWeight.BOLD, 26));
        grid.add(sceneTitle, 0, 0);
        
        Label userName = new Label("Username: ");
        userName.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        grid.add(userName, 0 , 1);
        
        TextField userNameTextField = new TextField();
        grid.add(userNameTextField, 1, 1);
        
        Label password = new Label("Password: ");
        password.setFont(Font.font(fontStyle, FontWeight.NORMAL, 18));
        grid.add(password, 0, 2);
        
        PasswordField passwordTextField = new PasswordField();
        grid.add(passwordTextField, 1, 2);
        
        //for testing the grid
        //grid.setGridLinesVisible(true);

        Button button = new Button("Sign In");
        HBox hboxForButton = new HBox(10);
        hboxForButton.setAlignment(Pos.BOTTOM_RIGHT);
        //must add child to hbox for it to work
        hboxForButton.getChildren().add(button);
        grid.add(hboxForButton, 1, 4);
        
        final Text actionTarget = new Text();
        GridPane.setColumnIndex(actionTarget, 1);
        GridPane.setRowIndex(actionTarget, 6);
        grid.getChildren().add(actionTarget);
        //2 lines above are same as line below
        //grid.add(actionTarget, 1, 6);
        
        button.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
                
                System.out.println("Username = " + userNameTextField.getText());
                System.out.println("Password = " + passwordTextField.getText());
                
                if(userNameTextField.getText().length() <1){
                    System.out.println("ERROR: Username must be at least 1 character");
                }
                
                if(passwordTextField.getText().length() < 1){
                    System.out.println("ERROR: Password must be at least 1 character");
                }
            }
        });
        
        //object of scene class and assigning to scene var
        Scene scene = new Scene(grid, width, height);
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
