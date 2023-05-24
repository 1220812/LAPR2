package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;


public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addOrganization();
        addUsers();
        addRoles();
        addAddresses();
        addRequestType();
        addAvailableEquipment();
        try {
            addStores();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        addSunExposure();
        addAgency();
        addAnnouncement();
        addPropertyAdress();
        addProperty();
        addPropertyType();
        try {
            addAgent();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
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
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);


        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent",
                AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserWithRole("Client", "client@this.app", "client",
                AuthenticationController.ROLE_CLIENT);
    }

    private void addAddresses() {
        AddressRepository addressRepository = Repositories.getInstance().getAddressRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", state1, district1, city1, "12345");
        Address address2 = new Address("Street B", state2, district2, city2, "12346");
        Address address3 = new Address("Street C", state1, district3, city2, "12347");
        addressRepository.add(address1);
        addressRepository.add(address2);
        addressRepository.add(address3);


    }

    private void addPropertyAdress() {
    }

    private void addRequestType() {
        RequestTypeRepository requestTypeRepository = Repositories.getInstance().getRequestTypeRepository();
        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");
        requestTypeRepository.add(requestType1);
        requestTypeRepository.add(requestType2);
    }

    private void addAvailableEquipment() {
        AvailableEquipmentRepository availableEquipmentRepository = Repositories.getInstance().getAvailableEquipmentRepository();
        AvailableEquipment e1 = new AvailableEquipment("central heating");
        AvailableEquipment e2 = new AvailableEquipment("air conditioning");
        availableEquipmentRepository.add(e1);
        availableEquipmentRepository.add(e2);
    }

    private void addSunExposure() {
        SunExposureRepository sunExposureRepository = Repositories.getInstance().getSunExposureRepository();
        SunExposure s1 = new SunExposure("North");
        SunExposure s2 = new SunExposure("South");
        SunExposure s3 = new SunExposure("East");
        SunExposure s4 = new SunExposure("West");
        sunExposureRepository.add(s1);
        sunExposureRepository.add(s2);
        sunExposureRepository.add(s3);
        sunExposureRepository.add(s4);
    }

    private void addStores() throws CloneNotSupportedException {
        StoreRepository storeRepository = Repositories.getInstance().getStoreRepository();
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Store store3 = new Store("Holand", 3);
        storeRepository.add(store1);
        storeRepository.add(store2);
        storeRepository.add(store3);
    }

    private void addRoles() {
        RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
        Role systemAdministrator = new Role("System Administrator");
        Role agent = new Role("Agent");
        Role storeManager = new Role("Store Manager");
        Role managerNetwork = new Role("Manager Network");
        roleRepository.add(systemAdministrator);
        roleRepository.add(agent);
        roleRepository.add(storeManager);
        roleRepository.add(managerNetwork);

    }

    private void addAgency() {
        AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
        Agency agency1 = new Agency("agency1");
        Agency agency2 = new Agency("agency2");
        Agency agency3 = new Agency("agency3");
        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);
        agencyRepository.addAgency(agency3);
    }

    private void addProperty() {

    }

    private void addAnnouncement() {
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");


        PropertyAddress propertyAddress1 = new PropertyAddress("Sesame Street", "12345", state1, district1, city1);
//        Property property1 = new Property(200, 200, , 2000000,null);

        RequestType requestType1 = new RequestType("Sell");
//        Announcement announcement1 = new Announcement(property1,"2004/12/12" , "per", 5, requestType1 );
//        announcementRepository.addAnnouncement(announcement1);

    }

    private void addPropertyType() {
        PropertyTypeRepository propertyTypeRepository = Repositories.getInstance().getPropertyTypeRepository();
        PropertyType p1 = new PropertyType("Land");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("House");
        propertyTypeRepository.addPropertyType(p1);
        propertyTypeRepository.addPropertyType(p2);
        propertyTypeRepository.addPropertyType(p3);

    }

    private void addAgent() throws CloneNotSupportedException {
        AgentRepository agentRepository = Repositories.getInstance().getAgentRepository();
        AddressRepository addressRepository = Repositories.getInstance().getAddressRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", state1, district1, city1, "12345");



        TaxNumber taxNumber1 = new TaxNumber("987654321");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        Agent agent1 = new Agent("João", "987654321", "Joao@this.app", address1, taxNumber1, passportCardNumber1);
        agentRepository.add(agent1);

    }


}