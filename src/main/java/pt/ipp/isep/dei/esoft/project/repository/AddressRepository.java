package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Address repository.
 */
public class AddressRepository implements Serializable {
    /**
     * The Address list.
     */
    List<Address> AddressList;

    /**
     * Instantiates a new Address repository.
     */
    public AddressRepository(){
        AddressList = new ArrayList<>();
    }

    /**
     * Add boolean.
     *
     * @param address the address
     * @return the boolean
     */
    public boolean add(Address address){
        if (address == null) throw new IllegalArgumentException("Impossible address");
        if (AddressList.contains(address)) throw new IllegalArgumentException("Already exist");
        return AddressList.add(address);
    }


    /**
     * Get address list list.
     *
     * @return the list
     */
    public List<Address> getAddressList(){
        return AddressList;
    }

}
