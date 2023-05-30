package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.StoreRepository;

import java.util.List;

public class RegisterStoreController {

    Repositories repositories = Repositories.getInstance();

    public boolean checkEmail(String email) {
        return (Employee.existsEmail(email));
    }

    public boolean checkPhone(String phoneNumber){
        return Employee.existsPhone(phoneNumber);
    }

    public boolean checkID(int ID){
        return Store.existID(ID);
    }


    public  List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    public Store RegisterStore(String desigantion, String emailAddress, String phoneNumber, Address address, int ID){
        return  StoreRepository.createStore(desigantion, emailAddress, phoneNumber, address, ID);

    }
}