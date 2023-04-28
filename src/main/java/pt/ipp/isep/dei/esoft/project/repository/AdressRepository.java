package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Places.Address;

import pt.ipp.isep.dei.esoft.project.domain.Places.State;

import java.util.List;

public class AdressRepository {

    private List<Address> addressList;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void registerAddress(Address address) {
        addressList.add(address);
    }

}
