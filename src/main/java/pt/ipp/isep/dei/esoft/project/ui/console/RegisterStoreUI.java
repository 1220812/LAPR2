package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterStoreController;
import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;


public class RegisterStoreUI implements Runnable {


    int ID = 0;

    String phoneNumber = "000-000-000";

    Address address = null;

    String emailAddress = null;
    String designation = null;



    RegisterStoreController controller = new RegisterStoreController();


    public void run() {

        designation = Utils.readLineFromConsole("Designation name:");
        while (designation.trim() .isEmpty()){
            designation = Utils.readLineFromConsole("Invalid designation \nInsert new designation:");
        }

        ID=Utils.readIntegerFromConsole("ID:");
        while (!controller.checkID(ID)){
            ID=Utils.readIntegerFromConsole("Invalid ID \nInser new ID:");
        }

        emailAddress=Utils.readLineFromConsole("Store email:");
        while (!controller.checkEmail(emailAddress)){
            emailAddress=Utils.readLineFromConsole("imvalid email \nInsert new Email:");
        }


        phoneNumber=Utils.readLineFromConsole("Phone number:");
        while (!controller.checkPhone(phoneNumber)){
            phoneNumber=Utils.readLineFromConsole("Invalid phone number\nInsert new phone number");
        }


        address= Utils.listAndSelectOne(controller.getAddresses());
        if (address==null) return;
        System.out.println(address);
        System.out.println(controller.RegisterStore(designation, emailAddress, phoneNumber,address, ID));
        System.out.println("Operation sucess");

    }

}