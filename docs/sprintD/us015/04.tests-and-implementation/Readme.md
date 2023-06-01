# US 012 - To see a list of announcement

# 4. Tests

**Test 1:** Check that the method getAgencyList() returns a list of agencys who contais announcements.

	void getAgencyList() {
        Email emailagency = new Email("agency1@gmail.com");
        Agency agency1 = new Agency("agency1", "lalala", emailagency, 931111111);
        Email emailagency1 = new Email("agency2@gmail.com");
        Agency agency2 = new Agency("agency1", "lalala", emailagency, 931111111);

        ArrayList<Agency> expected = new ArrayList<>();
        expected.add(agency1);
        expected.add(agency2);
        Repositories.getInstance().getAgenciesRepository().addAgency(agency1);
        Repositories.getInstance().getAgenciesRepository().addAgency(agency2);


        ArrayList<Agency> result = Repositories.getInstance().getAgenciesRepository().getAgencyList();
        assertTrue(result.containsAll(expected));
    }


**Test 2:** Check that the method getAgenciesRepository() is not null, and returns a agency.

	@Test
    void getAgenciesRepository() {
        Repositories repositories1 = Repositories.getInstance();
        AgenciesRepository agenciesRepository1=repositories1.getAgenciesRepository();
        assertNotNull(agenciesRepository1);
    }

**Test 3:** Check that the method addAnnoucement() it is working, and conquentely a agency can have announcements

        @Test
        void addAnnouncement() {
        User agent1 = new User("Gabriel", 123, 123, new Email("tiago@tiago.com"), 132, "Rua" , Role.AGENT,  "Rua");
        Agency agency = new Agency("Designation", "Location", new Email("email@email.com"), 123);
        Land land = new Land(agent1, null, 100, 20, "Porto");
        Request request = new Request(RequestTypes.RENT, PropertyType.HOUSE, land, agency, agent1, 10000.0);
        Announcement announcement1 = new Announcement(request, "12/12/2012",123, ComissionType.FIXED);
        agency.addAnnouncement(announcement1);
        List <Announcement> announcementList = agency.getListOfAnnoucement();
        assertTrue(announcementList.contains(announcement1));
    }

# 5. Construction (Implementation)



## Class getAnnouncementListController

```java
 public ArrayList<Announcement> getList(String sortingTag) {

        ArrayList<Announcement> list = new ArrayList<>();

        for (Agency agency : getAgenciesRepository().getAgencyList()) {
        for (Announcement ann : agency.getListOfAnnoucement(sortingTag)) {
        list.add(ann);
        }
        }

        return (list);
        }
```


## Class Announcement

```java
  public Announcement(Request request, String publicationDate, double comission, ComissionType comissionType) {
        this.id++;
        this.request = request;
        this.publicationDate = publicationDate;
        this.comission = comission;
        this.comissionType = comissionType;
        }
```

# 6. Integration and Demo

* On the main menu it is available a option that ables the unregistered user to see a list of annoucements

* Some agents are bootstrapped while system starts to able them to create announcements on the respective boostraped agency.


# 7. Observations


