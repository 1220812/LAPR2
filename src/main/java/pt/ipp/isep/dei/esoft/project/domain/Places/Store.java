package pt.ipp.isep.dei.esoft.project.domain.Places;

import java.util.Objects;

public class Store {

    String designation;



    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Store{" +
                "designation='" + designation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(designation, store.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }
}
