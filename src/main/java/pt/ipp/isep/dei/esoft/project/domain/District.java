package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The District class represents a district with a name.
 */
public class District {
    /**
     * The name of the District.
     */
    private String name;

    /**
     * Constructs a District object with the given name.
     *
     * @param name the name of the District.
     */
    public District(String name) {
        this.name = name;
    }

    /**
     * returns the name of the District.
     *
     * @return the name of the District.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the District.
     *
     * @param name of the District.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the hash code of the District object based on its name field.
     *
     * @return the hash code of the District object
     */

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * Compares two District objects for equality based on their name fields.
     *
     * @param o the object to compare to this District object.
     * @return true if the objects are equal, false if otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof District)) return false;
        District district = (District) o;
        return Objects.equals(getName(), district.getName());
    }

    /**
     * Creates and returns a copy of the District object.
     *
     * @return a copy of the District object
     * @throws CloneNotSupportedException if the class does not support the clone.
     */
    @Override
    protected District clone() throws CloneNotSupportedException {
        return new District(this.name);
    }
}