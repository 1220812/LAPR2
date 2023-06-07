package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.LocalDate;
import java.util.*;

public class RequestRepository {
    /**
     * List of requests
     */
    private static List<Request> requestList = new ArrayList<>();

    private static List<Request> acceptedRequestList = new ArrayList<>();

    private static List<Request> declinedRequestList = new ArrayList<>();

    /**
     * Get property types
     */
    public List<Request> getRequests() {
        return List.copyOf(requestList);
    }

    public boolean addRequest(Request request) {
        boolean success = false;
        if (validateRequest(request)) {
            success = requestList.add(request);
        }
        return success;
    }
    public Optional <Request> CreateSaleRequest(Property property, LocalDate requestDate, Agent agent, Store store, Owner owner, double price, RequestType requestType){
        Optional<Request> optionalValue = Optional.empty();
        Request saleRequest = new Request(property,requestDate,agent,owner,price,requestType);
        if(addRequest(saleRequest)){
            optionalValue = Optional.of(saleRequest);
        }
        return optionalValue;
    }
    public Optional <Request> CreateRentRequest(Property property, LocalDate requestDate, PropertyType propertyType, Agent agent, Store store, Owner owner, int contractDuration, double price, RequestType requestType){
        Optional <Request> optionalValue = Optional.empty();
        Request rentRequest = new Request(property,requestDate,propertyType,agent,store,owner,contractDuration,price, requestType);
        if(addRequest(rentRequest)){
            optionalValue = Optional.of(rentRequest);
        }
        return optionalValue;
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

    public List<Request> addAccepted(Request request) {

        acceptedRequestList.add(request);

        Optional<Request> newRequest = Optional.empty();
        boolean operationSuccess = false;

        if (validateRequest(request)) {
            newRequest = Optional.of((Request) request.clone());
            operationSuccess = acceptedRequestList.add((Request) newRequest.get());
        }

        if (!operationSuccess) {
            newRequest = Optional.empty();
        }
        return acceptedRequestList;
    }

    public List<Request> addDeclined(Request request) {

        declinedRequestList.add(request);

        Optional<Request> newRequest = Optional.empty();
        boolean operationSuccess = false;

        if (validateRequest(request)) {
            newRequest = Optional.of((Request) request.clone());
            operationSuccess = declinedRequestList.add((Request) newRequest.get());
        }

        if (!operationSuccess) {
            newRequest = Optional.empty();
        }
        return declinedRequestList;
    }


    private boolean validateRequest(Request request) {
        boolean isValid = !requestList.contains(request);
        return isValid;
    }

    public List<Request> getRequestAssignedList(Agent agent) {
        List<Request> assignedList = new ArrayList<>();
        for (Request request : this.requestList) {
            if (request.getAgentEmail().equals(agent.getEmailAddress())) {
                assignedList.add(request);
            }
        }
        return assignedList;
    }

    public List<Request> getRequestsSorted() {
        requestList.sort(Comparator.comparing(Request::getRequestDate));
        return requestList;
    }

}
