package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

public class RegistEmployeeController {
    private pt.ipp.isep.dei.esoft.project.repository.roleRepository roleRepository = null;
    private pt.ipp.isep.dei.esoft.project.repository.storeRepository storeRepository=null;
    private pt.ipp.isep.dei.esoft.project.repository.agencyRepository agencyRepository=null;



    //Repository instances are obtained from the Repositories class
    public RegistEmployeeController() {
        roleRepository.getRole();
        storeRepository.getListOfStores();
        agencyRepository.getAllAgencies();
    }


    //Allows receiving the repositories as parameters for testing purposes
    public RegistEmployeeController(roleRepository Role, storeRepository Store) {
        this.roleRepository= roleRepository;
        this.storeRepository= storeRepository;
        this.agencyRepository=agencyRepository;
    }


    public  roleRepository  roleRepository() {
        if (roleRepository == null) {
            Repositories repository = Repositories.getInstance();

            //Get the roleRepository
            roleRepository = repository.roleRepository();
        }
        return roleRepository;
    }

    public storeRepository storeRepository(){
        if (storeRepository == null){
            Repositories repository = Repositories.getInstance();

            //Get the storeRepository
            storeRepository = repository.storeRepository();
        }
        return storeRepository;
    }

    public agencyRepository agencyRepository(){
        if (agencyRepository == null){
            Repositories repository = Repositories.getInstance();

            //Get the agencyRepository
            agencyRepository = repository.agencyRepository();
        }
        return agencyRepository;
    }






}
