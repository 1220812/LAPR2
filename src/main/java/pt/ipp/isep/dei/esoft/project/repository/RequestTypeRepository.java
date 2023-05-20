package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.ArrayList;
import java.util.List;

public class RequestTypeRepository {
    /**
     * request types list
     */
    private final List<RequestType> requestTypes = new ArrayList<>();
    /**
     * Method to show the request type list
     */
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
}
