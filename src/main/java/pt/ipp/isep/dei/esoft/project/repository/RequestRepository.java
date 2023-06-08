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
    public static Request addRequest(Request request){
        if(validateRequest(request))
            requestList.add(request);
        return request;
    }

    public Request removeRequest(Request request){
        requestList.remove(request);
        return request;
    }


    public List<Request> addAccepted(Request request) {
        acceptedRequestList.add(request);
        return acceptedRequestList;
    }

    public List<Request> addDeclined(Request request) {

        declinedRequestList.add(request);
        return declinedRequestList;
    }


    private static boolean validateRequest(Request request) {
        boolean isValid = !requestList.contains(request);
        return isValid;
    }

    public List<Request> getRequestAssignedList(Agent agent) {
        List<Request> assignedList = new ArrayList<>();
        for (Request request : this.requestList) {
            if (request.getAgent().getEmailAddress().equals(agent.getEmailAddress())) {
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
