package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type State test.
 */
class StateTest {
    /**
     * Test get name.
     */
    @Test
    public void testGetName() {
        State state = new State("California");
        assertEquals("California", state.getName());
    }

    /**
     * Test set name.
     */
    @Test
    public void testSetName() {
        State state = new State();
        state.setName("New York");
        assertEquals("New York", state.getName());
    }
}