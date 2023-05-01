package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents UserRepository
 * @author Francisco Silveira
 */
public class UserRepository {
    /**
     * Represents the List of Users in the Repository
     */
    private static List<Employee> userList = new ArrayList<Employee>();

    /**
     * Adds a user to the repository list
     * @param user User object to be added to the user list
     */
    public static void setUser(Employee user) {
        userList.add(user);
    }

    /**
     * Gets a copy of the current list of users
     * @return Copy of the list of users
     */
    public static List<Employee> getUserList() {
        return List.copyOf(userList);
    }



}