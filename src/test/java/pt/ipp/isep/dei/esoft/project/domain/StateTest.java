package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    @Test
    public void testGetName() {
        State state = new State("California");
        assertEquals("California", state.getName());
    }

    @Test
    public void testSetName() {
        State state = new State();
        state.setName("New York");
        assertEquals("New York", state.getName());
    }
}