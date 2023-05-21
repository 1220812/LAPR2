package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.ArrayList;
import java.util.List;

public class RequestTypeRepository {
    private final List<RequestType> requestTypes = new ArrayList<>();

    public List<RequestType> getRequestTypeList(){
        return List.copyOf(requestTypes);
    }

    /**
     * Method to add a new request type to the list
     * @param requestType request type to add
     * @return request type list with new one added
     */
    public List<RequestType> add(RequestType requestType){
        getRequestTypeList().add(requestType);
        return requestTypes;
    }
    public boolean validateRequestType(RequestType requestType){
        return !this.requestTypes.contains(requestType);
    }
    public List<RequestType> getRequestTypes(){
        return List.copyOf(this.requestTypes);
    }
}
