package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;


/**
 * The type Respond booking request controller.
 */
public class RespondBookingRequestController {

    /**
     * The Repositories.
     */
    Repositories repositories;

    /**
     * The Agent repository.
     */
    AgentRepository agentRepository;

    /**
     * The Authentication repository.
     */
    AuthenticationRepository authenticationRepository;

    /**
     * The User session.
     */
    UserSession userSession;

    /**
     * The Configuration file.
     */
    String ConfigurationFile;


    /**
     * Instantiates a new Respond booking request controller.
     */
    public  RespondBookingRequestController() {
        repositories = Repositories.getInstance();
        agentRepository = repositories.getAgentRepository();
        authenticationRepository = repositories.getAuthenticationRepository();
        userSession = repositories.getAuthenticationRepository().getCurrentUserSession();
        ConfigurationFile = "";

    }

    /**
     * Gets current agent.
     *
     * @return the current agent
     */
    public Agent getCurrentAgent() {
        return this.repositories.getAgentRepository().getAgentByUserSession(getCurrentSession());
    }

    /**
     * Get current session user session.
     *
     * @return the user session
     */
    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }

    /**
     * Gets list of booking request by agent.
     *
     * @param agent the agent
     * @return the list of booking request by agent
     */
    public List<Message> getListOfBookingRequestByAgent(Agent agent) {
        return this.repositories.getMessageRepository().getRequestAssignedList(agent);
    }

    /**
     * Gets client email.
     *
     * @param message the message
     * @return the client email
     */
    public String getClientEmail(Message message) {
        return repositories.getMessageRepository().getClient(message).getEmailAddress();
    }

    /**
     * Gets agent email.
     *
     * @param agent the agent
     * @return the agent email
     */
    public String getAgentEmail(Agent agent) {
        return repositories.getAgentRepository().getAgent().getEmailAddress();
    }

    /**
     * Gets agent name.
     *
     * @param agent the agent
     * @return the agent name
     */
    public String getAgentName(Agent agent) {
        return repositories.getAgentRepository().getAgent().getName();
    }

    /**
     * Gets agent phone.
     *
     * @param agent the agent
     * @return the agent phone
     */
    public String getAgentPhone(Agent agent) {
        return repositories.getAgentRepository().getAgent().getPhoneNumber();
    }

    /**
     * Gets announcement.
     *
     * @param message the message
     * @return the announcement
     */
    public Announcement getAnnouncement(Message message) {
        return repositories.getMessageRepository().getAnnouncement(message);
    }

    /**
     * Gets property type.
     *
     * @param announcement the announcement
     * @return the property type
     */
    public PropertyType getPropertyType(Announcement announcement) {
        return announcement.getProperty().getPropertyType();
    }

    /**
     * Gets address.
     *
     * @param announcement the announcement
     * @return the address
     */
    public Address getAddress(Announcement announcement) {
        return announcement.getProperty().getAddress();
    }

    /**
     * Reply message.
     *
     * @param message      the message
     * @param replyMessage the reply message
     */
    public void replyMessage(Message message, String replyMessage) {
        MessageRepository.removeMessage(message);
        MessageRepository.addComplete(message);
        ReplyRepository.add(replyMessage);
    }
}
