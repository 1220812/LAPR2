package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class RegisterEmployeeUI {

    String name = "";
    String address = "";
    int phone = 0;
    String email = "";
    int citizenCardNumber = 0;
    String postCode = "";
    String city = "";


    public void run() {
        name = Utils.readLineFromConsole("Employee name:");
        email = Utils.readLineFromConsole("Employe email:");
        phone = Utils.readIntegerFromConsole("Phone number:");


    }
}
