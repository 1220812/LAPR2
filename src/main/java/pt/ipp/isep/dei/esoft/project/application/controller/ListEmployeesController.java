package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Collections;
import java.util.List;

public class ListEmployeesController {

    public List<Employee> getEmployeeRepository() {
        return Repositories.getInstance().getEmployeeRepository().getNewEmployeeList();
    }

    public List<Employee> getEmployeeRepositorySorted() {
       return Repositories.getInstance().getEmployeeRepository().getNewEmployeeListSorted();

    }

    public List<Employee> getEmployeeRepositorySortedAndGrouped() {
            return Repositories.getInstance().getEmployeeRepository().getEmployeeRepositorySortedAndGrouped();
        }
    }



