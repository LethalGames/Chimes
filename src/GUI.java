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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import static java.lang.Integer.parseInt;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label block = new Label("Block:");
        grid.add(block, 0, 1);

        TextField blockField = new TextField();
        grid.add(blockField, 1, 1);

        Label time = new Label("Time Before End:");
        grid.add(time, 0, 2);

        TextField timeField = new TextField();
        grid.add(timeField, 1, 2);

        Calendar cal = new Calendar();
        Button sched = new Button();
        sched.setText("Today's Schedule");
        grid.add(sched, 2, 2);
        sched.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Text tSched = new Text(500,50,cal.getTodaysScedual(Time.getDate())); //Date not found

                grid.add(tSched, 2, 3);
            }
        });

        Button submit = new Button("Submit");
        grid.add(submit, 3, 2);
        Label label = new Label();
        grid.add(label, 3, 3);
        Chimes chime = new Chimes();
        System.out.println("test");
        new ChimeLoop(chime).start();
        System.out.println("test");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((blockField.getText() != null && !blockField.getText().isEmpty() && timeField.getText() != null
                            && !timeField.getText().isEmpty())) {
                    int period = parseInt(blockField.getText());
                    int timeEnd = parseInt(timeField.getText());
                    if(period > 0 && period < 8 && timeEnd > -1 && timeEnd < 54) {
                        label.setText("All set!");
                        chime.addAlarm(period, timeEnd);
                    }
                    else{
                        label.setText("Bad num!");
                    }
                } else {
                    label.setText("It's empty!");
                }
            }
        });

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
