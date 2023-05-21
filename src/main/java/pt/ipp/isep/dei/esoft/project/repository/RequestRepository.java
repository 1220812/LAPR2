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


    public void addRequest(Request request) {
        if (validateRequest(request)) {
            requestList.add(request);
        }
    }
    public static Request CreateRequest(Property property, double price, String requestType, Agent agent, Store store, Owner owner){
        return new Request(property,price,requestType,agent,store,owner);
    }

    public List<Request> add(Request request) {

        requestList.add(request);

        Optional<Request> newRequest = Optional.empty();
        boolean operationSuccess = false;

        if (validateRequest(request)) {
            newRequest = Optional.of((Request) request.clone());
            operationSuccess = requestList.add((Request) newRequest.get());
        }

        if (!operationSuccess) {
            newRequest = Optional.empty();
        }
        return requestList;
    }
    private boolean validateRequest(Request request) {
        boolean isValid = !requestList.contains(request);
        return isValid;
    }
}
