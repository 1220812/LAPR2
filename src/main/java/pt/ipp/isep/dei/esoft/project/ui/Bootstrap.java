package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;


public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addOrganization();
        addUsers();
        addPropertyTypes();
        addStates();
        addDistricts();
        addCities();
        addRequestType();
        addAvailableEquipment();
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

        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);
    }

    private void addPropertyTypes() {
        PropertyTypeRepository propertyTypeListRepository = Repositories.getInstance().getPropertyTypeListRepository();
        propertyTypeListRepository.addPropertyType(propertyTypeListRepository.CreatePropertyType("House"));
        propertyTypeListRepository.addPropertyType(propertyTypeListRepository.CreatePropertyType("Apartment"));
        propertyTypeListRepository.addPropertyType(propertyTypeListRepository.CreatePropertyType("Land"));
    }

    private void addStates() {
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        Repositories.getInstance().getStateRepository().addState(state1);
        Repositories.getInstance().getStateRepository().addState(state2);
        Repositories.getInstance().getStateRepository().addState(state3);
    }

    private void addDistricts() {
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        Repositories.getInstance().getDistrictRepository().addDistrict(district1);
        Repositories.getInstance().getDistrictRepository().addDistrict(district2);
        Repositories.getInstance().getDistrictRepository().addDistrict(district3);
    }

    private void addCities() {
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Repositories.getInstance().getCityRepository().addCity(city1);
        Repositories.getInstance().getCityRepository().addCity(city2);
    }

    private void addRequestType() {
        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");
        Repositories.getInstance().getRequestTypeRepository().add(requestType1);
        Repositories.getInstance().getRequestTypeRepository().add(requestType2);
    }
    private void addAvailableEquipment() {
        AvailableEquipment e1 = new AvailableEquipment("central heating");
        AvailableEquipment e2 = new AvailableEquipment("air conditioning");
        Repositories.getInstance().getAvailableEquipmentRepository().add(e1);
        Repositories.getInstance().getAvailableEquipmentRepository().add(e2);
    }
}
