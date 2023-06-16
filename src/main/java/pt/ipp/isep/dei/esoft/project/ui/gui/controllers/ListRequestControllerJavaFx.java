package pt.ipp.isep.dei.esoft.project.ui.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.ListRequestsController;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListRequestControllerJavaFx implements Initializable {
    private static List<String> content = new ArrayList<>();
    @FXML
    private FXMLLoader fxmlLoader;
    @FXML
    private ListView<Message> lView;
    @FXML
    private Button cancelButton;
    @FXML
    private Button continueButton;
    @FXML
    private DatePicker endDate;
    @FXML
    private DatePicker startDate;
    private LocalDate start;
    private LocalDate end;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private List<Message> list;
    private ListRequestsController controller = new ListRequestsController();

    @FXML
    void cancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void readEndDate(ActionEvent event) {
        this.end = endDate.getValue();
    }

    @FXML
    void readStartDate(ActionEvent event) {
        this.start = startDate.getValue();
    }


    public void switchToScene1(ActionEvent actionEvent) throws IOException {
        fxmlLoader = new FXMLLoader(new File("src/main/resources/fxml/us015.fxml").toURL());
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void showMessages(ActionEvent event) throws IOException {
        List<Message> requestsAgent = new ArrayList<>();
        List<Message> messageList = controller.getMessages();
        start = getBeginDate();
        end = getEndDate();
        lView.getItems().clear();
        Agent loggedInAgent = controller.getCurrentAgent();
        for (int i = 0; i < messageList.size(); i++) {
            if ((loggedInAgent.getEmailAddress().equals(messageList.get(i).getAgent().getEmailAddress())) && ((messageList.get(i).getNewVisitStartTime().isAfter(start.atStartOfDay())) && (messageList.get(i).getNewVisitEndTime().isBefore(end.atStartOfDay())))) {
                requestsAgent.add(messageList.get(i));
            }
        }
        List<Message> sortedList = controller.getMessagesSorted(requestsAgent);


        if (sortedList.isEmpty()) {
            System.out.println(("There is no booking associated with this agent"));
        } else {
            for (int i = 0; i < sortedList.size(); i++) {
                lView.getItems().add(sortedList.get(i));
            }
        }
    }


    public LocalDate getBeginDate() {
        LocalDate date = startDate.getValue();
        return date;
    }

    public LocalDate getEndDate() {
        LocalDate date = endDate.getValue();
        return date;
    }
}

