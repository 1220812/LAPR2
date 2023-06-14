package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class ListRequestsGUI extends Application implements Runnable {
    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/resources/fxml/us015.fxml").toURL());
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("US015");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
