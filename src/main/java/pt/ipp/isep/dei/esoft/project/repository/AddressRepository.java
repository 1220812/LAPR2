package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.PropertyAddress;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    List<Address> propertyAddressList;

    public AddressRepository(){
        propertyAddressList = new ArrayList<>();
    }

    public boolean add(Address address){
        if (address == null) throw new IllegalArgumentException("Impossible address");
        if (propertyAddressList.contains(address)) throw new IllegalArgumentException("Already exist");
        return propertyAddressList.add(address);
    }


    public List<Address> getAddressList(){
        return propertyAddressList;
    }

}
