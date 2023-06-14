package pt.ipp.isep.dei.esoft.project.ui.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.ListRequestsController;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
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
    private ListView<Request> lView;
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
    private List<Request> list;
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

    @FXML
//    void switchToScene2(ActionEvent event) throws IOException {
//        content = new ArrayList<>();
//        fxmlLoader = new FXMLLoader(new File("src/main/resources/fxml/us015.2.fxml").toURL());
//        List<Request> list;
//
//
//        if (start == null || end == null) {
//            lView.getItems().add("You must choose the dates before");
//        } else if (!controller.checkVisitTime(start,end)) {
//            System.out.println("Invalid date");
//        } else {
//            list = controller.getSortedVisitRequestList(controller.getAgentList(), start, end);
//            for (int i = 0; i < list.size(); i++) {
//                content.add(list.get(i).toString());
//            }
//        }
//
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.show();
//    }

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

    public void showRequests(ActionEvent event) throws IOException {
//        try {
//            System.out.println(Request.getRequestsSorted(RequestList));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        List<Request> requestsAgent = new ArrayList<>();
        List<Request> requests = controller.getRequests();
        start = getBeginDate();
        end = getEndDate();
        lView.getItems().clear();
        Agent loggedInAgent = controller.getCurrentAgent();
        for (int i = 0; i < requests.size(); i++) {
            if ((loggedInAgent.getEmailAddress().equals(requests.get(i).getAgent().getEmailAddress())) && ((requests.get(i).getRequestDate().isAfter(start)) && (requests.get(i).getRequestDate().isBefore(end)))) {
                requestsAgent.add(requests.get(i));
            }
        }
        List<Request> sortedList = controller.getRequestsSorted(requestsAgent);
        for (int i = 0; i < sortedList.size(); i++) {
            lView.getItems().add(sortedList.get(i));
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
