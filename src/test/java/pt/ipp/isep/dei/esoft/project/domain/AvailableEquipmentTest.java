package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Available equipment test.
 */
class AvailableEquipmentTest {

    /**
     * Test get equipment.
     */
    @Test
        public void testGetEquipment() {
            AvailableEquipment equipment = new AvailableEquipment("Pool");
            assertEquals("Pool", equipment.getEquipment());
        }

    /**
     * Test set equipment.
     */
    @Test
        public void testSetEquipment() {
            AvailableEquipment equipment = new AvailableEquipment("Pool");
            equipment.setEquipment("Oven");
            assertEquals("Oven", equipment.getEquipment());
        }

    /**
     * Test to string.
     */
    @Test
        public void testToString() {
            AvailableEquipment equipment = new AvailableEquipment("Microwave");
            assertEquals("Microwave", equipment.toString());
        }

    /**
     * Test equals.
     */
    @Test
        public void testEquals() {
            AvailableEquipment equipment1 = new AvailableEquipment("Microwave");
            AvailableEquipment equipment2 = new AvailableEquipment("Microwave");
            AvailableEquipment equipment3 = new AvailableEquipment("Oven");

            assertTrue(equipment1.equals(equipment2));
            assertFalse(equipment1.equals(equipment3));
        }

    /**
     * Test clone.
     */
    @Test
        public void testClone() {
            AvailableEquipment equipment1 = new AvailableEquipment("Fridge");
            AvailableEquipment equipment2 = equipment1.clone();

            assertEquals(equipment1.getEquipment(), equipment2.getEquipment());
        }
}