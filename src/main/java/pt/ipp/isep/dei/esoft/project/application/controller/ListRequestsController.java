package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.util.List;

public class ListRequestsController {
    public void ListRequestsController() {
        Repositories repositories = Repositories.getInstance();
    }

    public List<Request> getRequests() {
        return Repositories.getInstance().getRequestRepository().getRequests();
    }

    public List<Request> getRequestsSorted() {
        return Repositories.getInstance().getRequestRepository().getRequestsSorted();
    }

    public List<Request> getRequestDated(List<Request> RequestList, LocalDate startDate, LocalDate endDate) {
        return Request.getRequests(RequestList, startDate, endDate);
    }
}

