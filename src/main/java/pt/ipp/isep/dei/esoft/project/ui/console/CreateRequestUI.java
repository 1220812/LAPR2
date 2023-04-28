package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class CreateRequestUI {
    public void run() {
        String nameOwner = Utils.readLineFromConsole("Owner name:");
        String passportCardNumber = Utils.readLineFromConsole("Passport card number:");
        String taxNumber = Utils.readLineFromConsole("Tax number:");
        String emailAddress = Utils.readLineFromConsole("EmailAddress:");
        String phoneNumber = Utils.readLineFromConsole("Phone number:");
    }
}