package pt.ipp.isep.dei.esoft.project.domain;

public class EmailService {

    public static void sendEmail(String email, String pass) {
        System.out.println("Password ("+ pass+") was sent to the user´s email ("+email+")");

    }
}
