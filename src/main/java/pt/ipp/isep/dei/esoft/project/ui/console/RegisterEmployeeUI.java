package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable {

    String name = "";
    String address = "";
    int phone = 0;
    String email = "";
    int passportCardNumber = 0;
    int zipCode = 0;
    String city = "";

    int taxNumber=0;

    RegisterEmployeeController controller = new RegisterEmployeeController();


    public void run() {

        Scanner Input = new Scanner(System.in);

        String inputStore = "";
        String inputRole = "";
        String inputAgency = "";


        Employee RegisterEmployee = controller.RegisterEmployee(name, address, phone, email, passportCardNumber, address, inputRole, inputAgency, inputStore);


        name = Utils.readLineFromConsole("Employee name:");
        RegisterEmployee.setName(name);

        email = Utils.readLineFromConsole("Employe email:");
        RegisterEmployee.setEmail(email);

        phone = Utils.readIntegerFromConsole("Phone number:");
        RegisterEmployee.setPhoneNumber(phone);

        taxNumber = Utils.readIntegerFromConsole("tax number:");
        RegisterEmployee.setTaxNumber(taxNumber);

        passportCardNumber = Utils.readIntegerFromConsole("Passport card number:");
        RegisterEmployee.setPassportCardNumber(passportCardNumber);

        System.out.print("####### Create Address #######");
        city = Utils.readLineFromConsole("City:");
        zipCode = Utils.readIntegerFromConsole("zipCode:");
        address = city + zipCode;
        System.out.println("Created adress:" + address);
        System.out.println();
        System.out.println("####### List of Roles #######");
        controller.getRoleRepository();

        inputRole = Input.next();
        if (inputRole.equals("1")) {


        } else if (inputRole.equals("2") || inputRole.equals("3")) {
            System.out.println("####### List of Agencies #######");
            controller.getAgencyRepository();
            System.out.print("Select one agency:");

            inputAgency = Input.next();
            if (inputAgency.equals("1") || inputAgency.equals("2") || inputAgency.equals("3") || inputAgency.equals("4") || inputAgency.equals("5")) {
                System.out.println("####### List of Stores #######");
                controller.getStoreRepository();
                System.out.println("Select one store");

                inputStore = Input.next();
                if (inputStore.equals("1") || inputStore.equals("2") || inputStore.equals("3") || inputStore.equals("4") || inputStore.equals("5")) {

                } else {
                    System.out.println("invalide store");
                }
            } else {
                System.out.println("Invalid agency");
            }


        } else if (inputRole.equals("4")) {
            System.out.println("####### List of Agencies #######");
            controller.getAgencyRepository();

            inputAgency = Input.next();

        } else {
            System.out.println("invalid role");

        }



    }
}
