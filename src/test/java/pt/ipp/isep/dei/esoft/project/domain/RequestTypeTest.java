package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTypeTest {

    @Test
    void getRequestType() {
        RequestType requestType = new RequestType("Sell");
        assertEquals("Sell", requestType.getRequestType());
    }

    @Test
    void setRequestType() {
        RequestType requestType = new RequestType("Sell");
        requestType.setRequestType("Rent");
        assertEquals("Rent", requestType.getRequestType());
    }

    @Test
    void setContractDuration() {
        RequestType requestType = new RequestType("Rent", 12);
        requestType.setContractDuration(24);
        assertEquals(24, requestType.getContractDuration());
    }

    @Test
    void getContractDuration() {
        RequestType requestType = new RequestType("Rent", 12);
        assertEquals(12, requestType.getContractDuration());
    }

    @Test
    void testEquals() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType requestType1 = new RequestType("Rent", 12);
        assertTrue(requestType.equals(requestType1));
    }

    @Test
    void testHashCode() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType requestType1 = new RequestType("Rent", 12);
        assertEquals(requestType.hashCode(), requestType1.hashCode());
    }

    @Test
    void testClone() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType requestType1 = requestType.clone();
        assertEquals(requestType, requestType1);
    }
}