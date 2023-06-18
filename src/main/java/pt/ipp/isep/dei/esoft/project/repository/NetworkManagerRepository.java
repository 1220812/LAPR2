package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Network manager repository.
 */
public class NetworkManagerRepository implements Serializable {
    private static List<NetworkManager> networkManagerList = new ArrayList<>();

    /**
     * Create network manager network manager.
     *
     * @param name               the name
     * @param email              the email
     * @param phone              the phone
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param agency             the agency
     * @param pass               the pass
     * @return the network manager
     */
    public static NetworkManager createNetworkManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        NetworkManager networkManager = new NetworkManager (name, email, phone, passportCardNumber, taxNumber, address, role, agency, pass);
        addNetworkManager(networkManager);
        return networkManager;
    }

    /**
     * Get stores.
     *
     * @param networkManager the network manager
     */
    public static void addNetworkManager(NetworkManager networkManager) {
        if (validateNetworkManager(networkManager))
            networkManagerList.add(networkManager);
    }


    /**
     * Gets network manager list.
     *
     * @return the network manager list
     */
    public static List<NetworkManager> getNetworkManagerList() {
        return List.copyOf(networkManagerList);
    }


    /**
     * Add list.
     *
     * @param networkManager the network manager
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
    public List<NetworkManager> add(NetworkManager networkManager) throws CloneNotSupportedException {

        networkManagerList.add(networkManager);

        Optional<NetworkManager> newNetworkManager = Optional.empty();
        boolean operationSuccess = false;

        if (validateNetworkManager(networkManager)) {
            newNetworkManager = Optional.of((NetworkManager) networkManager.clone());
            operationSuccess = networkManagerList.add((NetworkManager) newNetworkManager.get());
        }

        if (!operationSuccess) {
            newNetworkManager = Optional.empty();
        }
        return networkManagerList;
    }

    private static boolean validateNetworkManager(NetworkManager networkManager) {
        boolean isValid = !networkManagerList.contains(networkManager);
        return isValid;
    }

    /**
     * Gets network manager by user session.
     *
     * @param userSession the user session
     * @return the network manager by user session
     */
    public NetworkManager getNetworkManagerByUserSession(UserSession userSession) {
        return this.networkManagerList.
                stream()
                .filter((networkManager) -> new Email(networkManager.getEmailAddress()).equals(userSession.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Network Manager is logged in."));
    }
}
