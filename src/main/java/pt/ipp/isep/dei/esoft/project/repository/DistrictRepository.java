package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Places.State;

import java.util.List;
public class DistrictRepository {

    private List<State> districtList;

    public List<State> getDistrictList() {
        return districtList;
    }

    public void registerState(State state) {
        districtList.add(state);
    }

    public boolean checkDesignation(String designation) {
        for (State state : districtList) {
            if (state.getStatename().equals(designation)) {
                return true;
            }
        }
        return false;
    }
}
