package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agency {

    /**
     * agency id
     */
    private int id;
    /**
     * agency designation
     */
    private String designation;
    /**
     * agency address
     */
    private Address address;
    /**
     * agency email address
     */
    private String emailAddress;
    /**
     * agency phone number
     */
    private int phoneNumber;
    /**
     * agency administrator
     */
    private Employee administrator;

    /**
     * This method creates an agency instance with id, designation, address, emailAddress, phoneNumber and administrator
     * @param id agency id
     * @param designation agency designation
     * @param address agency address
     * @param emailAddress agency email address
     * @param phoneNumber agency phone number
     * @param administrator agency administrator
     */

    public Agency(int id, String designation, Address address, String emailAddress, int phoneNumber, Employee administrator){
        this.id = id;
        this.designation = designation;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.administrator = administrator;
    }

    /**
     * Method to compare the attributes of the current object with those of another object
     * @param o object that will be compared with
     * @return boolean
     */
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Agency)){
            return false;
        }
        Agency that = (Agency) o;
        return id == that.id;
    }

    /**
     * Method to show the ID
     * @return id
     */

    public int getID(){return id;}

    /**
     * Method to show the designation
     * @return designation
     */

    public String getDesignation() {return designation;}

    /**
     * Method to return a hash code for the object in order to ensure that this hash code will not collide with the others
     * @return hash code
     */

    public int hashCode() { return Objects.hash(id); }
    /**
     * Method to show the Agency characteristics
     * @return String with te Agency characteristics
     */

    public String toString(){
        return String.format("Agency nº%d%n" +
                        "Name: %s%n" +
                        "Location: %s%n" +
                        "Email Address: %s%n" +
                        "Phone Number: %s%n"
                , this.id, this.designation, this.address, this.emailAddress, this.phoneNumber);
    }

    /**
     * This method creates a new instance of the agency object and initializes its attributes with the exact same values of the original object
     * @return a clone of the agency object
     */

    public Agency clone(){ return new Agency(this.id, this.designation, this.address, this.emailAddress, this.phoneNumber, this.administrator); }
}