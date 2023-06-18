package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Request type repository test.
 */
class RequestTypeRepositoryTest {

    /**
     * Gets request type list.
     */
    @Test
    void getRequestTypeList() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent");
        RequestType requestType1 = new RequestType("Sell");
        requestTypeRepository.add(requestType);
        requestTypeRepository.add(requestType1);
        List<RequestType> requestTypes = requestTypeRepository.getRequestTypeList();
        assertNotSame(requestTypes, requestTypeRepository.getRequestTypeList());
        assertTrue(requestTypes.contains(requestType));
        assertTrue(requestTypes.contains(requestType1));
    }

    /**
     * Validate request type.
     */
    @Test
    void validateRequestType() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent");
        boolean isValid = requestTypeRepository.validateRequestType(requestType);
        assertTrue(isValid);
    }

    /**
     * Add.
     */
    @Test
    void add() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent");
        boolean addRequestType = requestTypeRepository.add(requestType);
        assertTrue(addRequestType);
    }

    /**
     * Create rent request type.
     */
    @Test
    void createRentRequestType() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent", 12);
        Optional<RequestType> optionalValue = requestTypeRepository.CreateRentRequestType(12, "Rent");
        assertTrue(optionalValue.isPresent());
        List<RequestType> requestTypes = requestTypeRepository.getRequestTypeList();
        assertTrue(requestTypes.contains(requestType));
    }

    /**
     * Create sell request type.
     */
    @Test
    void createSellRequestType() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Sell");
        Optional<RequestType> optionalValue = requestTypeRepository.CreateSellRequestType("Sell");
        assertTrue(optionalValue.isPresent());
        List<RequestType> requestTypes = requestTypeRepository.getRequestTypeList();
        assertTrue(requestTypes.contains(requestType));
    }
}