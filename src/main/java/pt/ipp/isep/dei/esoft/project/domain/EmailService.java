package pt.ipp.isep.dei.esoft.project.domain;

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
    public static void writeToFile(String fileName, String emailText){
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
     * This method sends an email to the client
     * @param clientEmail client's email
     * @param message sending message
     */
    public void sendMessage(String clientEmail, String message) {
        String emailText = "Dear client " + clientEmail + ",\n\n" +
                message + "\n\n" +
                "Best regards,\n" +
                "The Real Estate Company";
        writeToFile(clientEmail+" you got a new email", emailText);
    }
}
