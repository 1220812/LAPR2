package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {
    // From the template
    private static final Repositories instance = new Repositories();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    UserRepository userRepository = new UserRepository();

    // Added after by the Team

    static RoleRepository roleRepository = new RoleRepository();

    /**
     * Creating the object agencyRepository
     */
    AgencyRepository agencyRepository = new AgencyRepository();
    /**
     * Creating the object addressRepository
     */
//    AddressRepository addressRepository = new AddressRepository();
    /**
     * Creating the object requestRepository
     */
    RequestRepository requestRepository = new RequestRepository();

    /**
     * Creating the object localizationRepository
     */
    LocalizationRepository localizationRepository = new LocalizationRepository();

    /**
     * Creating the object stateRepository
     */
//    StateRepository stateRepository = new StateRepository();

    /**
     * Creating the object cityRepository
     */
    CityRepository cityRepository = new CityRepository();

    /**
     * Creating the object storeRepository
     */
    StoreRepository storeRepository = new StoreRepository();

    StateRepository stateRepository = new StateRepository();



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


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method to show the agencyRepository
     *
     * @return agencyRepository
     */
    public AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }

    /**
     * Method to show the addressRepository
     *
     * @return addressRepository
     */
//    public AddressRepository getAddressRepository() {
//        return addressRepository;
//    }


    /**
     * Method to show the requestRepository
     *
     * @return requestRepository
     */
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

    /**
     * Method to show the localizationRepository
     *
     * @return localizationRepository
     */
    public LocalizationRepository getLocationRepository(){return localizationRepository;}

    /**
     * Method to show the storeRepository
     *
     * @return storeRepository
     */

    public StoreRepository getStoreRepository() {return storeRepository;}

    /**
     * Method to show the stateRepository
     *
     * @return stateRepository
     */
    public StateRepository getStateRepository() {return stateRepository;}
}


