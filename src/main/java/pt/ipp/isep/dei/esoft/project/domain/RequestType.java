package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class RequestType {
    /**
     * Request type
     */
    private String requestType;
    /**
     * Contract duration
     */
    private double contractDuration;
    /**
     * contract duration by default
     */
    private static final double DEFAULT_CONTRACT_DURATION = 0;

    /**
     * Creates a new instance of request type
     *
     * @param requestType request type
     */
    public RequestType(String requestType, double contractDuration) {
        this.requestType = requestType;
        this.contractDuration = contractDuration;
    }

    /**
     * Method that creates a new instance of request type with the attributes by default
     *
     * @param requestType request type
     */
    public RequestType(String requestType) {
        this.requestType = requestType;
        contractDuration = DEFAULT_CONTRACT_DURATION;
    }

    /**
     * Shows the request type
     *
     * @return
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Changes the request type
     *
     * @param requestType changed request type
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * Method to change the contract duration
     *
     * @param contractDuration changed contract duration
     */
    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }

    /**
     * Method to show the contract duration
     *
     * @return contract duration
     */
    public double getContractDuration() {
        return contractDuration;
    }

    /**
     * Method to show the request type description
     *
     * @return request type description
     */
    @Override
    public String toString() {
        if(requestType.equalsIgnoreCase("Rent"))
            return "RequestType = " + requestType + "\nContract duration = " + contractDuration;
        else return "RequestType = " + requestType;
    }

    /**
     * Method to compare two request types
     *
     * @param o request type TO be compared
     * @return true if they are equal, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestType that = (RequestType) o;
        return Objects.equals(requestType, that.requestType);
    }

    /**
     * Method to calculate the hashcode of a request type
     *
     * @return hashcode of a request type
     */
    @Override
    public int hashCode() {
        return Objects.hash(requestType);
    }

    /**
     * Method to clone a request type
     *
     * @return cloned request type
     */
    @Override
    public RequestType clone() {
        return new RequestType(this.requestType);
    }
}
