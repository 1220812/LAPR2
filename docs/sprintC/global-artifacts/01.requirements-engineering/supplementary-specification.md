# Supplementary Specification (FURPS+)

## Functionality

* Authentication: Most of the sensitive information must only be available by authorized users.

* Communication: Alerts regarding relevant occurrences should be sent to the user.

* Error management: Error messages should be clear and give information to the user regarding what caused it and how to possibly avoid it.

* Event management: Users should be able to create, delete and edit events they have permissions to (i.e. setting up an advertising)

* Licensing: The application should be fully licensed to be used legally.

* Localisation: The application should be available in English as its current use is in the USA Real Estate Market but more languages should be implemented as it progresses to be used in other countries.

* Online help: There must be FAQs, tutorials and manuals available for download online regarding the use of the application.

* Persistence: The persistence should be reliable, all information should be secure and easily retrievable.

* Printing: The application information should be easily printable by the user.

* Reporting: Reporting isn't exactly a must in the application, but some aspects of the system should be available to be generated.

* Scheduling: Users should be notified in case of a relevant response/notification about the state of an advertisement for example.

* Security: Register and login systems: Secure password system (passwords should be over seven alphanumeric characters, including three capital letters and two digits).

* Transaction management: All transactions should be tracked and recorded, to ensure they're safe and fair.

* Workflow: Workflow should be efficient to all users, so it must be customizable enough to any users needs.

## Usability 

* It will implement unit tests for all methods (except for Input/Output methods);
* The software should be user-friendly and easy to navigate;
* The software should have a clean and professional user interface;
* The application must support the English language.


## Reliability

* The system must run 7 days a week, 24 hours a day;
* The system must have as few failures as possible and if they do happen, they should be resolved as quickly as possible;
* The software should be reliable and stable, with minimal downtime;
* The software should be secure and protect confidential information.

## Performance

* The system must respond quickly to all operations;
* The application should consume little memory and CPU;
* The software should be able to handle a large number of transactions and users.

## Supportability

* The app will support the English language;
* It should be easy to maintain and to update the system;
* The software should have good documentation and customer support;
* The software should be compatible with future updates;
* The software application should also be conceived having in mind that it can be further commercialized to other companies.

### Design Constraints

* The programming language will be Java;
* The application will be developed using the IntelliJ IDE and the graphical interface is to be developed in JavaFX 11;
* The unit tests should be implemented using the JUnit 5 framework;
* The JaCoCo plugin will be used to generate the coverage report.

### Implementation Constraints

* The application will be developed in Java language using the IntelliJ IDE or NetBeans;
* All those who wish to use the application must be authenticated with a password (seven alphanumeric characters, including three capital letters and two digits);
* The app must support English language;
* The graphical interface is to be developed in JavaFX 11;
* The development team must implement unit tests for all methods, except for methods that implement Input/Output operations;
* The unit tests should be implemented using the JUnit 5 framework;
* The JaCoCo plugin will be used to generate the coverage report;
* During the system development, the team must adopt best practices for identifying requirements, and for OO software analysis and design;
* The team must adopt recognized coding standards.

### Interface Constraints

* The application graphical interface is to be developed in JavaFX 11.

### Physical Constraints

* The system must use a database to store and manage data, with appropriate backups and redundancy measures in place;
* The application will be optimized for fast loading times.