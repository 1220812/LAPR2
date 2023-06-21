package pt.ipp.isep.dei.esoft.project.repository;

import org.apache.commons.lang3.NotImplementedException;
import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Request type repository.
 */
public class RequestTypeRepository implements Serializable {
    /**
     * Creation of a list to store request types
     */
    private final List<RequestType> requestTypes = new ArrayList<>();

    /**
     * Method to get the list of request types
     *
     * @return list of request types
     */
    public List<RequestType> getRequestTypeList() {
        return List.copyOf(requestTypes);
    }

    /**
     * Method to add a new request type to the list
     *
     * @param requestType request type to add
     * @return request type list with new one added
     */
    public boolean validateRequestType(RequestType requestType) {
        return !this.requestTypes.contains(requestType);
    }

    /**
     * Method to add a new request type to the list
     *
     * @param requestType request type to add
     * @return true if the request type is added, false if not
     */
    public boolean add(RequestType requestType) {
        boolean addRequestType = false;
        if (validateRequestType(requestType)) {
            addRequestType = this.requestTypes.add(requestType);
        }
        return addRequestType;
    }

    /**
     * Method that creates a new request type
     *
     * @param contractDuration contract duration
     * @param requestType      request type
     * @return optional value of the request type
     */
    public Optional<RequestType> CreateRentRequestType(int contractDuration, String requestType) {
        Optional<RequestType> optionalValue = Optional.empty();
        RequestType requestType1 = new RequestType(requestType, contractDuration);
        if (add(requestType1)) {
            optionalValue = Optional.of(requestType1);
        }
        return optionalValue;
    }

    /**
     * Method that creates a new request type
     *
     * @param requestType request type
     * @return optional value of the request type
     */
    public Optional<RequestType> CreateSellRequestType(String requestType) {
        Optional<RequestType> optionalValue = Optional.empty();
        RequestType requestType1 = new RequestType(requestType);
        if (add(requestType1)) {
            optionalValue = Optional.of(requestType1);
        }
        return optionalValue;
    }
}
