package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {
    /**
     * Role description
     */
    public String description;
    /**
     * Role by default
     */
    public static final String DEFAULT_ROLE = "None";

    /**
     * Instantiates a new role
     *
     * @param description
     */
    public Role(String description) {
        this.description = description;
    }

    /**
     * Instantiates a new role with the attributes by default
     */
    public Role() {
        this.description = DEFAULT_ROLE;
    }

    /**
     * Method to show the role description
     */

    public String getDescription() {
        return description;
    }

    /**
     * Method to change the role description
     *
     * @param description changed role description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method to compare two roles
     *
     * @param o role to compare
     * @return true if the roles are equal, false if not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(description, role.description);
    }

    /**
     * Method to show the hashcode of the role
     *
     * @return hashcode of the role
     */

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    /**
     * Method to show the role description
     *
     * @return role description
     */

    @Override
    public String toString() {
        return description;
    }

    /**
     * Method to clone a role
     *
     * @return cloned role
     */

    public Role clone() {
        return new Role(this.description);
    }
}
