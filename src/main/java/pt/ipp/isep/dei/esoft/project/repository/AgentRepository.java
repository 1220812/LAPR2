package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Agent repository.
 */
public class AgentRepository {

    private static List<Agent> agentList = new ArrayList<>();

    /**
     * Create agent.
     *
     * @param name               the name
     * @param email              the email
     * @param phone              the phone
     * @param passportCardNumber the passport card number
     * @param taxNumber          the tax number
     * @param address            the address
     * @param role               the role
     * @param agency             the agency
     * @param store              the store
     * @param pass               the pass
     * @return the agent
     */
    public static Agent createAgent(String name, String email, String phone, PassportCardNumber passportCardNumber, TaxNumber taxNumber, Address address, Role role, Agency agency, Store store, String pass) {
        Agent agent = new Agent(name, email, phone, passportCardNumber, taxNumber, address, role, agency, store, pass);
        addAgent(agent);
        return agent;
    }

    /**
     * Get stores.
     *
     * @param agent the agent
     */
    public static void addAgent(Agent agent) {
        if (validateAgent(agent))
            agentList.add(agent);
    }

    /**
     * Gets agent list.
     *
     * @return the agent list
     */
    public static List<Agent> getAgentList() {
        return List.copyOf(agentList);
    }

    /**
     * Get agent.
     *
     * @return the agent
     */
    public Agent getAgent (){
        Agent agent1 = null;
        List<Agent> agents = getAgentList();
        for (Agent agent: agents){
            if (agent.getEmailAddress().equals(CurrentSession.getEmail())){
                agent1 = agent;
            }
        }
        return agent1;
    }

    /**
     * Add list.
     *
     * @param agent the agent
     * @return the list
     * @throws CloneNotSupportedException the clone not supported exception
     */
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

    /**
     * Validates agent.
     *
     * @param agent the agent
     * @return valid
     */
    private static boolean validateAgent(Agent agent) {
        boolean isValid = !agentList.contains(agent);
        return isValid;
    }

    /**
     * Gets agent by user session.
     *
     * @param userSession the user session
     * @return the agent by user session
     */
    public Agent getAgentByUserSession(UserSession userSession) {
        return this.agentList.
                stream()
                .filter((agent) -> new Email(agent.getEmailAddress()).equals(userSession.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Agent is logged in."));
    }

    /**
     * Gets agent by email.
     *
     * @param email the email
     * @return the agent by email
     */
    public Agent getAgentByEmail(String email) {
        for (Agent agent : agentList) {
            if (email.equals(agent.getEmailAddress())) {
                return agent;
            }
        }
        return null;
    }
}
