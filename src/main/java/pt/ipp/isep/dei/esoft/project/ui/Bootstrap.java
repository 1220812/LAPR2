package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
        addRequests();
        addAnnouncement();
        addPropertyAdress();
        addProperty();
        addPropertyType();
        try {
            addAgent();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        try {
            addOwner();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        try{
            addOrder();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
        addMessage();
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
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_OWNER, AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_NETWORK_MANAGER, AuthenticationController.ROLE_NETWORK_MANAGER);
        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd", AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole("Client", "client@this.app", "client", AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserWithRole("Network Manager", "networkManager@this.app", "network", AuthenticationController.ROLE_NETWORK_MANAGER);
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
        Address address1 = new Address("Street A", "12345", state3, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);
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
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", "12345", state3, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        List<Photographs> photo = new ArrayList<>();
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        PassportCardNumber passportCardNumber2= new PassportCardNumber("23456789");
        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");
        LocalDate requestDate1 = LocalDate.of(2020,10,10);
        LocalDate requestDate2 = LocalDate.of(2022,3,2);
        Property property1 = new Property(500, 5, address1, 100000,photo);
        Property property2 = new Property(345, 12, address2, 200000,photo);
        PropertyType p1 = new PropertyType("Land");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("House");
        Agency agency1 = new Agency("agency1");
        Agency agency2 = new Agency("agency2");
        Agency agency3 = new Agency("agency3");
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Store store3 = new Store("Holand", 3);


        Agent agent1 = new Agent("Joao","joao@gmail.com","918734521",passportCardNumber1,taxNumber1,address1,new Role("Agent"),agency1,store1,"joao");
        Agent agent2 = new Agent("Pedro","pedro@gmail.com","915734521",passportCardNumber2,taxNumber2,address2,new Role("Agent"),agency2,store2,"pedro");

        Announcement announcement1 = new Announcement(property1, requestDate1, "per", 5, requestType1,p1,agent1);
        Announcement announcement2 =new Announcement(property2,requestDate2,"per", 5, requestType2, p2,agent1);
        Announcement announcement3 =new Announcement(property2,requestDate1,"per", 5, requestType2, p3,agent2);
        announcementRepository.addAnnouncement(announcement1);
        announcementRepository.addAnnouncement(announcement2);
        announcementRepository.addAnnouncement(announcement3);

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

    private void addOwner() throws CloneNotSupportedException {
        OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");

        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);
        Owner owner1 = new Owner("Joao", "987654321", "joao@this.app", address1, taxNumber1, passportCardNumber1);
        ownerRepository.add(owner1);
    }

    private void addOrder() throws CloneNotSupportedException {
        OrderRepository rep = Repositories.getInstance().getOrderRepository();
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);

        List<Photographs> photo = new ArrayList<>();

        Store store1 = new Store("Company", 1);
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        TaxNumber taxNumber2 = new TaxNumber("987765432");
        Agency agency = new Agency("agency1");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        Agent agent1 = new Agent("Joao","joao@gmail.com","918734521",passportCardNumber1,taxNumber1,address1,new Role("Agent"),agency,store1,"joao");
        PassportCardNumber passportCardNumber2 = new PassportCardNumber("98765433");
        Agent agent2 = new Agent("Pedro","pedro@gmail.com","915734521",passportCardNumber2,taxNumber2,address2,new Role("Agent"),agency,store1,"pedro");

        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");

        LocalDate requestDate1 = LocalDate.of(2022,10,2);
        LocalDate requestDate2 = LocalDate.of(2022,1,8);

        Property property1 = new Property("3",110000,address3,1000, 3);
        Property property = new Property("1", 1200000, address1, 1000, 12 );
        Property property3 = new Property("2", 139000, address2, 1000, 12 );

        User client1 = new User("João Silva", "joaosilva@gmail.com","1213","912312231");
        User client2 = new User("Pedro Silva", "pedrosilva@gmail.com","1413","919312231");

        PropertyType p1 = new PropertyType("Land");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("House");


        Announcement announcement1 = new Announcement(property1, requestDate1, "per", 5, requestType1,p1,agent1);
        Announcement announcement3 =new Announcement(property,requestDate1,"per", 5, requestType2, p3, agent1);
        Announcement announcement = new Announcement(property3,requestDate1,"per", 5, requestType2, p3, agent2);

        announcementRepository.addAnnouncement(announcement1);
        announcementRepository.addAnnouncement(announcement3);
        announcementRepository.addAnnouncement(announcement);

        Order order1 = new Order(announcement1, 123000,client1, requestDate1);
        Order order3 = new Order(announcement, 124000,client2, requestDate2);
        Order order = new Order(announcement3, 124000,client2, requestDate2);
        rep.saveOrder(order1);
        rep.saveOrder(order3);
        rep.saveOrder(order);
    }
    private void addMessage(){
        MessageRepository messageRepository =Repositories.getInstance().getMessageRepository();
        Message message1=new Message(null, null);
        messageRepository.add(message1);
    }

    private void addRequests() {
        RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();

        List<Photographs> photos1 = null;
        List<Photographs> photos2 = null;
        List<Photographs> photos3 = null;
        RequestType requestType1 = new RequestType("Sale", 1);
        RequestType requestType2 = new RequestType("Sale", 2);
        RequestType requestType3 = new RequestType("Rent", 3);
        PropertyType propertyType1 = new PropertyType("Land");
        PropertyType propertyType2 = new PropertyType("Apartment");
        PropertyType propertyType3 = new PropertyType("House");
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        RequestType sell = new RequestType("Sell");
        RequestType rent = new RequestType("Rent");
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);
        Property property1 = new Property(10000, 10, address1, 10000, photos1);
        Property property2 = new House(address2,1000, 12,3,2,2,true,true,true, new SunExposure("North"),true,1000000,photos2);
        Property property3 = new Residence(address3, 300, 2, 3,2,1,1800000, photos3,true, false);
        LocalDate requestDate1 = LocalDate.of(2021, 1, 1);
        LocalDate requestDate2 = LocalDate.of(2021, 2, 2);
        LocalDate requestDate3 = LocalDate.of(2021, 3, 3);
        TaxNumber taxNumber1 = new TaxNumber("123456789");
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        TaxNumber taxNumber3 = new TaxNumber("195451235");
        PassportCardNumber passport1 = new PassportCardNumber("12345678");
        PassportCardNumber passport2 = new PassportCardNumber("12345678");
        PassportCardNumber passport3 = new PassportCardNumber("67894224");
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Store store3 = new Store("Holand", 3);
        Owner owner1 = new Owner("Martim", "123456789", "martim@this.app", address1, taxNumber1, passport1);
        Owner owner2 = new Owner("Toni", "456787655", "toni@this.app", address2, taxNumber2, passport2);
        Owner owner3 = new Owner("Guilherma", "214522558", "guilherma@this.app", address3, taxNumber3, passport3);
        Agent agent1 = new Agent("Toniteco", "987654321", "pedro@this.app", address1, taxNumber1, passport1);
        Agent agent2 = new Agent("Agent", "987654321", "agent@this.app", address2, taxNumber2, passport2);
        Agent agent3 = new Agent("Sofia", "741852963", "sofia@this.app", address3, taxNumber3, passport3);
        Request request1 = new Request(property1, requestDate1, propertyType1, agent1, store1, owner1, 12,10020000,rent);
        Request request2 = new Request(property2, requestDate2, propertyType2, agent2, store2, owner2, 13, 100000,rent);
        Request request3 = new Request(property3, requestDate3, propertyType3, agent2, store3, owner3, 120000);
        requestRepository.addRequest(request1);
        requestRepository.addRequest(request2);
        requestRepository.addRequest(request3);
    }

    private void addAgent() throws CloneNotSupportedException {
        AgentRepository agentRepository = Repositories.getInstance().getAgentRepository();
        AddressRepository addressRepository = Repositories.getInstance().getAddressRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        State state3 = new State("Arizona");
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Store store3 = new Store("Holand", 3);
        Agency agency1 = new Agency("agency1");
        Agency agency2 = new Agency("agency2");
        Agency agency3 = new Agency("agency3");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);
        Role systemAdministrator = new Role("System Administrator");
        Role agent = new Role("Agent");
        Role storeManager = new Role("Store Manager");
        Role managerNetwork = new Role("Manager Network");
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        PassportCardNumber passportCardNumber2 = new PassportCardNumber("98765432");
        Agent agent1 = new Agent("Pedro", "agent@this.app","987654321",passportCardNumber1,taxNumber1,address1,agent,agency1,store1,"Pedro");
        agentRepository.add(agent1);
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        PassportCardNumber passport2 = new PassportCardNumber("12345678");
        Agent agent2 = new Agent("Bárbara", "agent@this.app","912345674",passportCardNumber2,taxNumber2,address3,agent,agency2,store3,"BIO");
        agentRepository.add(agent2);
    }
}