package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.StateRepository;

import java.util.Objects;

public class State {
    /**
     * State name
     */
    private String name;
    private static final String DEFAULT_NAME="none";
    /**
     * Method that creates a State with name
     * @param name name of the state
     */
    public State(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of state with name by default
     */
    public State(){
        this.name = DEFAULT_NAME;
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
        return name;
    }
    public State clone(){
        return new State(this.name);
    }

}