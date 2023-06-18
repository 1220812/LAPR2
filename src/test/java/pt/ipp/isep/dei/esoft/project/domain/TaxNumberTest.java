package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Tax number test.
 */
class TaxNumberTest {
    /**
     * Test get tax number.
     */
    @Test
    public void testGetTaxNumber() {
        TaxNumber taxNumber = new TaxNumber("123456789");
        assertEquals("123456789", taxNumber.getTaxNumber());
    }

    /**
     * Test set tax number.
     */
    @Test
    public void testSetTaxNumber() {
        TaxNumber taxNumber = new TaxNumber("123456789");
        taxNumber.setTaxNumber("987654321");
        assertEquals("987654321", taxNumber.getTaxNumber());
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals() {
        TaxNumber taxNumber1 = new TaxNumber("123456789");
        TaxNumber taxNumber2 = new TaxNumber("123456789");
        TaxNumber taxNumber3 = new TaxNumber("987654321");

        assertTrue(taxNumber1.equals(taxNumber2));
        assertFalse(taxNumber1.equals(taxNumber3));
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        TaxNumber taxNumber = new TaxNumber("123456789");
        assertEquals("123456789", taxNumber.toString());
    }

    /**
     * Test clone.
     */
    @Test
    public void testClone() {
        TaxNumber taxNumber1 = new TaxNumber("123456789");
        TaxNumber taxNumber2 = taxNumber1.clone();

        assertEquals(taxNumber1.getTaxNumber(), taxNumber2.getTaxNumber());
    }
}