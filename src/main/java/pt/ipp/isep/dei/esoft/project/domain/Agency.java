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
    private PropertyAddress propertyAddress;
    /**
     * agency email address
     */
    private String emailAddress;
    /**
     * agency phone number
     */
    private String phoneNumber;
    /**
     * agency administrator
     */

    private static final int DEFAULT_ID = 0;

    private static final String DEFAULT_DESIGNATION = "no agency designation";

    private static final PropertyAddress DEFAULT_ADRESS = new PropertyAddress();

    private static final String DEFAULT_EMAILADRESS = "no agency email";

    private static final String DEFAULT_PHONENUMBER = "000-000-000";


    /**
     * This method creates an agency instance with id, designation, address, emailAddress, phoneNumber and administrator
     * @param id agency id
     * @param designation agency designation
     * @param propertyAddress agency address
     * @param emailAddress agency email address
     * @param phoneNumber agency phone number
     */

    public Agency(int id, String designation, PropertyAddress propertyAddress, String emailAddress, String phoneNumber){
        this.id = id;
        this.designation = designation;
        this.propertyAddress = propertyAddress;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Agency(){
        designation = DEFAULT_DESIGNATION;
        propertyAddress = DEFAULT_ADRESS;
        phoneNumber = DEFAULT_PHONENUMBER;
        emailAddress = DEFAULT_EMAILADRESS;
        id = DEFAULT_ID;
    }
    public Agency(int id, String designation){
        this.id = id;
        this.designation = designation;
    }
     public Agency(String designation){
        this.designation=designation;
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

    @Override
    public String toString() {
        return designation;
    }
    public String toString2(){
        return "Agency{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", address=" + propertyAddress +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    /**
     * This method creates a new instance of the agency object and initializes its attributes with the exact same values of the original object
     * @return a clone of the agency object
     */

    public Agency clone(){ return new Agency(this.id, this.designation, this.propertyAddress, this.emailAddress, this.phoneNumber); }

    public PropertyAddress getAddress() {
        return propertyAddress;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setAddress(PropertyAddress propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}