package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.agencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.roleRepository;


import java.util.List;

public class RegisterEmployeeController {
    public void RegisterEmployeeController() {
        Repositories repositories = Repositories.getInstance();
        roleRepository.getEmployeeRoles();
        agencyRepository.getAgencies();
    }

}
