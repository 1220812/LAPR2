package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Collections;
import java.util.List;

/**
 * The type List employees controller.
 */
public class ListEmployeesController {

    /**
     * Gets employee repository.
     *
     * @return the employee repository
     */
    public List<Employee> getEmployeeRepository() {
        return Repositories.getInstance().getEmployeeRepository().getNewEmployeeList();
    }

    /**
     * Gets employee repository sorted.
     *
     * @return the employee repository sorted
     */
    public List<Employee> getEmployeeRepositorySorted() {
       return Repositories.getInstance().getEmployeeRepository().getNewEmployeeListSorted();

    }

    /**
     * Gets employee repository sorted and grouped.
     *
     * @return the employee repository sorted and grouped
     */
    public List<Employee> getEmployeeRepositorySortedAndGrouped() {
            return Repositories.getInstance().getEmployeeRepository().getEmployeeRepositorySortedAndGrouped();
        }
    }



