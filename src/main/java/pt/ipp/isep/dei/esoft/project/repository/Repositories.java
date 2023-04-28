package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    private pt.ipp.isep.dei.esoft.project.repository.roleRepository roleRepository;
    private pt.ipp.isep.dei.esoft.project.repository.storeRepository storeRepository;
    private pt.ipp.isep.dei.esoft.project.repository.agencyRepository agencyRepository;

    AnnouncementsRepository announcementsRepository = new AnnouncementsRepository();


    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }
    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }
    public roleRepository roleRepository() {
        return roleRepository;
    }
    public storeRepository storeRepository(){
        return storeRepository;
    }
    public agencyRepository agencyRepository(){
        return agencyRepository;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public AnnouncementsRepository getAnnouncementsRepository() {
        return announcementsRepository;
    }

}
