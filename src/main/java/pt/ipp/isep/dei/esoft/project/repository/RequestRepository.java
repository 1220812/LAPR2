package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.MergeSort;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * The type Request repository.
 */
public class RequestRepository implements Serializable {
    private static final long serialVersionUID = -958191308379930267L;
    /**
     * The Request list.
     */
    List<Request> requestList = new ArrayList<>();

    /**
     * The Accepted request list.
     */
    List<Request> acceptedRequestList = new ArrayList<>();

    /**
     * The Declined request list.
     */
    List<Request> declinedRequestList = new ArrayList<>();

    /**
     * Get property types
     *
     * @return the requests
     */
    public List<Request> getRequests() {
        return List.copyOf(requestList);
    }

    /**
     * Add boolean.
     *
     * @param request the request
     * @return the boolean
     */
    public boolean add(Request request) {

        if(validateRequest(request)){
            return true;
        }
        return false;
    }

    /**
     * Add request request.
     *
     * @param request the request
     * @return the request
     */
    public  Request addRequest(Request request) {
        if (validateRequest(request))
            requestList.add(request);
        return request;
    }

    /**
     * Remove request request.
     *
     * @param request the request
     * @return the request
     */
    public Request removeRequest(Request request) {
        requestList.remove(request);
        return request;
    }


    /**
     * Add accepted list.
     *
     * @param request the request
     * @return the list
     */
    public List<Request> addAccepted(Request request) {
        acceptedRequestList.add(request);
        return acceptedRequestList;
    }

    /**
     * Add declined list.
     *
     * @param request the request
     * @return the list
     */
    public List<Request> addDeclined(Request request) {

        declinedRequestList.add(request);
        return declinedRequestList;
    }


    private  boolean validateRequest(Request request) {
        boolean isValid = !requestList.contains(request);
        return isValid;
    }

    /**
     * Gets request assigned list.
     *
     * @param agent the agent
     * @return the request assigned list
     */
    public List<Request> getRequestAssignedList(Agent agent) {
        List<Request> assignedList = new ArrayList<>();
        for (Request request : this.requestList) {
            if (request.getAgent().getEmailAddress().equalsIgnoreCase(agent.getEmailAddress())) {
                assignedList.add(request);
            }
        }
        return assignedList;
    }

    /**
     * The Final list.
     */
    List<Request> finalList = new ArrayList<>();

//    public List<Request> getRequestsSorted(List<Request> requestList) throws IOException {
//        Properties properties = System.getProperties();
//        properties.load(new FileReader("src/main/resources/sortingMethods.properties"));
//        String algorithm = properties.getProperty("sorting.algorithm");
//
//        switch (algorithm.toUpperCase()) {
//            case "MERGESORT":
//                MergeSort merge = new MergeSort();
//                //finalList = merge.merge(requestList);
//
//
//
//                break;
//            case "SORTINGBUBBLES":
//                BubbleSort bubbleSort = new BubbleSort();
//                finalList = bubbleSort.sortByDate(requestList);
//                break;
//            default:
//                System.out.println("Warning: invalid");
////                finalList = merge.merge(requestList);
//        }
//        return finalList;
//    }

    /**
     * Gets agent list.
     *
     * @param agent the agent
     * @return the agent list
     */
    public List<Request> getAgentList(Agent agent) {
        List<Request> newList = new ArrayList<>();
        for (int i = 0 ; i < requestList.size(); i++){
            if (requestList.get(i).getAgent().equals(agent)){
                newList.add(requestList.get(i));
            }
        }
        return newList;
    }

    /**
     * Gets sorted visit request list.
     *
     * @param list  the list
     * @param begin the begin
     * @param end   the end
     * @return the sorted visit request list
     */
    public List<Request> getSortedVisitRequestList(List<Request> list, LocalDate begin, LocalDate end) {
        List<Request> newList = new ArrayList<>();
        ZoneId zId = ZoneId.systemDefault();

        for (int i = 0; i < list.size(); i++){
            Date beginDate = Date.from(begin.atStartOfDay(zId).toInstant());
            Date endDate = Date.from(end.atStartOfDay(zId).toInstant());

            String requestDate = list.get(i).getRequestDate().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateRequest = null;

            try {
                dateRequest = sdf.parse(requestDate);
            } catch (ParseException e) {
                throw new RuntimeException("The date format in the system is wrong!");
            }

            if(dateRequest.after(beginDate) && dateRequest.before(endDate)){
                newList.add(list.get(i));
            }

        }
        return newList;
    }

    /**
     * Gets requests sorted.
     *
     * @param requests the requests
     * @return the requests sorted
     */
    public List<Request> getRequestsSorted(List<Request> requests) {
        return requestList;
    }
}
