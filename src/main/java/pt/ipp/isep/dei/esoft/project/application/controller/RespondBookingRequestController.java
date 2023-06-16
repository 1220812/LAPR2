package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;


public class RespondBookingRequestController {

    Repositories repositories;

    AgentRepository agentRepository;

    BookingRequestsRepository bookingRequestsRepository;

    AuthenticationRepository authenticationRepository;

    UserSession userSession;



    String ConfigurationFile;


    public  RespondBookingRequestController() {
        repositories = Repositories.getInstance();
        agentRepository = repositories.getAgentRepository();
        bookingRequestsRepository = repositories.getBookingRequestsRepository();
        authenticationRepository = repositories.getAuthenticationRepository();
        userSession = repositories.getAuthenticationRepository().getCurrentUserSession();
        ConfigurationFile = "";

    }

    public Agent getCurrentAgent() {
        return this.repositories.getAgentRepository().getAgentByUserSession(getCurrentSession());
    }

    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }

    public List<Message> getListOfBookingRequestByAgent(Agent agent) {
        return this.repositories.getMessageRepository().getRequestAssignedList(agent);
    }

    public String getClientEmail(Message message) {
        return repositories.getMessageRepository().getClient(message).getEmailAddress();
    }

    public String getAgentEmail(Agent agent) {
        return repositories.getAgentRepository().getAgent().getEmailAddress();
    }

    public String getAgentName(Agent agent) {
        return repositories.getAgentRepository().getAgent().getName();
    }

    public String getAgentPhone(Agent agent) {
        return repositories.getAgentRepository().getAgent().getPhoneNumber();
    }

    public Announcement getAnnouncement(Message message) {
        return repositories.getMessageRepository().getAnnouncement(message);
    }

    public PropertyType getPropertyType(Announcement announcement) {
        return announcement.getProperty().getPropertyType();
    }

    public Address getAddress(Announcement announcement) {
        return announcement.getProperty().getAddress();
    }

    public void replyMessage(Message message) {
        MessageRepository.removeMessage(message);
        MessageRepository.addComplete(message);
    }
}
