package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private static List<Employee> NewEmployeeList = new ArrayList<>();



    public static void addNewEmployee(Employee newEmployee) {
        if (validateNewEmployee(newEmployee))
            NewEmployeeList.add(newEmployee);
    }


    public List<Employee> getNewEmployeeList() {
        return List.copyOf(this.NewEmployeeList);
    }

    public List<Employee> getNewEmployeeListSorted() {
        NewEmployeeList.sort(Comparator.comparing(Employee::getName));
        return NewEmployeeList;
    }
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

    public static Employee createNewEmployee(String name, String email, String phoneNumber, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        Employee newEmployee = new Employee(name, email, phoneNumber, passportCardNumber, taxNumber, address, role, agency, pass);
        addNewEmployee(newEmployee);
        return newEmployee;
    }

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
