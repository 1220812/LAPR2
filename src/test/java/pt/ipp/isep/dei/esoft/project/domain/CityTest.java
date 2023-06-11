package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    public void testGetName() {
        City city = new City("New York");
        assertEquals("New York", city.getName());
    }

    @Test
    public void testSetName() {
        City city = new City();
        city.setName("London");
        assertEquals("London", city.getName());
    }

    @Test
    public void testToString() {
        City city = new City("Paris");
        assertEquals("Paris", city.toString());
    }

    @Test
    public void testClone() {
        City city1 = new City("Tokyo");
        City city2 = city1.clone();
        assertEquals(city1.getName(), city2.getName());
    }
}