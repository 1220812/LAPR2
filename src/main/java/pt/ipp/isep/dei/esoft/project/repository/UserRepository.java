package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.User;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents UserRepository
 *
 * @author Francisco Silveira
 */
public class UserRepository {
    /**
     * Represents the list of employees in the Repository
     */
    private List<Employee> employeeList = new ArrayList<>();
    /**
     * Represents the list of users in the Repository
     */
    private List<User> userList = new ArrayList<>();

    /**
     * Method to add a new employee to the list of employees
     * @param employee employee added
     */

    public void addEmployee(Employee employee) {
        if (validateEmployee(employee)){
            employeeList.add(employee);
        }
    }
    /**
     * Method to add a new user to the list of users
     * @param user user added
     */
    public void addUser(User user){
        if(validateUser(user)){
            userList.add(user);
        }
    }
    public boolean validateEmployee(Employee employee){
        return !this.employeeList.contains(employee);
    }
    public boolean validateUser(User user){
        return !this.userList.contains(user);
    }
    public List<Employee> getEmployeeList(){
        return List.copyOf(this.employeeList);
    }
    public List<User> getUserList(){
        return List.copyOf(this.userList);
    }
}