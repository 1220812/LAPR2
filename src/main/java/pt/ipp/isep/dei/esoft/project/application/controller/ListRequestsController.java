package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.MessageRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * The type List requests controller.
 */
public class ListRequestsController {

    /**
     * The Repositories.
     */
    Repositories repositories = Repositories.getInstance();
    /**
     * The Agent.
     */
    Agent agent = repositories.getAgentRepository().getAgent();

    /**
     * Gets messages.
     *
     * @return the messages
     */
    public List<Message> getMessages() {
        return MessageRepository.getMessageList();
    }

    /**
     * Gets messages sorted.
     *
     * @param messageList the message list
     * @return the messages sorted
     * @throws IOException the io exception
     */
    public List<Message> getMessagesSorted(List<Message> messageList) throws IOException {
        return Repositories.getInstance().getMessageRepository().getMessageSorted(messageList);
    }

    /**
     * Gets request dated.
     *
     * @param RequestList the request list
     * @param startDate   the start date
     * @param endDate     the end date
     * @return the request dated
     */
    public List<Request> getRequestDated(List<Request> RequestList, LocalDate startDate, LocalDate endDate) {
        return Request.getRequests(RequestList, startDate, endDate);
    }

    /**
     * Check day boolean.
     *
     * @param startDay the start day
     * @return the boolean
     */
    public boolean checkDay(int startDay) {
       return Request.checkDay(startDay);
    }

    /**
     * Check month boolean.
     *
     * @param startMonth the start month
     * @return the boolean
     */
    public boolean checkMonth(int startMonth) {
        return Request.checkMonth(startMonth);
    }

    /**
     * Check year boolean.
     *
     * @param startYear the start year
     * @return the boolean
     */
    public boolean checkYear(int startYear) {
        return Request.checkYear(startYear);
    }

    /**
     * Check visit time boolean.
     *
     * @param newStartTime the new start time
     * @param newEndTime   the new end time
     * @return the boolean
     */
    public boolean checkVisitTime(LocalDate newStartTime, LocalDate newEndTime) {
        return Request.checkVisitTime(newStartTime, newEndTime);
    }

    /**
     * Gets agent list.
     *
     * @return the agent list
     */
    public List<Request> getAgentList() {
        return repositories.getRequestRepository().getAgentList(agent);
    }

    /**
     * Get sorted visit request list list.
     *
     * @param list  the list
     * @param begin the begin
     * @param end   the end
     * @return the list
     */
    public List<Request> getSortedVisitRequestList(List<Request> list, LocalDate begin, LocalDate end){
        return repositories.getRequestRepository().getSortedVisitRequestList(list, begin, end);
    }

    /**
     * Gets current agent.
     *
     * @return the current agent
     */
    public Agent getCurrentAgent() {
        AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
        UserSession us = rep.getCurrentUserSession();
        String email = us.getUserId().getEmail();
        return Repositories.getInstance().getAgentRepository().getAgentByEmail(email);
    }

    /**
     * Show booking requests.
     */
    public void showBookingRequests() {
        List<Request> RequestList = Repositories.getInstance().getRequestRepository().getRequests();
        Agent loggedInAgent = getCurrentAgent();
        for (int i = 0; i < RequestList.size(); i++) {
            if((loggedInAgent.equals(RequestList.get(i).getAgent())) ){
                System.out.println("Booking Request#" + (i + 1) + ": " + RequestList.get(i).toString());
            }
        }
    }
}

