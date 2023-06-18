package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.controllers.ListRequestControllerJavaFx;

import java.io.File;
import java.io.IOException;

public class ListRequestsGUI extends Application implements Runnable {
    private ListRequestControllerJavaFx listRequestControllerJavaFx;
    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/resources/fxml/us015.fxml").toURL());
        FXMLLoader fxmlLoader1 = new FXMLLoader(new File("src/main/resources/fxml/us015.fxml").toURL());

        Scene scene = new Scene(fxmlLoader.load());
        Pane pane = fxmlLoader1.load();

        Image iconImage = new Image(("list2.jpg"));


        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("Icon.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background = new Background(backgroundImage);
        pane.setBackground(background);


        stage.getIcons().add(iconImage);

        stage.setTitle("Projeto Integrador");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }



}
