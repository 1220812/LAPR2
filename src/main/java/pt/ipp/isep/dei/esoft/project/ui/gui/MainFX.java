package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

import static javafx.application.Application.launch;

public class MainFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        Stage stage = new Stage();

        Text text = new Text();
        text.setText("HELLOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        text.setX(200);
        text.setY(200);

        root.getChildren().add(text);

        stage.setScene(scene);
        stage.show();


        primaryStage.setTitle("Projeto Integrador");

        Image icon = new Image(new FileInputStream("src/main/resources/icon.jpg"));
        primaryStage.getIcons().add(icon);

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setResizable(false);

        primaryStage.setFullScreen(true);

        primaryStage.setFullScreenExitHint("Press q for not fullscreen");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
