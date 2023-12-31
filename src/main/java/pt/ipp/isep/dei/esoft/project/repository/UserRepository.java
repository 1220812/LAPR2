package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.User;
import pt.isep.lei.esoft.auth.UserSession;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents UserRepository
 *
 * @author Francisco Silveira
 */
public class UserRepository implements Serializable {
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
     *
     * @param employee employee added
     */
    public void addEmployee(Employee employee) {
        if (validateEmployee(employee)){
            employeeList.add(employee);
        }
    }

    /**
     * Method to add a new user to the list of users
     *
     * @param user user added
     */
    public void addUser(User user){
        if(validateUser(user)){
            userList.add(user);
        }
    }

    /**
     * Validate employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean validateEmployee(Employee employee){
        return !this.employeeList.contains(employee);
    }

    /**
     * Get employee list list.
     *
     * @return the list
     */
    public List<Employee> getEmployeeList(){
        return List.copyOf(this.employeeList);
    }

    /**
     * Get user list list.
     *
     * @return the list
     */
    public List<User> getUserList(){
        return List.copyOf(this.userList);
    }

    /**
     * Add list.
     *
     * @param user the user
     * @return the list
     */
    public List<User> add(User user) {
    for (User u : userList) {
        System.out.println(u.toString());
        }
        userList.add(user);

        Optional<User> newUser = Optional.empty();
        boolean operationSuccess = false;

        if (validateUser(user)) {
            newUser = Optional.of((User) user.clone());
            operationSuccess = userList.add((User) newUser.get());
        }

        if (!operationSuccess) {
            newUser = Optional.empty();
        }
        return userList;
    }

    private boolean validateUser(User user) {
        boolean isValid = !userList.contains(user);
        return isValid;
    }

    /**
     * Add list.
     *
     * @param employee the employee
     * @return the list
     */
    public List<Employee> add(Employee employee) {

        employeeList.add(employee);

        Optional<Employee> newEmployee = Optional.empty();
        boolean operationSuccess = false;

        if (validateEmployee(employee)) {
            newEmployee = Optional.of((Employee) employee.clone());
            operationSuccess = employeeList.add((Employee) newEmployee.get());
        }

        if (!operationSuccess) {
            newEmployee = Optional.empty();
        }
        return employeeList;
    }
}