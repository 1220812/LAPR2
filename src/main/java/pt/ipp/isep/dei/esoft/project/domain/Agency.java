package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agency {

    private final int id;
    private String designation;
    private Address address;
    private String emailAddress;
    private int phoneNumber;
    private Employee administrator;

    public Agency(int id, String designation){
        this.id = id;
        this.designation = designation;
    }

    public Agency(int id, String designation, Address address, String emailAddress, int phoneNumber, Employee administrator){
        this.id = id;
        this.designation = designation;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.administrator = administrator;
    }

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

    public int getID(){return id;}

    public String getDesignation() {return designation;}

    public int hashCode() { return Objects.hash(id); }

    public String toString(){
        return String.format("Agency nº%d%n" +
                        "Name: %s%n" +
                        "Location: %s%n" +
                        "Email Address: %s%n" +
                        "Phone Number: %s%n"
                , this.id, this.designation, this.address, this.emailAddress, this.phoneNumber);
    }

    public Agency clone(){ return new Agency(this.id, this.designation, this.address, this.emailAddress, this.phoneNumber, this.administrator); }
}