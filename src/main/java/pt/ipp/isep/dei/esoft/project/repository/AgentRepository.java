package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

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

    public Agent createAgent(String name, String phoneNumber, String emailAddress, TaxNumber taxNumber, PassportCardNumber passportCardNumber, Address address) {
        Agent agent = new Agent(name, phoneNumber, emailAddress, address, taxNumber, passportCardNumber);
        addAgent(agent);
        return agent;
    }

    public List<Agent> add(Agent agent){
        if (validateAgent(agent)) {
            agentList.add(agent);
    }

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
}
