package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {
    // From the template
    private static final Repositories instance = new Repositories();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
<<<<<<< HEAD
    private pt.ipp.isep.dei.esoft.project.repository.roleRepository roleRepository;
    private StoreRepository storeRepository;
    private pt.ipp.isep.dei.esoft.project.repository.agencyRepository agencyRepository;
=======
>>>>>>> 568a46155f1102bfde63cc913206d8a3986fc30f

    // Added after by the Team

    static RoleRepository roleRepository = new RoleRepository();

    /**
     * Creating the object agencyRepository
     */
    AgencyRepository agencyRepository = new AgencyRepository();
    /**
     * Creating the object addressRepository
     */
    AddressRepository addressRepository = new AddressRepository();
    /**
     * Creating the object requestRepository
     */
    RequestRepository requestRepository = new RequestRepository();

    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }
    public static RoleRepository getRoleRepository(){
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

<<<<<<< HEAD
    public StoreRepository storeRepository() {
        return storeRepository;
    }

    public agencyRepository agencyRepository() {
=======
    /**
     * Method to show the agencyRepository
     * @return agencyRepository
     */
    public AgencyRepository getAgencyRepository() {
>>>>>>> 568a46155f1102bfde63cc913206d8a3986fc30f
        return agencyRepository;
    }

    /**
     * Method to show the addressRepository
     * @return addressRepository
     */
    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

<<<<<<< HEAD
    public StoreRepository getStoreRepository() {
        return storeRepository;
=======
    /**
     * Method to show the requestRepository
     * @return requestRepository
     */
    public RequestRepository getRequestRepository() {
        return requestRepository;
>>>>>>> 568a46155f1102bfde63cc913206d8a3986fc30f
    }
}



