package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Request type test.
 */
class RequestTypeTest {

    /**
     * Gets request type.
     */
    @Test
    void getRequestType() {
        RequestType requestType = new RequestType("Sell");
        assertEquals("Sell", requestType.getRequestType());
    }

    /**
     * Sets request type.
     */
    @Test
    void setRequestType() {
        RequestType requestType = new RequestType("Sell");
        requestType.setRequestType("Rent");
        assertEquals("Rent", requestType.getRequestType());
    }

    /**
     * Sets contract duration.
     */
    @Test
    void setContractDuration() {
        RequestType requestType = new RequestType("Rent", 12);
        requestType.setContractDuration(24);
        assertEquals(24, requestType.getContractDuration());
    }

    /**
     * Gets contract duration.
     */
    @Test
    void getContractDuration() {
        RequestType requestType = new RequestType("Rent", 12);
        assertEquals(12, requestType.getContractDuration());
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType requestType1 = new RequestType("Rent", 12);
        assertTrue(requestType.equals(requestType1));
    }

    /**
     * Test hash code.
     */
    @Test
    void testHashCode() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType requestType1 = new RequestType("Rent", 12);
        assertEquals(requestType.hashCode(), requestType1.hashCode());
    }

    /**
     * Test clone.
     */
    @Test
    void testClone() {
        RequestType requestType = new RequestType("Rent", 12);
        RequestType requestType1 = requestType.clone();
        assertEquals(requestType, requestType1);
    }
}