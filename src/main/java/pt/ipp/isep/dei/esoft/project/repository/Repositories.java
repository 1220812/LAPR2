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

    /**
     * Method to show the agencyRepository
     * @return agencyRepository
     */
    public AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }

    /**
     * Method to show the addressRepository
     * @return addressRepository
     */
    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    /**
     * Method to show the requestRepository
     * @return requestRepository
     */
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }
}



