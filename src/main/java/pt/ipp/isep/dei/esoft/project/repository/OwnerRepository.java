package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Owner;
import pt.ipp.isep.dei.esoft.project.domain.Owner;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Owner repository.
 */
public class OwnerRepository implements Serializable {
    private static final long serialVersionUID = 74193049451413887L;
    private static List<Owner> ownerList = new ArrayList<>();


    /**
     * Add owner.
     *
     * @param owner the owner
     */
    public void addOwner(Owner owner) {
        if (validateOwner(owner))
            ownerList.add(owner);
    }


    /**
     * Gets owner list.
     *
     * @return the owner list
     */
    public List<Owner> getOwnerList() {
        return List.copyOf(this.ownerList);
    }

//    public Store createOwner(String name,int phoneNumber, String emailAddress, int taxNumber, int passportCardNumber, Address address) {
//        Store store = new Store (name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
//        addOwner(owner);
//        return owner;
//    }

    /**
     * Add list.
     *
     * @param owner the owner
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
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

    /**
     * Check owner email boolean.
     *
     * @param ownerEmail the owner email
     * @return the boolean
     */
    public static boolean checkOwnerEmail(String ownerEmail) {
        for (Owner owner: ownerList) {
            if (ownerEmail.equals(owner.getEmailAddress())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets owner by email.
     *
     * @param email the email
     * @return the owner by email
     */
    public Owner getOwnerByEmail(String email) {
        for (Owner owner : ownerList) {
            if (email.equals(owner.getEmailAddress())) {
                return owner;
            }
        }
        return null;
    }
}
