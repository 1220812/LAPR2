package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class employeeRepository {
    private static List<Employee> ListEmployees = new ArrayList<>();


    public employeeRepository() {

    }

    public static void Save(Employee user, AuthFacade facade) {
        ListEmployees.add(user);
        System.out.println("\nCreated employee: " + user.getName() + "\nUser Email : " + user.getEmail());
        facade.addUserWithRole(user.getName(), user.getEmail(), user.getPassword(), user.getRole());

    }


    /**
     * Create employee.
     *
     * @param user the user
     * @return the employee
     */
    public static Employee Create(employeeRepository user) {
        return new Employee(user.toString());
    }


    public static boolean existsPhone(int phone) {

        if (phone > 999999999 || phone < 100000000) {
            return false;
        }

        for (Employee checkEmp : ListEmployees) {
            if (checkEmp.getPhone() == phone) {
                return false;
            }
        }
        return true;
    }

    public static boolean existsTaxNumber(int taxNumber) {

        if (taxNumber > 999999999 || taxNumber < 100000000) {
            return false;
        }

        for (Employee checkEmp : ListEmployees) {
            if (checkEmp.getTaxNumber() == taxNumber) {
                return false;
            }
        }
        return true;
    }


    /**
     * Exists email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean existsEmail(String email) {
        if (!(email.contains("@") && email.contains("."))) {
            return false;
        }
        for (Employee checkEmp : ListEmployees) {
            if (checkEmp.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Exists passport card number boolean.
     *
     * @param passportCardNumber the citizen passsport card number
     * @return the boolean
     */
    public static boolean existsPassportCardNumber(int passportCardNumber) {
        if (passportCardNumber <10000000 || passportCardNumber > 99999999) {
            return false;
        }

        for (Employee checkEmp : ListEmployees) {
            if (checkEmp.getPassportCardNumber() == passportCardNumber) {
                return false;
            }
        }
        return true;
    }




}

