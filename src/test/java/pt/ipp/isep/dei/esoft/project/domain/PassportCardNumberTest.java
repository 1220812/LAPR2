package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The type Passport card number test.
 */
public class PassportCardNumberTest {

    /**
     * Test get passport card number.
     */
    @Test
    public void testGetPassportCardNumber() {
        String passportNumber = "AB123456";

        PassportCardNumber passportCardNumber = new PassportCardNumber(passportNumber);

        Assertions.assertEquals(passportNumber, passportCardNumber.getPassportCardNumber());
    }

    /**
     * Test set passport card number.
     */
    @Test
    public void testSetPassportCardNumber() {
        String initialPassportNumber = "AB123456";
        String newPassportNumber = "CD987654";

        PassportCardNumber passportCardNumber = new PassportCardNumber(initialPassportNumber);
        passportCardNumber.setPassportCardNumber(newPassportNumber);

        Assertions.assertEquals(newPassportNumber, passportCardNumber.getPassportCardNumber());
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals() {
        String passportNumber1 = "AB123456";
        String passportNumber2 = "CD987654";
        String passportNumber3 = "AB123456";

        PassportCardNumber passportCardNumber1 = new PassportCardNumber(passportNumber1);
        PassportCardNumber passportCardNumber2 = new PassportCardNumber(passportNumber2);
        PassportCardNumber passportCardNumber3 = new PassportCardNumber(passportNumber3);

        Assertions.assertEquals(passportCardNumber1, passportCardNumber3);

        Assertions.assertNotEquals(passportCardNumber1, passportCardNumber2);
    }

    /**
     * Test hash code.
     */
    @Test
    public void testHashCode() {
        String passportNumber1 = "AB123456";
        String passportNumber2 = "CD987654";

        PassportCardNumber passportCardNumber1 = new PassportCardNumber(passportNumber1);
        PassportCardNumber passportCardNumber2 = new PassportCardNumber(passportNumber2);

        Assertions.assertNotEquals(passportCardNumber1.hashCode(), passportCardNumber2.hashCode());

        PassportCardNumber passportCardNumber3 = new PassportCardNumber(passportNumber1);
        Assertions.assertEquals(passportCardNumber1.hashCode(), passportCardNumber3.hashCode());
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String passportNumber = "AB123456";

        PassportCardNumber passportCardNumber = new PassportCardNumber(passportNumber);

        Assertions.assertEquals(passportNumber, passportCardNumber.toString());
    }

    /**
     * Test clone.
     */
    @Test
    public void testClone() {
        String passportNumber = "AB123456";

        PassportCardNumber passportCardNumber = new PassportCardNumber(passportNumber);
        PassportCardNumber clonedPassportCardNumber = passportCardNumber.clone();

        Assertions.assertNotSame(passportCardNumber, clonedPassportCardNumber);
        Assertions.assertEquals(passportCardNumber, clonedPassportCardNumber);
    }
}
