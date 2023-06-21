package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type System administrator repository.
 */
public class SystemAdministratorRepository implements Serializable {
    private static List<SystemAdministrator> systemAdministratorsList = new ArrayList<>();

    /**
     * Create system administrator system administrator.
     *
     * @param name               the name
     * @param email              the email
     * @param phone              the phone
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param pass               the pass
     * @return the system administrator
     */
    public static SystemAdministrator createSystemAdministrator(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, String pass) {
        SystemAdministrator systemAdministrator = new SystemAdministrator(name, email, phone, passportCardNumber, taxNumber, address, role, pass);
        addSystemAdministrator(systemAdministrator);
        return systemAdministrator;
    }

    /**
     * Get stores.
     *
     * @param systemAdministrator the system administrator
     */
    public static void addSystemAdministrator(SystemAdministrator systemAdministrator) {
        if (validateSystemAdministrator(systemAdministrator))
            systemAdministratorsList.add(systemAdministrator);
    }


    /**
     * Gets system administrators list.
     *
     * @return the system administrators list
     */
    public static List<SystemAdministrator> getSystemAdministratorsList() {
        return List.copyOf(systemAdministratorsList);
    }


    /**
     * Add list.
     *
     * @param systemAdministrator the system administrator
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
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
