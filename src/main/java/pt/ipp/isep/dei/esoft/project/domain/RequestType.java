package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class RequestType {
    private String requestType;
    private double contractDuration;

    private static final double DEFAULT_CONTRACTDURATION = 0;

    /**
     * Instantiates a new Request type
     * @param requestType request type
     */
    public RequestType (String requestType, double contractDuration){
        this.requestType = requestType;
        this.contractDuration = contractDuration;
    }

    public RequestType (String requestType) {
        this.requestType = requestType;
        contractDuration = DEFAULT_CONTRACTDURATION;
    }

    /**
     * Shows the request type
     * @return
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Changes the request type
     * @param requestType changed request type
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
    @Override
    public String toString() {
        return "RequestType{" +
                "requestType='" + requestType + '\'' +
                '}';
    }

    public void setContractDuration(double contractDuration) {
        this.contractDuration = contractDuration;
    }

    public double getContractDuration() {
        return contractDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestType that = (RequestType) o;
        return Objects.equals(requestType, that.requestType);
    }
    @Override
    public int hashCode() {
        return Objects.hash(requestType);
    }
    @Override
    public RequestType clone() {
        return new RequestType(this.requestType);
    }
}
