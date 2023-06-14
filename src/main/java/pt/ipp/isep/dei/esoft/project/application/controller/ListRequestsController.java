package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Message;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ListRequestsController {

    Repositories repositories = Repositories.getInstance();
    Agent agent = repositories.getAgentRepository().getAgent();

    public List<Request> getRequests() {
        return Repositories.getInstance().getRequestRepository().getRequests();
    }

    public List<Request> getRequestsSorted(List<Request> requestList) throws IOException {
        return Repositories.getInstance().getRequestRepository().getRequestsSorted(requestList);
    }

    public List<Request> getRequestDated(List<Request> RequestList, LocalDate startDate, LocalDate endDate) {
        return Request.getRequests(RequestList, startDate, endDate);
    }

    public boolean checkDay(int startDay) {
       return Request.checkDay(startDay);
    }

    public boolean checkMonth(int startMonth) {
        return Request.checkMonth(startMonth);
    }

    public boolean checkYear(int startYear) {
        return Request.checkYear(startYear);
    }

    public boolean checkVisitTime(LocalDate newStartTime, LocalDate newEndTime) {
        return Request.checkVisitTime(newStartTime, newEndTime);
    }
    public List<Request> getAgentList() {
        return repositories.getRequestRepository().getAgentList(agent);
    }

    public List<Request> getSortedVisitRequestList(List<Request> list, LocalDate begin, LocalDate end){
        return repositories.getRequestRepository().getSortedVisitRequestList(list, begin, end);
    }
    public Agent getCurrentAgent() {
        AuthenticationRepository rep = Repositories.getInstance().getAuthenticationRepository();
        UserSession us = rep.getCurrentUserSession();
        String email = us.getUserId().getEmail();
        return Repositories.getInstance().getAgentRepository().getAgentByEmail(email);
    }
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

