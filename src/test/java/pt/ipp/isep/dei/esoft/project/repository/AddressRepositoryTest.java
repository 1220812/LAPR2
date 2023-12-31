package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Address repository test.
 */
class AddressRepositoryTest {
    /**
     * The Address repository.
     */
    AddressRepository addressRepository = Repositories.getInstance().getAddressRepository();


    /**
     * Gets address list.
     */
    @Test
    void getAddressList() {
        Address address = new Address("123 Main St", 1,1, "12345", new State("California"), new District("Eastern"), new City("Los Angeles"));
        Address address1 = new Address("123 Main St", 1,1, "12345", new State("California"), new District("Eastern"), new City("Los Angeles"));

        addressRepository.add(address);
        addressRepository.add(address1);

        List<Address> addressList = addressRepository.getAddressList();

        Assertions.assertEquals(2, addressList.size());
        Assertions.assertEquals(address, addressList.get(0));
        Assertions.assertEquals(address1, addressList.get(1));
    }
}