package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Employee;




public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addTaskCategories();
        addOrganization();
        addUsers();
        addPropertyTypes();
        addStates();
        addDistricts();
        addCities();
    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        //get task category repository
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE,
                AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_OWNER, AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent",
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Owner", "owner@this.app","owner", AuthenticationController.ROLE_OWNER);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);
    }
    private void addPropertyTypes(){
        PropertyTypeRepository propertyTypeListRepository = Repositories.getInstance().getPropertyTypeListRepository();
        propertyTypeListRepository.addPropertyType(propertyTypeListRepository.CreatePropertyType("House"));
        propertyTypeListRepository.addPropertyType(propertyTypeListRepository.CreatePropertyType("Apartment"));
        propertyTypeListRepository.addPropertyType(propertyTypeListRepository.CreatePropertyType("Land"));
    }
    private void addStates(){
        StateRepository stateList = Repositories.getInstance().getStateRepository();
        stateList.addState(stateList.CreateState("California"));
        stateList.addState(stateList.CreateState("Oregon"));
        stateList.addState(stateList.CreateState("Arizona"));
        stateList.addState(stateList.CreateState("Alaska"));
    }
    private void addDistricts(){
        DistrictRepository districtList = Repositories.getInstance().getDistrictRepository();
        districtList.addDistrict(districtList.CreateDistrict("Northem"));
        districtList.addDistrict(districtList.CreateDistrict("Eastern"));
        districtList.addDistrict(districtList.CreateDistrict("Western"));
    }
    private void addCities(){
        CityRepository cityList = Repositories.getInstance().getCityRepository();
        cityList.addCity(cityList.CreateCity("San Francisco"));
        cityList.addCity(cityList.CreateCity("Los Angeles"));
        cityList.addCity(cityList.CreateCity("Las Vegas"));
    }
    private void addRequestType(){
        RequestTypeRepository requestTypeList = Repositories.getInstance().getRequestTypeRepository();
        requestTypeList.addRequestType(requestTypeList.CreateRequestType("Sell"));
        requestTypeList.addRequestType(requestTypeList.CreateRequestType("Rent"));
    }
}
