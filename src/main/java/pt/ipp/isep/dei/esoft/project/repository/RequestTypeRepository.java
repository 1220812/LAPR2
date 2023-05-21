package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean validateRequestType(RequestType requestType){
        return !this.requestTypes.contains(requestType);
    }
    public List<RequestType> getRequestTypes(){
        return List.copyOf(this.requestTypes);
    }

    public List<RequestType> add(RequestType requestType) {

        requestTypes.add(requestType);

        Optional<RequestType> newRequestType = Optional.empty();
        boolean operationSuccess = false;

        if (validateRequestType(requestType)) {
            newRequestType = Optional.of((RequestType) requestType.clone());
            operationSuccess = requestTypes.add((RequestType) newRequestType.get());
        }

        if (!operationSuccess) {
            newRequestType = Optional.empty();
        }
        return requestTypes;
    }
    private boolean validateEquipment(RequestType requestType) {
        boolean isValid = !requestTypes.contains(requestType);
        return isValid;
    }
}
