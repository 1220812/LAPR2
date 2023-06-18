package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The type Password generator test.
 */
public class PasswordGeneratorTest {

    /**
     * Test generate password.
     */
    @Test
    public void testGeneratePassword() {
        String password = PasswordGenerator.generatePassword();

        Assertions.assertEquals(7, password.length());

        Assertions.assertTrue(password.matches(".*[A-Z].*"));

        Assertions.assertTrue(password.matches(".*\\d.*\\d.*"));

        Assertions.assertTrue(password.matches(".*[a-z].*[a-z].*"));
    }
}
