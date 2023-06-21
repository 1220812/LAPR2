package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.State;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type State repository.
 */
public class StateRepository implements Serializable {
    private List<State> stateList = new ArrayList<>();

    /**
     * Add state.
     *
     * @param state the state
     */
    public void addState(State state) {
        if(validateState(state)){
            stateList.add(state);
        }
    }

    /**
     * Get state list list.
     *
     * @return the list
     */
    public List<State> getStateList(){
        return List.copyOf(this.stateList);
    }


    /**
     * Add list.
     *
     * @param state the state
     * @return the list
     */
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