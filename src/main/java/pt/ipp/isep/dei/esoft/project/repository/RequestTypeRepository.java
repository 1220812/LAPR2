package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.ArrayList;

public class RequestTypeRepository {
    private static ArrayList<RequestType> requestTypeList = new ArrayList<>();
    public static void addRequestType(RequestType requestType){
        requestTypeList.add(requestType);
    }
    public static ArrayList<RequestType> getRequestTypeList(){
        return requestTypeList;
    }
    public static RequestType CreateRequestType(String name){
        return new RequestType(name);
    }
}
