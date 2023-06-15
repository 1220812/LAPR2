package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OwnerRepositoryTest {

    @Test
    void addOwner() {
        OwnerRepository ownerRepository = new OwnerRepository();
        Owner owner = new Owner("john","912345678","john@gmial.com",new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        ownerRepository.addOwner(owner);
        assertTrue(ownerRepository.getOwnerList().contains(owner));
    }

    @Test
    void getOwnerList() {
        OwnerRepository ownerRepository = new OwnerRepository();
        Owner owner = new Owner("john","912345678","john@gmial.com",new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        ownerRepository.addOwner(owner);
        List<Owner> owners = ownerRepository.getOwnerList();
        assertTrue(owners.contains(owner));
    }

    @Test
    void add() throws CloneNotSupportedException {
        OwnerRepository ownerRepository = new OwnerRepository();
        Owner owner = new Owner("john","912345678","john@gmial.com",new TaxNumber("123456789"), new PassportCardNumber("12345678"));
        ownerRepository.addOwner(owner);
        List<Owner> newOwner = ownerRepository.add(owner);
        assertTrue(newOwner.contains(owner));
    }
}