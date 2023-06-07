package pt.ipp.isep.dei.esoft.project.repository;

/**
 * The type Repositories.
 */
public class Repositories {
    // From the template
    private static final Repositories instance = new Repositories();
    private final TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    private final OrganizationRepository organizationRepository = new OrganizationRepository();
    private final AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    //private final OrderRepository orderRepository = new OrderRepository();

    // Added after by the Team

    private final RoleRepository roleRepository = new RoleRepository();
    private final EmployeeRepository employeeRepository = new EmployeeRepository();

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
    private final MessageRepository messageRepository = new MessageRepository();

    private final PropertyTypeRepository propertyTypeRepository = new PropertyTypeRepository();
    private final RequestRepository requestRepository = new RequestRepository();

    private final AgentRepository agentRepository= new AgentRepository();

    private  final OwnerRepository ownerRepository= new OwnerRepository();

    private final PropertyRepository propertyRepository = new PropertyRepository();
    /**
     * The Get announcement repository.
     */
    public final AnnouncementRepository getAnnouncementRepository = new AnnouncementRepository();

    private Repositories() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Repositories getInstance() {
        return instance;
    }

    /**
     * Gets request repository.
     *
     * @return the request repository
     */
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

    /**
     * Get agent repository agent repository.
     *
     * @return the agent repository
     */
    public AgentRepository getAgentRepository(){
        return agentRepository;
    }
    /**public OrderRepository getOrderRepository() {
        return orderRepository;
    }*/

    /**
     * Gets role repository.
     *
     * @return the role repository
     */
    public RoleRepository getRoleRepository() {
        return roleRepository;
    }
    public EmployeeRepository getEmployeeRepository(){
        return employeeRepository;
    }

    /**
     * Gets organization repository.
     *
     * @return the organization repository
     */
    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    /**
     * Gets task category repository.
     *
     * @return the task category repository
     */
    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    /**
     * Gets authentication repository.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    /**
     * Get message repository message repository.
     *
     * @return the message repository
     */
    public MessageRepository getMessageRepository(){
        return messageRepository;
    }


    /**
     * Gets address repository.
     *
     * @return the address repository
     */
    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    /**
     * Method to show the agencyRepository
     *
     * @return agencyRepository agency repository
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
     * @return storeRepository store repository
     */
    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    /**
     * Method to show the stateRepository
     *
     * @return stateRepository state repository
     */
    public StateRepository getStateRepository() {
        return stateRepository;
    }

    /**
     * Gets announcement repository.
     *
     * @return the announcement repository
     */
    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    /**
     * Gets city repository.
     *
     * @return the city repository
     */
    public CityRepository getCityRepository() {
        return cityRepository;
    }

    /**
     * Gets district repository.
     *
     * @return the district repository
     */
    public DistrictRepository getDistrictRepository() {
        return districtRepository;
    }

    /**
     * Gets request type repository.
     *
     * @return the request type repository
     */
    public RequestTypeRepository getRequestTypeRepository() {
        return requestTypeRepository;
    }

    /**
     * Gets user repository.
     *
     * @return the user repository
     */
    public UserRepository getUserRepository() {
        return userRepository;
    }

    /**
     * Gets sun exposure repository.
     *
     * @return the sun exposure repository
     */
    public SunExposureRepository getSunExposureRepository() {
        return sunExposureRepository;
    }

    /**
     * Gets available equipment repository.
     *
     * @return the available equipment repository
     */
    public AvailableEquipmentRepository getAvailableEquipmentRepository() {
        return availableEquipmentRepository;
    }

    /**
     * Gets property type repository.
     *
     * @return the property type repository
     */
    public PropertyTypeRepository getPropertyTypeRepository() {
        return propertyTypeRepository;
    }

    /**
     * Gets owner repository.
     *
     * @return the owner repository
     */
    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    /**
     * Gets property repository.
     * @return the property repository
     */
    public PropertyRepository getPropertyRepository() {
        return propertyRepository;
    }
}


