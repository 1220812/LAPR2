package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.NotImplementedException;

import java.io.*;

public class EmailService {
    private User client;

    public static void sendEmail(String email, String pass) {
        System.out.println("Password ("+ pass+") was sent to the user´s email ("+email+")");
    }
    /**
     * Generate notification by email
     * @param answer the answer to the order made by the client
     */
    public static void generateNotification(String answer){
        String fileName = "RealEstateAgencyEmail.txt";
        String emailText = String.format("New email: Your purchase order was " + answer + "!");
        wrightToFile(fileName, emailText);
    }
    public static void wrightToFile(String fileName, String emailText){

        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(emailText);
            fileWriter.close();
            System.out.println("Successfully sent notification");
        }catch (IOException e){
            System.out.println("An error occur during the operation");
        }
    }

    public void sendRejectedOrderEmail(String clientName, int propertyOrderNumber) {
        String message = "Dear " + clientName + ",\n\n" +
                "Your order for the property with the order number " + propertyOrderNumber + " was rejected.\n\n" +
                "Best regards,\n" +
                "The Real Estate Company";
        wrightToFile("RejectedOrder,txt", message);
    }
    public void sendAcceptedOrderEmail(String clientName, int propertyOrderNumber){
        String message = "Dear" + clientName + ",\n\n\" + " +
                "Your order for the property with the order number " + propertyOrderNumber + " was accepted.\n\n" +
                "Best regards,\n" +
                "The Real Estate Company";
        wrightToFile("AcceptedOrder,txt", message);
    }
}
