package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    /**
     *
     */
    List<Address> addressList;

    /**
     * Create an address list
     */
    public AddressRepository() {
        addressList = new ArrayList<>();
    }

    /**
     * Method to show the AddressList
     * @return copy of the addressList
     */

    public List<Address> getAddressList() {
        return List.copyOf(this.addressList);
    }

    /**
     * Method to add an address to the list if it doesn't already exists
     * @param address address
     * @return boolean that indicates if it's necessary to add a new address to the list
     */

    public boolean registerAddress(Address address) {
        if(this.addressList.contains(address)) {
            return false;
        }
        else {
            Address newAddress = address.clone();
            this.addressList.add(newAddress);
            return true;
        }
    }

    /**
     * Method to create an Address
     * @param street
     * @param doorNumber
     * @param floorNumber
     * @param postalCode
     * @param state
     * @return
     */

    public Address createAddress(String street, String doorNumber, String floorNumber, String postalCode, State state) {
        Address address = null;
        try {
            address = new Address(street, doorNumber, floorNumber, postalCode, state);
        } catch (IllegalArgumentException e) {
            System.out.println("Attribute value is invalid.");
            System.out.println(e.getMessage());
        }
        return address;
    }

}