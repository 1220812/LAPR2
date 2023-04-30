package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Request;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.List;

public class StateRepository {
    private List<State> stateList;
    public List<State> getStateList() { return List.copyOf(this.stateList);
    }
    public boolean request(State state) {
        if(this.stateList.contains(state)) {
            return false;
        }
        else {
            State newState = state.clone();
            this.stateList.add(newState);
            return true;
        }
    }

<<<<<<< HEAD
    public void getStateByName (String stateName) {

=======
    public State createState(String name) {
        State state = null;
        try {
            state = new State(name);
        } catch (IllegalArgumentException e) {
            System.out.println("Attribute value is invalid.");
            System.out.println(e.getMessage());
        }
        return state;
>>>>>>> 568a46155f1102bfde63cc913206d8a3986fc30f
    }
}
