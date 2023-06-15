package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.RequestType;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RequestTypeRepositoryTest {

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

    @Test
    void validateRequestType() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent");
        boolean isValid = requestTypeRepository.validateRequestType(requestType);
        assertTrue(isValid);
    }

    @Test
    void add() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent");
        boolean addRequestType = requestTypeRepository.add(requestType);
        assertTrue(addRequestType);
    }

    @Test
    void createRentRequestType() {
        RequestTypeRepository requestTypeRepository = new RequestTypeRepository();
        RequestType requestType = new RequestType("Rent", 12);
        Optional<RequestType> optionalValue = requestTypeRepository.CreateRentRequestType(12, "Rent");
        assertTrue(optionalValue.isPresent());
        List<RequestType> requestTypes = requestTypeRepository.getRequestTypeList();
        assertTrue(requestTypes.contains(requestType));
    }

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