package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;

public class PostAnnouncementRequestController {
    Repositories repositories = Repositories.getInstance();

    public List<Request> getRequests(){
        return repositories.getRequestRepository().getRequests();
    }

    public Agent getCurrentAgent() {
        return this.repositories.getAgentRepository().getAgentByUserSession(getCurrentSession());
    }

    public UserSession getCurrentSession(){
        return this.repositories.getAuthenticationRepository().getCurrentUserSession();
    }

    public List<Request> getRequestAssignedList(Agent agent) {
        return this.repositories.getRequestRepository().getRequestAssignedList(agent);
    }

}
