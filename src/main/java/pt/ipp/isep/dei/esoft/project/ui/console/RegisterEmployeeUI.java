package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.Places.Address;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class RegisterEmployeeUI implements Runnable {
    public void run() {
        String nameEmployee= Utils.readLineFromConsole("Employee name:");
        String passportCardNumber= Utils.readLineFromConsole("Passport card number:");
        String taxNumberEmployee= Utils.readLineFromConsole("Tax number:");
        String emailEmployee= Utils.readLineFromConsole("Employee email:");
        String phoneNumberEmployeee= Utils.readLineFromConsole("Employee phone number:");
        String addressEmployee= Utils.readLineFromConsole("Employee address:");


    }
}
