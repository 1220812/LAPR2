package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgentRepository {

    private List<Agent> agentList = new ArrayList<>();

    /**
     * Get stores.
     */

    public void addAgent(Agent agent) {
        if (validateAgent(agent))
            agentList.add(agent);
    }


    public List<Agent> getAgentList() {
        return List.copyOf(this.agentList);
    }

//    public Store createAgent(String name,int phoneNumber, String emailAddress, int taxNumber, int passportCardNumber, Address address) {
//        Store store = new Store (name, phoneNumber, emailAddress, taxNumber, passportCardNumber, address);
//        addAgent(agent);
//        return agent;
//    }

    public List<Agent> add(Agent agent) throws CloneNotSupportedException {

        agentList.add(agent);

        Optional<Agent> newAgent = Optional.empty();
        boolean operationSuccess = false;

        if (validateAgent(agent)) {
            newAgent = Optional.of((Agent) agent.clone());
            operationSuccess = agentList.add((Agent) newAgent.get());
        }

        if (!operationSuccess) {
            newAgent = Optional.empty();
        }
        return agentList;
    }

    private boolean validateAgent(Agent agent) {
        boolean isValid = !agentList.contains(agent);
        return isValid;
    }

    public Agent getAgentByUserSession(UserSession userSession){
        return this.agentList.
                stream()
                .filter((agent) -> new Email(agent.getEmailAddress()).equals(userSession.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Agent is logged in."));
    }
}
