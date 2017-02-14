import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ady on 14/02/2017.
 */
public class GUIMain extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Button moreThanOneDay = new Button("Fjern feil ved flerdagers");
        Button relayFix = new Button("Regn ut løpstid fra starttid og jaktstart");

        moreThanOneDay.setLayoutX(105);
        moreThanOneDay.setLayoutY(130);
        relayFix.setLayoutX(75);
        relayFix.setLayoutY(100);

        moreThanOneDay.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(primaryStage);

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            catch(IOException a){}

        });

        pane.getChildren().addAll(relayFix,moreThanOneDay);

        primaryStage.setScene(new Scene(pane,400,300));
        primaryStage.show();
    }
}
