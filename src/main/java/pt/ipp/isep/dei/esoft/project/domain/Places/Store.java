package pt.ipp.isep.dei.esoft.project.domain.Places;

import java.util.Objects;

public class Store {

    private String storeName;
    private int storeID;
    private int ID;
    private String designation;
    private String phoneNumber;
    private String email;
    private Address address;

    private final String STORE_NAME_POR_OMISSAO = "without name";
    private final int STORE_ID_POR_OMISSAO = 0;

    public Store(String street, String city, String district, String state, int zipCode) {

    }

    public String getStoreName() {
        return storeName;
    }

    public int getStoreID() {
        return storeID;
    }

    public Store(int ID, String designation, String phoneNumber, String email, Address address) {
        this.ID = ID;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return ID == store.ID &&
                Objects.equals(designation, store.designation) &&
                Objects.equals(phoneNumber, store.phoneNumber) &&
                Objects.equals(email, store.email) &&
                Objects.equals(address, store.address);
    }


    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }

    public String toString() {
        return "Store{" +
                "ID=" + ID +
                ", designation='" + designation + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
