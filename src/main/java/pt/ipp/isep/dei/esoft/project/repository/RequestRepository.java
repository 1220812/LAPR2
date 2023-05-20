package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestRepository {
    /**
     * List of requests
     */
    private static List<Request> requests = new ArrayList<>() {
    };
    /**
     * Get property types
     */
    public List<Request> getRequests(){
        return List.copyOf(requests);
    }
    private boolean validateRequest(Request request) {
        boolean isValid = !requests.contains(request);
        return isValid;
    }
    public List<Request> add(Request request){
        requests.add(request);
        Optional<Request> newRequest = Optional.empty();
        boolean operationSuccess = false;
        if(validateRequest(request)){
            newRequest = Optional.of(request.clone());
            operationSuccess = requests.add(newRequest.get());
        }
        if(!operationSuccess){
            newRequest = Optional.empty();
        }
        return requests;
    }
}
