package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StateRepositoryTest {

    @Test
    void addState() {
        StateRepository stateRepository = new StateRepository();
        State state = new State("California");
        stateRepository.addState(state);
        assertTrue(stateRepository.getStateList().contains(state));
    }

    @Test
    void getStateList() {
        StateRepository stateRepository = new StateRepository();
        State state = new State("California");
        stateRepository.addState(state);
        List<State> states = stateRepository.getStateList();
        assertNotSame(states, stateRepository.getStateList());
        assertTrue(states.contains(state));
    }
}