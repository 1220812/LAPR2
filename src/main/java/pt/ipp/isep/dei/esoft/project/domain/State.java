package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class State {
    private String name;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public State clone(){
        return new State(this.name);
    }

    @Override
    public boolean equals(Object o) {
        State state = (State) o;
        return Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "State{" + "name='" + name + '\'' + '}';
    }
}