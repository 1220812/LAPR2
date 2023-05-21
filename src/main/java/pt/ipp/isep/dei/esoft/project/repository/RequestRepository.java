package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestRepository {
    /**
     * List of requests
     */
    private static List<Request> requestList = new ArrayList<>() {
    };

    /**
     * Get property types
     */
    public List<Request> getRequests() {
        return List.copyOf(requestList);
    }

    private boolean validateRequest(Request request) {
        return !this.requestList.contains(request);
    }

    public void addRequest(Request request) {
        if (validateRequest(request)) {
            requestList.add(request);
        }
    }
    public static Request CreateRequest(Property property, double price, String requestType, Agent agent, Store store, Owner owner){
        return new Request(property,price,requestType,agent,store,owner);
    }
}
