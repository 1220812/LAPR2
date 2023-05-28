package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Message;

import java.time.LocalDate;

class MessageTest {

    @Test
    void testCreateDate_ValidDate_ReturnsLocalDate() {
        LocalDate expectedDate = LocalDate.of(2023, 5, 28);
        LocalDate actualDate = Message.createDate(28, 5, 2023);
        Assertions.assertEquals(expectedDate, actualDate);
    }

    @Test
    void testCreateDate_InvalidDate_ReturnsNull() {
        LocalDate actualDate = Message.createDate(32, 13, 2022);
        Assertions.assertNull(actualDate);
    }

    @Test
    void testCheckDay_ValidDay_ReturnsTrue() {
        boolean result = Message.checkDay(15);
        Assertions.assertTrue(result);
    }

    @Test
    void testCheckDay_InvalidDay_ReturnsFalse() {
        boolean result = Message.checkDay(0);
        Assertions.assertFalse(result);
    }

    @Test
    void testCheckMonth_ValidMonth_ReturnsTrue() {
        boolean result = Message.checkMonth(6);
        Assertions.assertTrue(result);
    }

    @Test
    void testCheckMonth_InvalidMonth_ReturnsFalse() {
        boolean result = Message.checkMonth(13);
        Assertions.assertFalse(result);
    }

    @Test
    void testCheckYear_ValidYear_ReturnsTrue() {
        boolean result = Message.checkYear(2023);
        Assertions.assertTrue(result);
    }

    @Test
    void testCheckYear_InvalidYear_ReturnsFalse() {
        boolean result = Message.checkYear(2022);
        Assertions.assertFalse(result);
    }

    @Test
    void testCheckHour_ValidHour_ReturnsTrue() {
        boolean result = Message.checkHour(12);
        Assertions.assertTrue(result);
    }

    @Test
    void testCheckHour_InvalidHour_ReturnsFalse() {
        boolean result = Message.checkHour(25);
        Assertions.assertFalse(result);
    }

    @Test
    void testCheckMinute_ValidMinute_ReturnsTrue() {
        boolean result = Message.checkMinute(30);
        Assertions.assertTrue(result);
    }

    @Test
    void testCheckMinute_InvalidMinute_ReturnsFalse() {
        boolean result = Message.checkMinute(61);
        Assertions.assertFalse(result);
    }
}
