package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
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

    RegisterEmployeeController controller = new RegisterEmployeeController();


    public void run() {
        Scanner Input = new Scanner(System.in);
        name = Utils.readLineFromConsole("Employee name:");
        email = Utils.readLineFromConsole("Employe email:");
        phone = Utils.readIntegerFromConsole("Phone number:");
        passportCardNumber = Utils.readIntegerFromConsole("Passport card number:");
        System.out.print("####### Create Address #######");
        city = Utils.readLineFromConsole("City:");
        zipCode = Utils.readIntegerFromConsole("zipCode:");
        address = city + zipCode;
        System.out.println("Created adress:" + address);
        System.out.println();
        System.out.println("####### List of Roles #######");
        controller.getRoleRepository();
        String inputRole = "";
        inputRole = Input.next();
        if (inputRole.equals("1")) {


        } else if (inputRole.equals("2") || inputRole.equals("3")) {
            System.out.println("####### List of Agencies #######");
            controller.getAgencyRepository();
            System.out.print("Select one agency:");
            String inputAgency = "";
            inputAgency = Input.next();
            if (inputAgency.equals("1") || inputAgency.equals("2") || inputAgency.equals("3") || inputAgency.equals("4") || inputAgency.equals("5")) {
                System.out.println("####### List of Stores #######");
                controller.getStoreRepository();
                System.out.println("Select one store");
                String inputStore = "";
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
            String inputAgency = "";
            inputAgency = Input.next();

        } else {
            System.out.println("invalid role");

        }


    }
}
