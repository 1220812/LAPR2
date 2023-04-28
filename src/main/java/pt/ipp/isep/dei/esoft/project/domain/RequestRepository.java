package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
public class RequestRepository {

    private final String description;

    public RequestRepositoy(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestRepository)) {
            return false;
        }
        RequestRepository that = (RequestRepository) o;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    public String getDescription() {
        return description;
    }

    public RequestRepository clone() {
        return new RequestRepository(this.description);
    }

}
