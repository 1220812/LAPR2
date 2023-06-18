package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements Serializable {

    private static List<Client> clientList = new ArrayList<>();


    public void addClient(Client client) {
        if (validateClient(client))
            clientList.add(client);
    }


    public List<Client> getClientList() {
        return List.copyOf(this.clientList);
    }

//    public Store createClient(String name,int phoneNumber, String emailAddress, int taxNumber, int passportCardNumber, Address address) {
//        Store store = new Store (name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
//        addClient(client);
//        return client;
//    }

    public List<Client> add(Client client) throws CloneNotSupportedException {

        clientList.add(client);

        Optional<Client> newClient = Optional.empty();
        boolean operationSuccess = false;

        if (validateClient(client)) {
            newClient = Optional.of((Client) client.clone());
            operationSuccess = clientList.add((Client) newClient.get());
        }

        if (!operationSuccess) {
            newClient = Optional.empty();
        }
        return clientList;
    }

    private boolean validateClient(Client client) {
        boolean isValid = !clientList.contains(client);
        return isValid;
    }

    public static boolean checkClientEmail(String clientEmail) {
        for (Client client: clientList) {
            if (clientEmail.equals(client.getEmailAddress())) {
                return true;
            }
        }
        return false;
    }

    public Client getClientByEmail(String email) {
        for (Client client : clientList) {
            if (email.equals(client.getEmailAddress())) {
                return client;
            }
        }
        return null;
    }

    public Client getClientByUserSession(UserSession userSession) {
        return this.clientList.
                stream()
                .filter((client) -> new Email(client.getEmailAddress()).equals(userSession.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Client is logged in."));
    }
}
