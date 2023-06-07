package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.NotImplementedException;

import java.io.*;

public class EmailService {
    /**
     * Method that sends an email to the user with the password when he registers in the system
     * @param email user´s email
     * @param pass user´s password
     */

    public static void sendEmail(String email, String pass) {
        System.out.println("Password ("+ pass+") was sent to the user´s email ("+email+")");
    }

    /**
     * Method to wright to a file
     * @param fileName name of the file generated
     * @param emailText text to be written in the file
     */
    public static void wrightToFile(String fileName, String emailText){
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(emailText);
            fileWriter.close();
            System.out.println("Successfully sent notification");
        }catch (IOException e){
            System.out.println("An error occur during the operation");
        }
    }

    /**
     * This method sends an email to the client when his order is rejected
     * @param clientName name of the client
     * @param propertyOrderNumber order number of the property
     */
    public void sendRejectedOrderEmail(String clientName, int propertyOrderNumber) {
        String message = "Dear " + clientName + ",\n\n" +
                "Your order for the property with the order number " + propertyOrderNumber + " was rejected.\n\n" +
                "Best regards,\n" +
                "The Real Estate Company";
        wrightToFile("RejectedOrder.txt", message);
    }

    /**
     * This method sends an email to the client when his order is accepted
     * @param clientName name of the client
     * @param propertyOrderNumber order number of the property
     */
    public void sendAcceptedOrderEmail(String clientName, int propertyOrderNumber){
        String message = "Dear" + clientName + ",\n\n" +
                "Your order for the property with the order number " + propertyOrderNumber + " was accepted.\n\n" +
                "Best regards,\n" +
                "The Real Estate Company";
        wrightToFile("AcceptedOrder.txt", message);
    }
}
