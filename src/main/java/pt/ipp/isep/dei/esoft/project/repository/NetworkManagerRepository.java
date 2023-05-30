package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NetworkManagerRepository {
    private static List<NetworkManager> networkManagerList = new ArrayList<>();

    public static NetworkManager createNetworkManager(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, String pass) {
        NetworkManager networkManager = new NetworkManager (name, email, phone, passportCardNumber, taxNumber, address, role, agency, pass);
        addNetworkManager(networkManager);
        return networkManager;
    }

    /**
     * Get stores.
     */

    public static void addNetworkManager(NetworkManager networkManager) {
        if (validateNetworkManager(networkManager))
            networkManagerList.add(networkManager);
    }


    public static List<NetworkManager> getNetworkManagerList() {
        return List.copyOf(networkManagerList);
    }



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
}
