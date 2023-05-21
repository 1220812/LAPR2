package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StateRepository {
    private List<State> stateList = new ArrayList<>();
    public void addState(State state) {
        if(validateState(state)){
            stateList.add(state);
        }
    }

    public List<State> getStateList(){
        return List.copyOf(this.stateList);
    }
    public static State CreateState(String name){
        return new State(name);
    }


    public List<State> add(State state) {

        stateList.add(state);

        Optional<State> newState = Optional.empty();
        boolean operationSuccess = false;

        if (validateState(state)) {
            newState = Optional.of((State) state.clone());
            operationSuccess = stateList.add((State) newState.get());
        }

        if (!operationSuccess) {
            newState = Optional.empty();
        }
        return stateList;
    }
    private boolean validateState(State state) {
        boolean isValid = !stateList.contains(state);
        return isValid;
    }
}