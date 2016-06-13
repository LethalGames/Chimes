/**
 * Created by EMGo on 6/10/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800);
        scene.setFill(Color.LIGHTGRAY);

        Button btn1 = new Button();
        btn1.setText("Test");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Text t1 = new Text(500,50,"I'm Working");

                root.getChildren().add(t1);
            }
        });
        root.getChildren().add(btn1);

        Calendar cal = new Calendar();
        Button sched = new Button();
        sched.setText("Today's Schedule");
        sched.relocate(0,25);
        sched.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Text tSched = new Text(500,50,cal.getTodaysScedual(Time.getDate())); //Date not found

                root.getChildren().add(tSched);
            }
        });
        root.getChildren().add(sched);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
