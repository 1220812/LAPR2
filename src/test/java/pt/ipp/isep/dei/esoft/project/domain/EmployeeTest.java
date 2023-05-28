/**package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructor() {
        Employee employee = new Employee("João Manuel", "João@example.com", 123456789, 98765432, 1234567, "123 Main St", "Store manager", "agency2", "store3", "password");
        assertNotNull(employee);
        assertEquals("João Manuel", employee.getName());
        assertEquals("João@example.com", employee.getEmail());
        assertEquals(123456789, employee.getPhoneNumber());
        assertEquals(98765432, employee.getPassportCardNumber());
        assertEquals(1234567, employee.getTaxNumber());
        assertEquals("123 Main St", employee.getAddress());
        assertEquals("Store manager", employee.getRole());
        assertEquals("agency2", employee.getAgency());
        assertEquals("store3", employee.getStore());
        assertEquals("password", employee.getPass());
    }

    @Test
    public void testEmployeeDefaultConstructor() {
        Employee employee = new Employee();
        assertNotNull(employee);
        assertEquals("No name", employee.getName());
        assertEquals("No email", employee.getEmail());
        assertEquals(0, employee.getPhoneNumber());
        assertEquals(0, employee.getPassportCardNumber());
        assertEquals(0, employee.getTaxNumber());
        assertEquals("No passport", employee.getAddress());
        assertEquals("No role", employee.getRole());
        assertEquals("No agency", employee.getAgency());
        assertEquals("No store", employee.getStore());
        assertEquals("No password", employee.getPass());
    }

    @Test
    public void testEmployeeNewEmployeeMethod() {
        Employee employee = Employee.newEmployee("António Carlos", "António@example.com", 987654321, 12345678, 98765, "123 Main St", "Store manager", "agency4", "store1", "password123");
        assertNotNull(employee);
        assertEquals("António Carlos", employee.getName());
        assertEquals("António@example.com", employee.getEmail());
        assertEquals(987654321, employee.getPhoneNumber());
        assertEquals(12345678, employee.getPassportCardNumber());
        assertEquals(98765, employee.getTaxNumber());
        assertEquals("456 Main St", employee.getAddress());
        assertEquals("Salesperson", employee.getRole());
        assertEquals("agency4", employee.getAgency());
        assertEquals("store1", employee.getStore());
        assertEquals("password123", employee.getPass());
    }

    @Test
    public void testEmployeeSetters() {
        Employee employee = new Employee();
        employee.setName("Carlos Monteiro");
        employee.setEmail("Carlos@example.com");
        employee.setPhoneNumber(123456789);
        employee.setPassportCardNumber(98765432);
        employee.setTaxNumber(1234567);
        employee.setAddress("123 St");
        employee.setRole("System Administrator");
        employee.setAgency("agency4");
        employee.setStore("store3");
        employee.setPass("password");
        assertNotNull(employee);
        assertEquals("Carlos Monteiro", employee.getName());
        assertEquals("Carlos@example.com", employee.getEmail());
        assertEquals(123456789, employee.getPhoneNumber());
        assertEquals(98765432, employee.getPassportCardNumber());
        assertEquals(1234567, employee.getTaxNumber());
        assertEquals("123 St", employee.getAddress());
        assertEquals("System Administrator", employee.getRole());
        assertEquals("agency4", employee.getAgency());
        assertEquals("store3", employee.getStore());
        assertEquals("password", employee.getPass());
    }

}*/