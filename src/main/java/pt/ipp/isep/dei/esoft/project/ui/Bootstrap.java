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
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
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
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);

        List<Photographs> photo = new ArrayList<>();

        Store store1 = new Store("Company", 1);
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        Agent agent1 = new Agent("João", "987654321", "Joao@this.app", address1, taxNumber1, passportCardNumber1);

        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");

        Address propertyAddress1 = new Address("Sesame Street", "12345", state1, district1, city1);
        Property property1 = new Property(200.3, 200.6, address3, 2000000, photo, store1, agent1,requestType1);
        Property property2 = new Property(100.0, 150.0, address1, 3450000, photo, store1, agent1,requestType2);


        Announcement announcement1 = new Announcement(property1, "2004/12/12", "per", 5, requestType1);
        Announcement announcement2 =new Announcement(property2,"2020/04/04","per", 5, requestType2);
        announcementRepository.addAnnouncement(announcement1);
        announcementRepository.addAnnouncement(announcement2);

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
        Order order1 = new Order("property 1", 10);
        Order order2 = new Order("property 2", 18);
        Order order3 = new Order("property 3", 5);
        Order order4 = new Order("property 4",3);
        ArrayList<Double> emptyListOfOrders = new ArrayList<>();
        ArrayList<Double> offers = new ArrayList<>();
        offers.add(125.5);
        offers.add(200.0);
        offers.add(150.0);
        offers.add(300.0);
        offers.add(500.0);
        offers.add(100.5);
        offers.add(400.0);
        offers.add(350.0);
        offers.add(750.0);
        order1.setAmount(offers);
        order2.setAmount(offers);
        order3.setAmount(offers);
        order4.setAmount(emptyListOfOrders);
        rep.setOrdersList(order1);
        rep.setOrdersList(order2);
        rep.setOrdersList(order3);
        rep.setOrdersList(order4);
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
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);
        Property property1 = new Property(10, 100, address1, 10000, photos1, requestType1);
        Property property2 = new Property(20, 200, address2, 20000, photos2, requestType2);
        Property property3 = new Property(30, 300, address3, 30000, photos3, requestType3);
        LocalDate requestDate1 = null;
        LocalDate requestDate2 = null;
        LocalDate requestDate3 = null;
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
        Request request1 = new Request(property1, requestDate1, propertyType1, agent1, store1, owner1);
        Request request2 = new Request(property2, requestDate2, propertyType2, agent2, store2, owner2);
        Request request3 = new Request(property3, requestDate3, propertyType3, agent2, store3, owner3);
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
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", "12345", state1, district1, city1);
        Address address2 = new Address("Street B", "12346",state2, district2, city2);
        Address address3 = new Address("Street C", "12347",state1, district3, city2);
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        Agent agent1 = new Agent("João", "987654321", "Joao@this.app", address1, taxNumber1, passportCardNumber1);
        agentRepository.add(agent1);
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        PassportCardNumber passport2 = new PassportCardNumber("12345678");
        Agent agent2 = new Agent("Agent", "987654321", "agent@this.app", address2, taxNumber2, passport2);
        agentRepository.add(agent2);
    }
}