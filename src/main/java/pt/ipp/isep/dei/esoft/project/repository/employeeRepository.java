package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;

import java.util.ArrayList;
import java.util.List;
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();
    public EmployeeRepository(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees(){
        return employees;
    }
}
