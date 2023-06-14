package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void getDescription() {
        Role role = new Role("Manager");
        assertEquals("Manager", role.getDescription());
    }

    @Test
    void setDescription() {
        Role role = new Role("Manager");
        assertEquals("Manager", role.getDescription());
        role.setDescription("Agent");
        assertEquals("Agent", role.getDescription());
    }

    @Test
    void testEquals() {
        Role role = new Role("Manager");
        Role role1 = new Role("Manager");
        Role role2 = new Role("Agent");
        assertEquals(role, role1);
        assertNotEquals(role, role2);
    }

    @Test
    void testHashCode() {
        Role role = new Role("Manager");
        Role role1 = new Role("Manager");
        Role role2 = new Role("Agent");
        assertEquals(role.hashCode(), role1.hashCode());
        assertNotEquals(role.hashCode(), role2.hashCode());
    }

    @Test
    void testClone() {
        Role role = new Role("Manager");
        Role role1 = role.clone();
        assertEquals(role, role1);
    }
}