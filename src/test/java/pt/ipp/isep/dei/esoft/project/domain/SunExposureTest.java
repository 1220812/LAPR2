package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SunExposureTest {
    @Test
    public void testGetSunExposure() {
        SunExposure sunExposure = new SunExposure("North");
        assertEquals("North", sunExposure.getSunExposure());
    }

    @Test
    public void testSetSunExposure() {
        SunExposure sunExposure = new SunExposure("North");
        sunExposure.setSunExposure("South");
        assertEquals("South", sunExposure.getSunExposure());
    }

    @Test
    public void testEquals() {
        SunExposure sunExposure1 = new SunExposure("East");
        SunExposure sunExposure2 = new SunExposure("East");
        assertEquals(sunExposure1, sunExposure2);
    }

    @Test
    public void testClone() {
        SunExposure sunExposure = new SunExposure("West");
        SunExposure clonedSunExposure = sunExposure.clone();
        assertEquals(sunExposure, clonedSunExposure);
    }
}