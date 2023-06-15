package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.UserRepository;

import java.io.Serializable;

public class CurrentSession implements Serializable {
    private static String email;
    private static UserRepository userRepository = Repositories.getInstance().getUserRepository();

    public static void setCurrentSession(String id){
        email = id;
    }

    public static String getEmail() {
        return email;
    }
}
