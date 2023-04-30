package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Address;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;
import java.util.List;

public class RequestRepository {
    List<Request> requestList;
    public RequestRepository (){
        requestList = new ArrayList<>();
    }
    public List<Request> getRequestList() { return List.copyOf(this.requestList);
    }
    public boolean request(Request request) {
        if(this.requestList.contains(request)) {
            return false;
        }
        else {
            Request newRequest = request.clone();
            this.requestList.add(newRequest);
            return true;
        }
    }

    public Request createRequest(Property property, double price, String type) {
        Request request = null;
        try {
            request = new Request(property, price, type);
        } catch (IllegalArgumentException e) {
            System.out.println("Attribute value is invalid.");
            System.out.println(e.getMessage());
        }
        return request;
    }


}
