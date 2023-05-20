package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;

public class StateRepository {
    private static ArrayList<State> stateList = new ArrayList<>();
    public static void addState(State state) {
        stateList.add(state);
    }
    /**
     * Method to show the properties type list
     * @return properties type list
     */
    public static ArrayList<State> getStateList() {
        return stateList;
    }

    public static State CreateState(String name) {
        return new State(name);
    }
}