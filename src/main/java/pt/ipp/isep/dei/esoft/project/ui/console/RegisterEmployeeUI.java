package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Register employee ui.
 */
public class RegisterEmployeeUI implements Runnable {

    /**
     * The Name.
     */
    String name = null;
    /**
     * The Address.
     */
    Address address = null;
    /**
     * The Phone.
     */
    String phone = null;
    /**
     * The Email.
     */
    String email = null;
    /**
     * The Passport card number.
     */
    PassportCardNumber passportCardNumber = null;
    /**
     * The Zip code.
     */
    int zipCode = 0;
    /**
     * The City.
     */
    City city = null;

    /**
     * The Tax number.
     */
    TaxNumber taxNumber = null;
    /**
     * The Pass.
     */
    String pass = null;
    /**
     * The District.
     */
    District district = null;
    /**
     * The Street.
     */
    String street = null;
    /**
     * The State.
     */
    State state = null;
    /**
     * The Role.
     */
    Role role = null;
    /**
     * The Store.
     */
    Store store = null;
    /**
     * The Agency.
     */
    Agency agency = null;


    /**
     * The Controller.
     */
    RegisterEmployeeController controller = new RegisterEmployeeController();


    public void run() {
        String inputRole;
        String inputTax;
        String inputpassport;

        name = Utils.readLineFromConsole("Employee name:");
        while (name.trim().isEmpty()) {
            name = Utils.readLineFromConsole("Invalid Name \nInsert employee name:");
        }

        email = Utils.readLineFromConsole("Employe email:");
        while (!controller.checkEmail(email)) {
            email = Utils.readLineFromConsole("Invalid Email (format: XXX@XXX.XX) \nInsert new Email - ");
        }

        phone = Utils.readLineFromConsole("Phone number:");
        while (!controller.checkPhone(phone)) {
            phone = Utils.readLineFromConsole("Invalid Phone number (format: xxxxxxxxxx) \nInsert new phone number: ");
        }
        inputTax = String.valueOf(taxNumber);
        inputTax = Utils.readLineFromConsole("tax number:");
        while (!controller.checkTaxNumber(inputTax)) {
            inputTax = Utils.readLineFromConsole("Invalid tax number (format: xxxxxxxx) \nInsert new tax number: ");
        }
        inputpassport = String.valueOf(passportCardNumber);
        inputpassport = Utils.readLineFromConsole("Passport card number:");
        while (!controller.checkPassportCardNumber(inputpassport)) {
            inputpassport = Utils.readLineFromConsole("Invalid Passport card number (format: xxxxxxxx) \nInsert new passport card number number: ");
        }

        while (!controller.checkEmail(email)) {
            email = Utils.readLineFromConsole("Invalid ZipCode (format: xxxxx) \nInsert new ZipCode:");
        }

        address = Utils.listAndSelectOne(controller.getAddresses());
        if (address == null) return;
        System.out.println(address);

        System.out.println();
        System.out.println("####### List of Roles #######");
        role = Utils.listAndSelectOne(controller.getRolesList());
        if (role == null) return;

        inputRole = role.toString();

        if (inputRole.equals("System Administrator")) {
            SystemAdministrator sa = controller.registerSystemAdministrator(name, email, phone, passportCardNumber, taxNumber, address, role, pass);
//            System.out.println(sa);
            System.out.println(SystemAdministratorRepository.getSystemAdministratorsList());


        }
        if (inputRole.equals("Agent") || inputRole.equals("Manager Network") || inputRole.equals("Store Manager")) {

            System.out.println("####### List of Agencies #######");
            agency = Utils.listAndSelectOne(controller.getAgency());
            if (agency == null) return;


            if (inputRole.equals("Agent") || inputRole.equals("Store Manager")) {

                System.out.println("####### List of Stores #######");
                store = Utils.listAndSelectOne(controller.getStore());
                if (store == null) return;

            }

            if (inputRole.equals("Agent")) {

                Agent v = controller.registerAgent(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
//                System.out.println(v);
                System.out.println(AgentRepository.getAgentList());

            } else if (inputRole.equals("Manager Network")) {

                NetworkManager n = controller.RegisterNetworkManager(name, email, phone, passportCardNumber, taxNumber, address, role, agency, pass);
//                System.out.println(n);
                System.out.println(NetworkManagerRepository.getNetworkManagerList());

            } else if (inputRole.equals("Store Manager")) {
                StoreManager s = controller.registerStoreManager(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
//                System.out.println(s);
                System.out.println(StoreManagerRepository.getStoreManagerList());

            }
        }
        Employee e = controller.RegisterEmployee(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
        pass = e.getPass();
        System.out.println(e);
        controller.saveEmployee(name, email, pass, role.getDescription());
        controller.sendRegisteredUserEmail(email, pass);
        System.out.println();

        System.out.println(Repositories.getInstance().getEmployeeRepository().getNewEmployeeList());
        System.out.println("####### Operation sucess ######");
    }
}

