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

public class RequestRepository implements Serializable {
    /**
     * List of requests
     */
    List<Request> requestList = new ArrayList<>();

    List<Request> acceptedRequestList = new ArrayList<>();

    List<Request> declinedRequestList = new ArrayList<>();

    /**
     * Get property types
     */
    public List<Request> getRequests() {
        return List.copyOf(requestList);
    }

    public boolean add(Request request) {

        if(validateRequest(request)){
            return true;
        }
        return false;
    }

    public  Request addRequest(Request request) {
        if (validateRequest(request))
            requestList.add(request);
        return request;
    }

    public Request removeRequest(Request request) {
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


    private  boolean validateRequest(Request request) {
        boolean isValid = !requestList.contains(request);
        return isValid;
    }

    public List<Request> getRequestAssignedList(Agent agent) {
        List<Request> assignedList = new ArrayList<>();
        for (Request request : this.requestList) {
            if (request.getAgent().getEmailAddress().equalsIgnoreCase(agent.getEmailAddress())) {
                assignedList.add(request);
            }
        }
        return assignedList;
    }

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

    public List<Request> getAgentList(Agent agent) {
        List<Request> newList = new ArrayList<>();
        for (int i = 0 ; i < requestList.size(); i++){
            if (requestList.get(i).getAgent().equals(agent)){
                newList.add(requestList.get(i));
            }
        }
        return newList;
    }

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
}
