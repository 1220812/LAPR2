package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgentRepository {

    private static List<Agent> agentList = new ArrayList<>();

    public static Agent createAgent(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        Agent agent = new Agent (name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
        addAgent(agent);
        return agent;
    }

    /**
     * Get stores.
     */

    public static void addAgent(Agent agent) {
        if (validateAgent(agent))
            agentList.add(agent);
    }


    public static List<Agent> getAgentList() {
        return List.copyOf(agentList);
    }



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

    private static boolean validateAgent(Agent agent) {
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
