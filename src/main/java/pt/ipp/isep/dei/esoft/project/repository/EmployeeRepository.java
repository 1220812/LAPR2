package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Employee repository.
 */
public class EmployeeRepository {
    private static List<Employee> NewEmployeeList = new ArrayList<>();


    /**
     * Add new employee.
     *
     * @param newEmployee the new employee
     */
    public static void addNewEmployee(Employee newEmployee) {
        if (validateNewEmployee(newEmployee))
            NewEmployeeList.add(newEmployee);
    }


    /**
     * Gets new employee list.
     *
     * @return the new employee list
     */
    public List<Employee> getNewEmployeeList() {
        return List.copyOf(this.NewEmployeeList);
    }

    /**
     * Gets new employee list sorted.
     *
     * @return the new employee list sorted
     */
    public List<Employee> getNewEmployeeListSorted() {
        NewEmployeeList.sort(Comparator.comparing(Employee::getName));
        return NewEmployeeList;
    }

    /**
     * Gets employee repository sorted and grouped.
     *
     * @return the employee repository sorted and grouped
     */
    public List<Employee> getEmployeeRepositorySortedAndGrouped() {

        NewEmployeeList.sort(Comparator.comparing(Employee::getStoreName));
        List<Employee> employeesWithStores = new ArrayList<>();
        for (Employee employee: NewEmployeeList
             ) {
            if(employee.getStore()!=null){
                employeesWithStores.add(employee);
            }
        }
        return employeesWithStores;
    }

    /**
     * Create new employee employee.
     *
     * @param name               the name
     * @param email              the email
     * @param phoneNumber        the phone number
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param agency             the agency
     * @param pass               the pass
     * @return the employee
     */
    public static Employee createNewEmployee(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        Employee newEmployee = new Employee(name, email, phoneNumber, passportCardNumber, taxNumber, address, role, agency, pass);
        addNewEmployee(newEmployee);
        return newEmployee;
    }

    /**
     * Add list.
     *
     * @param newEmployee the new employee
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public List<Employee> add(Employee newEmployee) throws CloneNotSupportedException {

        NewEmployeeList.add(newEmployee);

        Optional<Employee> newNewEmployee = Optional.empty();
        boolean operationSuccess = false;

        if (validateNewEmployee(newEmployee)) {
            newNewEmployee = Optional.of((Employee) newEmployee.clone());
            operationSuccess = NewEmployeeList.add((Employee) newNewEmployee.get());
        }

        if (!operationSuccess) {
            newNewEmployee = Optional.empty();
        }
        return NewEmployeeList;
    }

    private static boolean validateNewEmployee(Employee newEmployee) {
        boolean isValid = !NewEmployeeList.contains(newEmployee);
        return isValid;
    }


}



