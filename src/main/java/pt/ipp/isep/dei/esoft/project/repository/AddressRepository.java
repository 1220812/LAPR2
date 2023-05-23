package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.PropertyAddress;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    List<Address> AddressList;

    public AddressRepository(){
        AddressList = new ArrayList<>();
    }

    public boolean add(Address address){
        if (address == null) throw new IllegalArgumentException("Impossible address");
        if (AddressList.contains(address)) throw new IllegalArgumentException("Already exist");
        return AddressList.add(address);
    }


    public List<Address> getAddressList(){
        return AddressList;
    }

}
