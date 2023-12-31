package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
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
        try {
            addOrder();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        addMessage();
        try {
            addClient();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
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
        authenticationRepository.addUserRole(AuthenticationController.ROLE_STORE_MANAGER, AuthenticationController.ROLE_STORE_MANAGER);
        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Agent", "pedro@gmail.com", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd", AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole("Client", "client@this.app", "client", AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserWithRole("Network Manager", "networkmanager@this.app", "network", AuthenticationController.ROLE_NETWORK_MANAGER);
        authenticationRepository.addUserWithRole("Store Manager", "storemanager@this.app", "store", AuthenticationController.ROLE_STORE_MANAGER);
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
        Address address1 = new Address("Street A", 1, 2, "12345", state3, district1, city1);
        Address address2 = new Address("Street B", 3, 4, "12346", state2, district2, city2);
        Address address3 = new Address("Street C", 5, 6, "12347", state1, district3, city2);
        addressRepository.add(address1);
        addressRepository.add(address2);
        addressRepository.add(address3);
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
        State state1 = new State("California");
        State state2 = new State("Nevada");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", 1, 2, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 3, 4, "12346", state2, district2, city2);
        Address address3 = new Address("Street C", 5, 6, "12347", state1, district3, city2);
        Agency agency1 = new Agency(1, "agency1", address1, "agency1@this.app", "123456789");
        Agency agency2 = new Agency(2, "agency2", address2, "agency2@this.app", "987654321");
        Agency agency3 = new Agency(3, "agency3", address3, "agency3@this.app", "195451235");
        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);
        agencyRepository.addAgency(agency3);
    }

    private void addAnnouncement() {
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", 4, 6, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 1, 3, "12346", state2, district2, city2);
        List<Photographs> photo = new ArrayList<>();
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        TaxNumber taxNumber = new TaxNumber("123456789");
        PassportCardNumber passportCardNumber3 = new PassportCardNumber("98755432");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        PassportCardNumber passportCardNumber2 = new PassportCardNumber("23456789");
        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");
        LocalDate requestDate1 = LocalDate.of(2020, 10, 10);
        LocalDate requestDate2 = LocalDate.of(2022, 3, 2);
        PropertyType p1 = new PropertyType("Land");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("House");
        Property property1 = new Property(500, 5, address1, p1, photo);
        Property property2 = new Property(345, 12, address2, p2, photo);
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Agency agency1 = new Agency(1, "agency1", address1, "agency1@this.app", "123456789");
        Agency agency2 = new Agency(2, "agency2", address2, "agency2@this.app", "987654321");
        Agent agent1 = new Agent("Joao", "joao@gmail.com", "918734521", passportCardNumber1, taxNumber1, address1, new Role("Agent"), agency1, store1, "joao");
        Agent agent2 = new Agent("agent", "agent@this.app", "915734521", passportCardNumber2, taxNumber2, address2, new Role("Agent"), agency2, store2, "pedro");
        Owner owner1 = new Owner("Maria", "912345678", "maria@gmail.com", address1, taxNumber1, passportCardNumber1);
        Owner owner2 = new Owner("Madalena", "912945678", "madalena@gmail.com", address2, taxNumber2, passportCardNumber2);
        Owner owner3 = new Owner("Manuel", "912545698", "manuel@gmail.com", address2, taxNumber, passportCardNumber3);

        Announcement announcement1 = new Announcement(property1, requestDate1, "per", 5, requestType1, agent1, 200000, owner1, store1);
        Announcement announcement2 = new Announcement(property2, requestDate2, "per", 5, requestType2, agent2, 300000, owner2, store2);
        Announcement announcement3 = new Announcement(property2, requestDate1, "per", 5, requestType2, agent2, 2450000, owner3, store2);
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
        Address address1 = new Address("Street A", 4, 6, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 1, 3, "12346", state2, district2, city2);
        Address address3 = new Address("Street C", 1, 2, "12347", state1, district3, city2);
        Owner owner1 = new Owner("Joao", "987654321", "joao@this.app", address1, taxNumber1, passportCardNumber1);
        ownerRepository.add(owner1);
    }

    private void addOrder() throws CloneNotSupportedException {
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();
        State state1 = new State("California");
        State state2 = new State("Nevada");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", 4, 6, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 1, 3, "12346", state2, district2, city2);
        List<Photographs> photo = new ArrayList<>();
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        TaxNumber taxNumber = new TaxNumber("123456789");
        PassportCardNumber passportCardNumber3 = new PassportCardNumber("98755432");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        PassportCardNumber passportCardNumber2 = new PassportCardNumber("23456789");
        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");
        LocalDate requestDate1 = LocalDate.of(2020, 10, 10);
        LocalDate requestDate2 = LocalDate.of(2022, 3, 2);
        PropertyType p1 = new PropertyType("Land");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("House");
        Property property1 = new Property(500, 5, address1, p1, photo);
        Property property2 = new Property(345, 12, address2, p2, photo);
        Property property = new Property(400, 8, address2, p3, photo);
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Agency agency1 = new Agency(1, "agency1", address1, "agency1@this.app", "123456789");
        Agency agency2 = new Agency(2, "agency2", address2, "agency2@this.app", "987654321");
        Agent agent1 = new Agent("Joao", "joao@gmail.com", "918734521", passportCardNumber1, taxNumber1, address1, new Role("Agent"), agency1, store1, "joao");
        Agent agent2 = new Agent("agent", "agent@this.app", "915734521", passportCardNumber2, taxNumber2, address2, new Role("Agent"), agency2, store2, "pedro");
        Owner owner1 = new Owner("Maria", "912345678", "maria@gmail.com", address1, taxNumber1, passportCardNumber1);
        Owner owner2 = new Owner("Madalena", "912945678", "madalena@gmail.com", address2, taxNumber2, passportCardNumber2);
        Owner owner3 = new Owner("Manuel", "912545698", "manuel@gmail.com", address2, taxNumber, passportCardNumber3);

        Announcement announcement1 = new Announcement(property1, requestDate1, "per", 5, requestType1, agent1, 200000, owner1, store1);
        Announcement announcement2 = new Announcement(property2, requestDate2, "per", 5, requestType2, agent2, 300000, owner2, store2);
        Announcement announcement3 = new Announcement(property2, requestDate1, "per", 5, requestType2, agent2, 2450000, owner3, store2);
        Announcement announcement = new Announcement(property, requestDate1, "per", 5, requestType2, agent2, 2350000, owner3, store2);

        Order order1 = new Order(announcement1, 123000, agent1.getEmailAddress());
        Order order3 = new Order(announcement1, 124000, agent1.getEmailAddress());
        Order order = new Order(announcement2, 124000, agent2.getEmailAddress());
        Order order2 = new Order(announcement2, 100000, agent2.getEmailAddress());
        Order order4 = new Order(announcement1, 100000, agent2.getEmailAddress());
        Order order5 = new Order(announcement3, 100000, agent2.getEmailAddress());
        Order order6 = new Order(announcement, 100000, agent2.getEmailAddress());
        order4.setStatus(Status.ACCEPTED);
        order5.setStatus(Status.ACCEPTED);
        order6.setStatus(Status.ACCEPTED);
        orderRepository.addOrder(order1);
        orderRepository.addOrder(order2);
        orderRepository.addOrder(order3);
        orderRepository.addOrder(order);
        orderRepository.addOrder(order4);
        orderRepository.addOrder(order5);
        orderRepository.addOrder(order6);
    }

    private void addMessage() {
        MessageRepository messageRepository = Repositories.getInstance().getMessageRepository();

        State state1 = new State("California");
        State state2 = new State("Nevada");
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", 4, 6, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 1, 3, "12346", state2, district2, city2);
        List<Photographs> photo = new ArrayList<>();
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        TaxNumber taxNumber = new TaxNumber("123456789");
        PassportCardNumber passportCardNumber3 = new PassportCardNumber("98755432");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        PassportCardNumber passportCardNumber2 = new PassportCardNumber("23456789");
        RequestType requestType1 = new RequestType("Sell");
        RequestType requestType2 = new RequestType("Rent");
        LocalDate requestDate1 = LocalDate.of(2020, 10, 10);
        LocalDate requestDate2 = LocalDate.of(2022, 3, 2);
        PropertyType p1 = new PropertyType("Land");
        PropertyType p2 = new PropertyType("Apartment");
        PropertyType p3 = new PropertyType("House");
        Property property1 = new Property(500, 5, address1, p1, photo);
        Property property2 = new Property(345, 12, address2, p2, photo);
        Store store1 = new Store("Company", 1);
        Store store2 = new Store("Galo", 2);
        Agency agency1 = new Agency(1, "agency1", address1, "agency1@this.app", "123456789");
        Agency agency2 = new Agency(2, "agency2", address2, "agency2@this.app", "987654321");
        Agent agent1 = new Agent("Pedro", "pedro@gmail.com", "918734521", passportCardNumber1, taxNumber1, address1, new Role("Agent"), agency1, store1, "agent");
        Agent agent2 = new Agent("Agent", "987654321", "agent@this.app", address2, taxNumber2, passportCardNumber2);
        Owner owner1 = new Owner("Maria", "912345678", "maria@gmail.com", address1, taxNumber1, passportCardNumber1);
        Owner owner2 = new Owner("Madalena", "912945678", "madalena@gmail.com", address2, taxNumber2, passportCardNumber2);
        Owner owner3 = new Owner("Manuel", "912545698", "manuel@gmail.com", address2, taxNumber, passportCardNumber3);

        Announcement announcement1 = new Announcement(property1, requestDate1, "per", 5, requestType1, agent1, 200000, owner1, store1);
        Announcement announcement2 = new Announcement(property2, requestDate2, "per", 5, requestType2, agent2, 300000, owner2, store2);
        Announcement announcement3 = new Announcement(property2, requestDate1, "per", 5, requestType2, agent2, 2450000, owner3, store2);


        Client client1 = new Client("Joao", "987654321", "client@this.app", address1, taxNumber1, passportCardNumber1);

        LocalDateTime newVisitStartTime1 = LocalDateTime.of(2024, 1, 1, 0,0);
        LocalDateTime newVisitEndTime1 = LocalDateTime.of(2024, 1, 1, 0, 1);

        LocalDateTime newVisitStartTime2 = LocalDateTime.of(2025, 1, 1, 0,0);
        LocalDateTime newVisitEndTime2 = LocalDateTime.of(2025, 1, 1, 0, 1);

        LocalDateTime newVisitStartTime3 = LocalDateTime.of(2026, 1, 1, 0,0);
        LocalDateTime newVisitEndTime3 = LocalDateTime.of(2026, 1, 1, 0, 1);

        Message message1 = new Message(client1,announcement1, newVisitStartTime1, newVisitEndTime1);
        Message message2= new Message(client1,announcement2, newVisitStartTime3, newVisitEndTime3);
        Message message3 = new Message(client1,announcement3, newVisitStartTime2, newVisitEndTime2);
        messageRepository.add(message1);
        messageRepository.add(message2);
        messageRepository.add(message3);


    }


    public void addRequests() {
        RequestRepository requestRepository = Repositories.getInstance().getRequestRepository();
        List<Photographs> photoList1 = new ArrayList<>();
        List<Photographs> photoList2 = new ArrayList<>();
        List<Photographs> photoList3 = new ArrayList<>();
        Photographs photo1 = new Photographs("AAA");
        Photographs photo2 = new Photographs("bbb");
        Photographs photo3 = new Photographs("CCC");
        photoList1.add(photo1);
        photoList2.add(photo2);
        photoList3.add(photo3);
        List<AvailableEquipment> availableEquipmentList1 = new ArrayList<>();
        List<AvailableEquipment> availableEquipmentList2 = new ArrayList<>();
        List<AvailableEquipment> availableEquipmentList3 = new ArrayList<>();
        AvailableEquipment availableEquipment1 = new AvailableEquipment("AAA");
        AvailableEquipment availableEquipment2 = new AvailableEquipment("bbb");
        AvailableEquipment availableEquipment3 = new AvailableEquipment("CCC");
        availableEquipmentList1.add(availableEquipment1);
        availableEquipmentList2.add(availableEquipment2);
        availableEquipmentList3.add(availableEquipment3);
        RequestType requestType1 = new RequestType("Sale", 0);
        RequestType requestType2 = new RequestType("Sale", 0);
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
        Address address1 = new Address("Street A", 4, 6, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 1, 3, "12346", state2, district2, city2);
        Address address3 = new Address("Street C", 1, 2, "12347", state1, district3, city2);
        Property property1 = new Property(10000, 10, address1, propertyType1, photoList1);
        Property property2 = new House(address2, 1023, 345, propertyType2, 12, 4, 1, true, new SunExposure("North"), true, photoList2, availableEquipmentList1);
        Property property3 = new Residence(address3, 12023, 3425, propertyType3, 132, 34, 31, photoList2, availableEquipmentList1);
        LocalDate requestDate1 = LocalDate.of(2020, 1, 1);
        LocalDate requestDate2 = LocalDate.of(2021, 2, 2);
        LocalDate requestDate3 = LocalDate.of(2000, 3, 3);
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
        Agent agent1 = new Agent("Toniteco", "987654321", "pedro@gmail.com", address1, taxNumber1, passport1);
        Agent agent2 = new Agent("Agent", "987654321", "agent@this.app", address2, taxNumber2, passport2);
        Request request1 = new Request(property1, requestDate1, agent1, owner1, 1000, requestType1, store1);
        Request request2 = new Request(property2, requestDate2, agent2, owner2, 2000, requestType2, store2);
        Request request3 = new Request(property3, requestDate3, agent2, owner3, 3000, requestType3, store3);
        requestRepository.addRequest(request3);
        requestRepository.addRequest(request1);
        requestRepository.addRequest(request2);
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
        District district1 = new District("Northem");
        District district2 = new District("Eastern");
        District district3 = new District("Western");
        City city1 = new City("Los Angeles");
        City city2 = new City("New York");
        Address address1 = new Address("Street A", 1, 2, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 3, 4, "12346", state2, district2, city2);
        Address address3 = new Address("Street C", 5, 6, "12347", state1, district3, city2);
        Agency agency1 = new Agency(1, "agency1", address1, "agency1@this.app", "123456789");
        Agency agency2 = new Agency(2, "agency2", address2, "agency2@this.app", "987654321");
        Agency agency3 = new Agency(3, "agency3", address3, "agency3@this.app", "195451235");
        Role systemAdministrator = new Role("System Administrator");
        Role agent = new Role("Agent");
        Role storeManager = new Role("Store Manager");
        Role managerNetwork = new Role("Manager Network");
        TaxNumber taxNumber1 = new TaxNumber("987654321");
        PassportCardNumber passportCardNumber1 = new PassportCardNumber("98765432");
        PassportCardNumber passportCardNumber2 = new PassportCardNumber("98765432");
        Agent agent1 = new Agent("Pedro", "pedro@gmail.com", "987654321", passportCardNumber1, taxNumber1, address1, agent, agency1, store1, "agent");
        agentRepository.add(agent1);
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        PassportCardNumber passport2 = new PassportCardNumber("12345678");
        Agent agent2 = new Agent("Agent", "agent@this.app","988654321",passportCardNumber2,taxNumber2, address2,agent,agency2,store2,"agent");
        agentRepository.add(agent2);
    }
    private void addClient() throws CloneNotSupportedException {
        ClientRepository clientRepository = Repositories.getInstance().getClientRepository();
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
        Address address1 = new Address("Street A", 4, 6, "12345", state1, district1, city1);
        Address address2 = new Address("Street B", 1, 3, "12346", state2, district2, city2);
        Address address3 = new Address("Street C", 1, 2, "12347", state1, district3, city2);
        Client client1 = new Client("Joao", "987654321", "client@this.app", address1, taxNumber1, passportCardNumber1);
        clientRepository.add(client1);
    }
}