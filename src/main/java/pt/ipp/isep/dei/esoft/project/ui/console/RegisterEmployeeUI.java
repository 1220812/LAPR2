package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable {

    String name = null;
    String address = null;
    int phone = 0;
    String email = null;
    int passportCardNumber = 0;
    int zipCode = 0;
    String city = null;

    int taxNumber = 0;
    String pass = null;

    RegisterEmployeeController controller = new RegisterEmployeeController();


    public void run() {

        Scanner Input = new Scanner(System.in);

        String inputStore = "";
        String inputRole = "";
        String inputAgency = "";


        Employee RegisterEmployee = controller.RegisterEmployee(name, address, phone, email, passportCardNumber, taxNumber, inputRole, inputAgency, inputStore, pass);



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
        RegisterEmployee.setPassportCardNumber(passportCardNumber);

        zipCode = Utils.readIntegerFromConsole("zipCode:");
        address = city + zipCode;
        System.out.println("Created adress:" + address);

        RegisterEmployee.setAddress(address);

        System.out.println();
        System.out.println("####### List of Roles #######");
        controller.getRoleRepository();

        inputRole = Input.next();
        if (inputRole.equals("1")) {
            RegisterEmployee.setRole("System Administrator");

        } else if (inputRole.equals("2") || inputRole.equals("3")) {
            System.out.println("####### List of Agencies #######");
            controller.getAgencyRepository();
            System.out.print("Select one agency:");

            if (inputRole.equals("2")) {
                RegisterEmployee.setRole("Agent");


            } else if (inputRole.equals("3")) {
                RegisterEmployee.setRole("Store manager");
            }

            inputAgency = Input.next();
            RegisterEmployee.setAgency(inputAgency);


            if (inputAgency.equals("agency1") || inputAgency.equals("agency2") || inputAgency.equals("agency3") || inputAgency.equals("agency4") || inputAgency.equals("agency5")) {
                System.out.println("####### List of Stores #######");
                controller.getStoreRepository();
                System.out.println("Select one store");
                inputStore = Input.next();
                if (inputStore.equals("store1") || inputStore.equals("store2") || inputStore.equals("store3") || inputStore.equals("store4") || inputStore.equals("store5")) {

                    RegisterEmployee.setAgency(inputStore);


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
            RegisterEmployee.setRole("Network Manager");


        } else {
            System.out.println("invalid role");
        }

        System.out.println(controller.RegisterEmployee(name, address, phone, email, passportCardNumber, taxNumber, inputRole, inputAgency, inputStore, pass));
        controller.getUserRepository();

        controller.sendRegisteredUserEmail(email, pass);
    }
}
