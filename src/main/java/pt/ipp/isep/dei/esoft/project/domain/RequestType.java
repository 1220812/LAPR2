package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class RequestType {
    private String requestType;

    /**
     * Instantiates a new Request type
     * @param name request type
     */
    public RequestType (String name){
        this.requestType = name;
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
