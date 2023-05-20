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
     * Method to change the state name
     * @param name changed state name
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}