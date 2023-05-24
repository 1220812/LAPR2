package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Owner;
import pt.ipp.isep.dei.esoft.project.domain.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerRepository {

    private List<Owner> ownerList = new ArrayList<>();


    public void addOwner(Owner owner) {
        if (validateOwner(owner))
            ownerList.add(owner);
    }


    public List<Owner> getOwnerList() {
        return List.copyOf(this.ownerList);
    }

//    public Store createOwner(String name,int phoneNumber, String emailAddress, int taxNumber, int passportCardNumber, Address address) {
//        Store store = new Store (name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
//        addOwner(owner);
//        return owner;
//    }

    public List<Owner> add(Owner owner) throws CloneNotSupportedException {

        ownerList.add(owner);

        Optional<Owner> newOwner = Optional.empty();
        boolean operationSuccess = false;

        if (validateOwner(owner)) {
            newOwner = Optional.of((Owner) owner.clone());
            operationSuccess = ownerList.add((Owner) newOwner.get());
        }

        if (!operationSuccess) {
            newOwner = Optional.empty();
        }
        return ownerList;
    }

    private boolean validateOwner(Owner owner) {
        boolean isValid = !ownerList.contains(owner);
        return isValid;
    }
}
