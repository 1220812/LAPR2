package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvailableEquipmentTest {

        @Test
        public void testGetEquipment() {
            AvailableEquipment equipment = new AvailableEquipment("Pool");
            assertEquals("Pool", equipment.getEquipment());
        }

        @Test
        public void testSetEquipment() {
            AvailableEquipment equipment = new AvailableEquipment("Pool");
            equipment.setEquipment("Oven");
            assertEquals("Oven", equipment.getEquipment());
        }

        @Test
        public void testToString() {
            AvailableEquipment equipment = new AvailableEquipment("Microwave");
            assertEquals("Microwave", equipment.toString());
        }

        @Test
        public void testEquals() {
            AvailableEquipment equipment1 = new AvailableEquipment("Microwave");
            AvailableEquipment equipment2 = new AvailableEquipment("Microwave");
            AvailableEquipment equipment3 = new AvailableEquipment("Oven");

            assertTrue(equipment1.equals(equipment2));
            assertFalse(equipment1.equals(equipment3));
        }

        @Test
        public void testClone() {
            AvailableEquipment equipment1 = new AvailableEquipment("Fridge");
            AvailableEquipment equipment2 = equipment1.clone();

            assertEquals(equipment1.getEquipment(), equipment2.getEquipment());
        }
}