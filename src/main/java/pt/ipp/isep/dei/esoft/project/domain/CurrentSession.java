package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.UserRepository;

import java.io.Serializable;

/**
 * The type Current session.
 */
public class CurrentSession implements Serializable {
    private static String email;
    private static UserRepository userRepository = Repositories.getInstance().getUserRepository();

    /**
     * Set current session.
     *
     * @param id the id
     */
    public static void setCurrentSession(String id){
        email = id;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public static String getEmail() {
        return email;
    }
}
