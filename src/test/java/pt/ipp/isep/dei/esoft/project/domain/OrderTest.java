package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order = new Order();
    /**
     * Method to test the getAge method
     */
    @Test
    void getAge() {
        // Arrange
        int expectedAge = 5;
        order.setAge(expectedAge);
        // Act
        int age = order.getAge();
        // Assert
        Assertions.assertEquals(expectedAge, age);
    }
    /**
     * Method to test the getAmount method
     */
    @Test
    void getAmount() {
        // Arrange
        List<Double> expectedAmounts = Arrays.asList(10.0, 20.0, 30.0);
        order.setAmount(new ArrayList<>(expectedAmounts));
        // Act
        ArrayList<Double> amounts = order.getAmount();
        // Assert
        Assertions.assertEquals(expectedAmounts, amounts);
    }
    /**
     * Method to test the getPropertyCode method
     */
    @Test
    void getPropertyCode() {
        // Arrange
        String expectedPropertyCode = "ABC123";
        order.setPropertyCode(expectedPropertyCode);
        // Act
        String propertyCode = order.getPropertyCode();
        // Assert
        Assertions.assertEquals(expectedPropertyCode, propertyCode);
    }
    /**
     * Method to test the setAge method
     */
    @Test
    void setAge() {
        // Arrange
        int newAge = 7;
        // Act
        order.setAge(newAge);
        // Assert
        Assertions.assertEquals(newAge, order.getAge());
    }
    /**
     * Method to test the setAmount method
     */
    @Test
    void setAmount() {
        // Arrange
        List<Double> newAmounts = Arrays.asList(50.0, 60.0);
        // Act
        order.setAmount(new ArrayList<>(newAmounts));
        // Assert
        Assertions.assertEquals(newAmounts, order.getAmount());
    }
    /**
     * Method to test the setPropertyCode method
     */
    @Test
    void setPropertyCode() {
        // Arrange
        String newPropertyCode = "SAM";
        // Act
        order.setPropertyCode(newPropertyCode);
        // Assert
        Assertions.assertEquals(newPropertyCode, order.getPropertyCode());
    }
}