package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SystemAdministratorRepository {
    private static List<SystemAdministrator> systemAdministratorsList = new ArrayList<>();

    public static SystemAdministrator createSystemAdministrator(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, String pass) {
        SystemAdministrator systemAdministrator = new SystemAdministrator(name, email, phone, passportCardNumber, taxNumber, address, role, pass);
        addSystemAdministrator(systemAdministrator);
        return systemAdministrator;
    }

    /**
     * Get stores.
     */

    public static void addSystemAdministrator(SystemAdministrator systemAdministrator) {
        if (validateSystemAdministrator(systemAdministrator))
            systemAdministratorsList.add(systemAdministrator);
    }


    public static List<SystemAdministrator> getSystemAdministratorsList() {
        return List.copyOf(systemAdministratorsList);
    }


    public List<SystemAdministrator> add(SystemAdministrator systemAdministrator) throws CloneNotSupportedException {

        systemAdministratorsList.add(systemAdministrator);

        Optional<SystemAdministrator> newSystemAdministrator = Optional.empty();
        boolean operationSuccess = false;

        if (validateSystemAdministrator(systemAdministrator)) {
            newSystemAdministrator = Optional.of((SystemAdministrator) systemAdministrator.clone());
            operationSuccess = systemAdministratorsList.add((SystemAdministrator) newSystemAdministrator.get());
        }

        if (!operationSuccess) {
            newSystemAdministrator = Optional.empty();
        }
        return systemAdministratorsList;
    }

    private static boolean validateSystemAdministrator(SystemAdministrator systemAdministrator) {
        boolean isValid = !systemAdministratorsList.contains(systemAdministrator);
        return isValid;
    }
}
