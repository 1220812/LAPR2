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
    String district=null;
    String street=null;
    String state=null;


    RegisterEmployeeController controller = new RegisterEmployeeController();


    public void run() {

        Scanner Input = new Scanner(System.in);

        String inputStore = null;
        String inputRole = null;
        String inputAgency = null;


        String role = null;
        String store = null;
        String agency = null;

        name = Utils.readLineFromConsole("Employee name:");

        email = Utils.readLineFromConsole("Employe email:");

        phone = Utils.readIntegerFromConsole("Phone number:");

        taxNumber = Utils.readIntegerFromConsole("tax number:");

        passportCardNumber = Utils.readIntegerFromConsole("Passport card number:");

        System.out.print("####### Create Address #######");



        city = Utils.readLineFromConsole("City:");
        district=Utils.readLineFromConsole("District:");
        street=Utils.readLineFromConsole("Street:");
        state=Utils.readLineFromConsole("State:");

        zipCode = Utils.readIntegerFromConsole("zipCode:");
        address = city + zipCode;
        System.out.println("Created adress:" + address);


        System.out.println();
        System.out.println("####### List of Roles #######");
        controller.getRoleRepository();

        inputRole = Input.next();
        if (inputRole.equals("1")) {
            role = "System administrator";
            store = "";
            agency = "";

        } else if (inputRole.equals("2") || inputRole.equals("3")) {

            if (inputRole.equals("2")) {
                role = "Agent";

            } else if (inputRole.equals("3")) {
                role = "Store manager";
            }

            System.out.println("####### List of Agencies #######");
            controller.getAgencyRepository();
            System.out.print("Select one agency:");


            inputAgency = Input.next();
            agency = inputAgency;


            if (inputAgency.equals("agency1") || inputAgency.equals("agency2") || inputAgency.equals("agency3") || inputAgency.equals("agency4") || inputAgency.equals("agency5")) {
                System.out.println("####### List of Stores #######");
                controller.getStoreRepository();
                System.out.println("Select one store");
                inputStore = Input.next();
                if (inputStore.equals("store1") || inputStore.equals("store2") || inputStore.equals("store3") || inputStore.equals("store4") || inputStore.equals("store5")) {

                    store = inputStore;
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
            agency = inputAgency;


        } else {
            System.out.println("invalid role");
        }

        System.out.println(controller.RegisterEmployee(name, address, phone, email, passportCardNumber, taxNumber, role, agency, store, pass));
        controller.getUserRepository();
        controller.sendRegisteredUserEmail(email, pass);
        System.out.println();
        System.out.println("####### Operation sucess ######");
    }
}
