package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class State {
    private String name;

    public State(String name) {
        if (name == null || name.length() != 2 || !name.equals(name.toUpperCase())) {
            throw new IllegalArgumentException("Name must be two capital letters.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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