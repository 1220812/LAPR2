package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Role test.
 */
class RoleTest {

    /**
     * Gets description.
     */
    @Test
    void getDescription() {
        Role role = new Role("Manager");
        assertEquals("Manager", role.getDescription());
    }

    /**
     * Sets description.
     */
    @Test
    void setDescription() {
        Role role = new Role("Manager");
        assertEquals("Manager", role.getDescription());
        role.setDescription("Agent");
        assertEquals("Agent", role.getDescription());
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        Role role = new Role("Manager");
        Role role1 = new Role("Manager");
        Role role2 = new Role("Agent");
        assertEquals(role, role1);
        assertNotEquals(role, role2);
    }

    /**
     * Test hash code.
     */
    @Test
    void testHashCode() {
        Role role = new Role("Manager");
        Role role1 = new Role("Manager");
        Role role2 = new Role("Agent");
        assertEquals(role.hashCode(), role1.hashCode());
        assertNotEquals(role.hashCode(), role2.hashCode());
    }

    /**
     * Test clone.
     */
    @Test
    void testClone() {
        Role role = new Role("Manager");
        Role role1 = role.clone();
        assertEquals(role, role1);
    }
}