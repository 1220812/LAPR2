
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class RegisterStoreController {

    Repositories repositories = Repositories.getInstance();

    public boolean checkEmail(String email) {
        return (Employee.existsEmail(email));
    }

    public boolean checkPhone(int phoneNumber){
        return Employee.existsPhone(phoneNumber);
    }

    public boolean checkID(int ID){
        return Store.existID(ID);
    }


    public  List<Address> getAddresses(){
        return Repositories.getInstance().getAddressRepository().getAddressList();
    }

    public Store RegisterStore(String desigantion, String emailAddress, int phoneNumber, Address address, int ID){
        return  Store.newStore(desigantion, emailAddress, phoneNumber, address, ID);

    }
}