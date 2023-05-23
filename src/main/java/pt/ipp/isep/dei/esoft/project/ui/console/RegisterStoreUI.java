package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterStoreController;
import pt.ipp.isep.dei.esoft.project.domain.Localization;

import java.util.Scanner;
public class RegisterStoreUI implements Runnable{
    private RegisterStoreController controller = new RegisterStoreController();
    public RegisterStoreUI(){
        this.controller= new RegisterStoreController();
    }
    public void RequestedData() {
        Scanner ler = new Scanner (System.in);
        System.out.println("Store ID:");
        int storeID = ler.nextInt();
        ler.nextLine();
        System.out.println("Enter store's designation:");
        String storeDesignation = ler.nextLine();
        System.out.println("Enter store's phone number:");
        int storePhoneNumber = ler.nextInt();
        System.out.println("Enter store's email:");
        String storeEmail = ler.nextLine();
        System.out.println("Enter store's location (street):");
        String street = ler.nextLine();
        System.out.println("Enter store location (doorNumber):");
        String doorNumber = ler.nextLine();
        System.out.println("Enter store location (floorNumber):");
        String floorNumber = ler.nextLine();
        System.out.println("Enter store location (postalCode):");
        String postalCode =ler.nextLine();
        System.out.println("Enter store location (city):");
        String city = ler.nextLine();
        System.out.println("Enter store location (district):");
        String district = ler.nextLine();
        System.out.println("Enter store location (state):");
        String state = ler.nextLine();
        String location = "ISEP";
        controller.getCreateLocation(street,doorNumber,floorNumber,postalCode,city,district,state);
        controller.getCreateStore(storeID,storeDesignation,storePhoneNumber,storeEmail,location,new Localization(street,doorNumber,floorNumber,postalCode,city,district,state));
        controller.getRegisterStore();
        controller.getRegisterLocation();

        System.out.println("Store registered successfully.");
    }
    @Override
    public void run() {
        RequestedData();
    }
}