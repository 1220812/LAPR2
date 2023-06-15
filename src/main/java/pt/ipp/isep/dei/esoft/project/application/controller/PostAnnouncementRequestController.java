package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;

/**
 * Post announcement request controller.
 */
public class PostAnnouncementRequestController {
    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();

    /**
     * Get requests list.
     *
     * @return the list
     */
    public List<Request> getRequests(){
        return repositories.getRequestRepository().getRequests();
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
     * Gets request assigned list.
     *
     * @param agent the agent
     * @return the request assigned list
     */
    public List<Request> getRequestAssignedList(Agent agent) {
        return this.repositories.getRequestRepository().getRequestAssignedList(agent);
    }

    /**
     * Accept request list.
     *
     * @param request the request
     * @return the list
     */
    public List<Request> acceptRequest(Request request) {
        this.repositories.getRequestRepository().removeRequest(request);
        return this.repositories.getRequestRepository().addAccepted(request);
    }

    /**
     * Decline request list.
     *
     * @param request the request
     * @return the list
     */
    public List<Request> declineRequest(Request request) {
        this.repositories.getRequestRepository().removeRequest(request);
        return this.repositories.getRequestRepository().addDeclined(request);
    }

    /**
     * Register announcement.
     *
     * @param announcement the announcement
     * @return the announcement
     */
    public Announcement registerAnnouncement(Announcement announcement){
        return AnnouncementRepository.addAnnouncement(announcement);
    }}
