/**
 * Filename: Main.java
 * 
 * Project: p5-MayFirstJavaFX
 * 
 * Authors: Zhengyi Chen
 *
 * Semester: Spring 2019
 * 
 * Course: CS400
 * 
 * Due Date: April-12-19
 * 
 * Credits:
 * 
 * Bugs:
 */
package application;

import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * This class represents a graphical user interface of an JavaFX application
 * 
 * @author chenzhengyi
 *
 */
public class Main extends Application {// Main is a subclass of Application
  @Override
  public void start(Stage primaryStage) {
    try {
      BorderPane root = new BorderPane(); // Border pane layout for this GUI

      // set up the scene
      Scene scene = new Scene(root, 500, 500); // a window with 500w x 500h size
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setTitle("Zhengyi's First JavaFX");
      primaryStage.show();

      // set top
      VBox vBox = new VBox();// creating a vertical box for top
      // creating two labels for the top VBox
      Label greetingLabel = new Label("Hello World!"); // import javafx rather than java.aw
      Label label2 = new Label("CS400 My First JavaFX");
      vBox.setSpacing(5);
      // adding the two labels
      vBox.getChildren().add(label2);
      vBox.getChildren().add(greetingLabel);
      root.setTop(vBox); // set the box at top


      // set bottom
      Button button1 = new Button("Done");
      // creating a event for closing the application
      EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
          primaryStage.close();
        }
      };
      button1.setOnMouseClicked(event); // application will be closed upon clicking the button
      root.setBottom(button1);

      // set left
      // creating a Observable List for the combo box
      ObservableList<String> comboLs = FXCollections.observableArrayList(); // combo list
      // adding three options
      comboLs.add("Option 1");
      comboLs.add("Option 2");
      comboLs.add("Option 3");
      ComboBox cb = new ComboBox(comboLs);// creating the combo box
      root.setLeft(cb); // set the combo box in left pane


      // set right
      VBox rightbox = new VBox();// creating another vertical box
      Label label3 = new Label("What is your favorite part of college life?");
      label3.setMaxWidth(100);
      label3.setWrapText(true);
      // creating a text field
      TextField tf = new TextField();
      tf.setMaxWidth(100);
      tf.setMinHeight(50);
      // put those two elements into the vertical box
      rightbox.setSpacing(5);
      rightbox.getChildren().add(label3);
      rightbox.getChildren().add(tf);
      root.setRight(rightbox);


      // set center
      // set a ImageView in center
      FileInputStream inputIm = new FileInputStream("psb.jpeg");
      Image img = new Image(inputIm, 300, 350, true, true); // size 300X350, keep original ration,
                                                            // smooth scaling
      ImageView imgVw = new ImageView(img);
      root.setCenter(imgVw);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args); // a method in Application class (Application.lauch()
                  // lauch() will call start();
  }
}
