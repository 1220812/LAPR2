package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.List;

/**
 * The type Register store controller.
 */
public class RegisterStoreController {

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();

    /**
     * Check email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean checkEmail(String email) {
        return (Employee.existsEmail(email));
    }

    /**
     * Check phone boolean.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    public boolean checkPhone(String phoneNumber){
        return Employee.existsPhone(phoneNumber);
    }

    /**
     * Check id boolean.
     *
     * @param ID the id
     * @return the boolean
     */
    public boolean checkID(int ID){
        return Store.existID(ID);
    }


    /**
     * Get addresses list.
     *
     * @return the list
     */
    public  List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    /**
     * Register store store.
     *
     * @param desigantion  the desigantion
     * @param emailAddress the email address
     * @param phoneNumber  the phone number
     * @param address      the address
     * @param ID           the id
     * @return the store
     */
    public Store RegisterStore(String desigantion, String emailAddress, String phoneNumber, Address address, int ID){
        return  StoreRepository.createStore(desigantion, emailAddress, phoneNumber, address, ID);

    }
}