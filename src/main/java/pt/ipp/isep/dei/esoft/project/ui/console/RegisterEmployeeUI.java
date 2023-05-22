package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable {

    String name = null;
    Address address = null;
    String  phone = null;
    String email = null;
    String passportCardNumber =null;
    int zipCode = 0;
    City city = null;

    String taxNumber = null;
    String pass = null;
    District district = null;
    String street = null;
    State state = null;
    Role role = null;
    Store store = null;
    Agency agency = null;


    RegisterEmployeeController controller = new RegisterEmployeeController();


    public void run() {

        Scanner Input = new Scanner(System.in);

        String inputStore = null;
        String inputRole = null;
        String inputAgency = null;




        name = Utils.readLineFromConsole("Employee name:");
        while (name.trim().isEmpty()) {
            name = Utils.readLineFromConsole("Invalid Name \nInsert employee name:");
        }

        email = Utils.readLineFromConsole("Employe email:");
        while (!controller.checkEmail(email)) {
            email = Utils.readLineFromConsole("Invalid Email (format: XXX@XXX.XX) \nInsert new Email - ");
        }

        phone = Utils.readLineFromConsole("Phone number:");
        while (!controller.checkPhone(Integer.parseInt(phone))) {
            phone = Utils.readLineFromConsole("Invalid Phone number (format: xxxxxxxxxx) \nInsert new phone number: ");
        }






        taxNumber = Utils.readLineFromConsole("tax number:");
        while (!controller.checkTaxNumber(taxNumber)) {
            taxNumber = Utils.readLineFromConsole("Invalid tax number (format: xxxxxxxx) \nInsert new tax number: ");
        }

        passportCardNumber = Utils.readLineFromConsole("Passport card number:");
        while (!controller.checkPassportCardNumber(passportCardNumber)) {
            passportCardNumber = Utils.readLineFromConsole("Invalid Passport card number (format: xxxxxxxx) \nInsert new passport card number number: ");
        }


        address = Utils.listAndSelectOne(controller.getAddresses());

        if (address == null) return;








        while (!controller.checkEmail(email)) {
            email = Utils.readLineFromConsole("Invalid ZipCode (format: xxxxx) \nInsert new ZipCode:");
        }


        System.out.println(address);


        System.out.println();
        System.out.println("####### List of Roles #######");
        controller.getRoleRepository();



        System.out.println(controller.RegisterEmployee(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass));
        controller.getUserRepository();
        controller.sendRegisteredUserEmail(email, pass);
        System.out.println();
        System.out.println("####### Operation sucess ######");
    }
}
