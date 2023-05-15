package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class State {
    /**
     * State name
     */
    private String name;
    /**
     * Method that creates a State with name
     * @param name name of the state
     */
    public State(String name) {
        this.name = name;
    }
    /**
     * Method to show the state name
     * @return state name
     */
    public String getName() {
        return name;
    }
    /**
     * Method to change the name of the state
     * @param name changed name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Compares two instances of State
     * @param o other instance of State
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    /**
     * Textual representation of an instance of Owner
     */
    @Override
    public String toString() {
        return "State{" + "name='" + name + '\'' + '}';
    }
}