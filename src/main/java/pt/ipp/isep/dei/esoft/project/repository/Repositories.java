package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {
    // From the template
    private static final Repositories instance = new Repositories();
    private final TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    private final OrganizationRepository organizationRepository = new OrganizationRepository();
    private final AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    // Added after by the Team

    private final RoleRepository roleRepository = new RoleRepository();

    /**
     * Creating the object agencyRepository
     */
    private final AgencyRepository agencyRepository = new AgencyRepository();
    /**
     * Creating the object requestRepository
     */
//    private final RequestRepository requestRepository = new RequestRepository();

    /**
     * Creating the object stateRepository
     */
    private final StateRepository stateRepository = new StateRepository();

    /**
     * Creating the object cityRepository
     */
    private final CityRepository cityRepository = new CityRepository();

    /**
     * Creating the object storeRepository
     */
    private final StoreRepository storeRepository = new StoreRepository();

    private final AnnouncementRepository announcementRepository = new AnnouncementRepository();

    private final DistrictRepository districtRepository = new DistrictRepository();

    private final RequestTypeRepository requestTypeRepository = new RequestTypeRepository();

    private final UserRepository userRepository = new UserRepository();

    private final SunExposureRepository sunExposureRepository = new SunExposureRepository();

    private final AvailableEquipmentRepository availableEquipmentRepository = new AvailableEquipmentRepository();

    private final AddressRepository addressRepository = new AddressRepository();

    private final PropertyTypeRepository propertyTypeRepository = new PropertyTypeRepository();
    private final RequestRepository requestRepository = new RequestRepository();

    private final AgentRepository agentRepository= new AgentRepository();

    private  final OwnerRepository ownerRepository= new OwnerRepository();
    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }

    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

    public AgentRepository getAgentRepository(){
        return agentRepository;
    }

    public RoleRepository getRoleRepository() {
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



    public AddressRepository getAddressRepository() {
        return addressRepository;
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
     * Method to show the requestRepository
     *
     * @return requestRepository
     */
//    public RequestRepository getRequestRepository() {
//        return requestRepository;
//    }

    /**
     * Method to show the storeRepository
     *
     * @return storeRepository
     */

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    /**
     * Method to show the stateRepository
     *
     * @return stateRepository
     */
    public StateRepository getStateRepository() {
        return stateRepository;
    }

    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    public CityRepository getCityRepository() {
        return cityRepository;
    }

    public DistrictRepository getDistrictRepository() {
        return districtRepository;
    }

    public RequestTypeRepository getRequestTypeRepository() {
        return requestTypeRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SunExposureRepository getSunExposureRepository() {
        return sunExposureRepository;
    }

    public AvailableEquipmentRepository getAvailableEquipmentRepository() {
        return availableEquipmentRepository;
    }

    public PropertyTypeRepository getPropertyTypeRepository() {
        return propertyTypeRepository;
    }

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }
}


