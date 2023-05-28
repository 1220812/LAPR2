package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

/**
 * Show Legacy Data Controller.
 */
public class ShowLegacyDataController {

    /**
     * Repositories attribute.
     */
    Repositories repositories;
    /**
     * Load Information From File attribute.
     */
  /**  LoadInformationFromFile loadInformationFromFile;
    /**
     * Advertisement Repository attribute.
     */
    AnnouncementRepository announcementRepository;
    /**
     * Store Repository attribute.
     */
    StoreRepository storeRepository;
    /**
     * State Repository attribute.
     */
    StateRepository stateRepository;
    /**
     * District Repository attribute.
     */
    DistrictRepository districtRepository;
    /**
     * City Repository attribute.
     */
    CityRepository cityRepository;
    /**
     * Person Repository attribute.
     */
    AgentRepository agentRepository;}

    /**
     * Contructor.
     */

  /**  public ImportInformationController() {
        this.repositories = Repositories.getInstance();
        this.announcementRepository = repositories.getAnnouncementRepository();
        this.storeRepository = repositories.getStoreRepository();
        this.stateRepository = repositories.getStateRepository();
        this.districtRepository = repositories.getDistrictRepository();
        this.cityRepository = repositories.getCityRepository();
        this.agentRepository = repositories.getAgentRepository();
        this.loadInformationFromFile = new LoadInformationFromFile();
    }

    /**
     * This method imports information from a file.
     * @param path path of the file
     */
  /**  public void importInformationFromFile(String path) {
        loadInformationFromFile.loadInformationFromFile(path, announcementRepository, storeRepository, stateRepository,
                districtRepository, cityRepository, agentRepository);
    }
}
*/
