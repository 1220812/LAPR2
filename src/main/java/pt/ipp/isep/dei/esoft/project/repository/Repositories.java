package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {
    // From the template
    private static final Repositories instance = new Repositories();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    // Added after by the Team

    static RoleRepository roleRepository = new RoleRepository();

    /**
     * Creating the object agencyRepository
     */
    static AgencyRepository agencyRepository = new AgencyRepository();
    /**
     * Creating the object requestRepository
     */
    RequestRepository requestRepository = new RequestRepository();

    /**
     * Creating the object stateRepository
     */
    StateRepository stateRepository = new StateRepository();

    /**
     * Creating the object cityRepository
     */
    static CityRepository cityRepository = new CityRepository();

    /**
     * Creating the object storeRepository
     */
    static StoreRepository storeRepository = new StoreRepository();

    AnnouncementRepository announcementRepository = new AnnouncementRepository();

    static DistrictRepository districtRepository = new DistrictRepository();

    PropertyTypeRepository propertyTypeRepository = new PropertyTypeRepository();

    RequestTypeRepository requestTypeRepository = new RequestTypeRepository();

    static UserRepository userRepository = new UserRepository();

    SunExposureRepository sunExposureRepository = new SunExposureRepository();

    AvailableEquipmentRepository availableEquipmentRepository = new AvailableEquipmentRepository();


    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }

    public static RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    // Added after by the Team


    /**
     * Method to show the agencyRepository
     *
     * @return agencyRepository
     */
    public static AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }


    /**
     * Method to show the requestRepository
     *
     * @return requestRepository
     */
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

    /**
     * Method to show the storeRepository
     *
     * @return storeRepository
     */

    public static StoreRepository getStoreRepository() {return storeRepository;}

    /**
     * Method to show the stateRepository
     *
     * @return stateRepository
     */
    public StateRepository getStateRepository() {return stateRepository;}

    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    public static CityRepository getCityRepository() {
        return cityRepository;
    }

    public static DistrictRepository getDistrictRepository() {
        return districtRepository;
    }

    public PropertyTypeRepository getPropertyTypeRepository() {
        return propertyTypeRepository;
    }

    public RequestTypeRepository getRequestTypeRepository() {
        return requestTypeRepository;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public SunExposureRepository getSunExposureRepository() {
        return sunExposureRepository;
    }

    public AvailableEquipmentRepository getAvailableEquipmentRepository() {
        return availableEquipmentRepository;
    }
}


