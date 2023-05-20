package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;
import java.util.List;

public class StateRepository {
    private List<State> stateList = new ArrayList<>();
    public void addState(State state) {
        if(validateState(state)){
            stateList.add(state);
        }
    }
    public boolean validateState(State state){
        return !this.stateList.contains(state);
    }
    public List<State> getStateList(){
        return List.copyOf(this.stateList);
    }
    public static State CreateState(String name){
        return new State(name);
    }
}