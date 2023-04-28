package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Places.State;

import java.util.List;
public class StateRepository {

    private List<State> stateList;

    public List<State> getStateList() {
        return stateList;
    }

    public void registerState(State state) {
        stateList.add(state);
    }

    public boolean checkDesignation(String designation) {
        for (State state : stateList) {
            if (state.getStatename().equals(designation)) {
                return true;
            }
        }
        return false;
    }

    public void getStateByName (String stateName){

    }
}
