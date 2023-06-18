package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Show Legacy Data Controller.
 */
public class ShowLegacyDataController {
  /**
   * The File information.
   */
  FileInformation fileInformation = new FileInformation();

  /**
   * This method imports the information from the file.
   *
   * @param path path of the file
   * @throws IOException                if the file is not found
   * @throws CloneNotSupportedException if the file is not found
   */
  public void importInformationFromFile(String path) throws IOException, CloneNotSupportedException {
    fileInformation.importFile(path);
  }

  /**
   * Clear data.
   */
  public void clearData() {
    Repositories repositories = Repositories.getInstance();
    repositories.getAnnouncementRepository().getAnnouncementsList().clear();
    repositories.getAnnouncementRepository().getFinishedAnnouncementsList().clear();
    repositories.getStoreRepository().getStoreList().clear();
    repositories.getOrderRepository().getOrders().clear();
    repositories.getOrderRepository().getAcceptedOrders().clear();
    repositories.getOrderRepository().getDeclinedOrders().clear();
  }
}
