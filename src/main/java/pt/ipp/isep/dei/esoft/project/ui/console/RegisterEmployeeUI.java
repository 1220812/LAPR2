package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class RegisterEmployeeUI implements Runnable{

    String name = "";
    String address = "";
    int phone = 0;
    String email = "";
    int passportCardNumber = 0;
    int zipCode = 0;
    String city = "";
    
    RegisterEmployeeController controller= new RegisterEmployeeController();


    public void run() {
        name = Utils.readLineFromConsole("Employee name:");
        email = Utils.readLineFromConsole("Employe email:");
        phone = Utils.readIntegerFromConsole("Phone number:");
        System.out.print("####### Create Address #######");
        city= Utils.readLineFromConsole("City:");
        zipCode= Utils.readIntegerFromConsole("zipCode:");
        address=city+zipCode;
        System.out.println("Created adress:"+address);
        System.out.println();
        controller.RegisterEmployeeController();







    }
}
