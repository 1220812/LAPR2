package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.AvailableEquipment;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AvailableEquipmentRepositoryTest {

    @Test
    void add() {
        AvailableEquipmentRepository repo = new AvailableEquipmentRepository();
        AvailableEquipment equipment = new AvailableEquipment("Central heating");
        Optional<AvailableEquipment> result = repo.add(equipment);
        assertTrue(result.isPresent());
        assertEquals(equipment, result.get());
        List<AvailableEquipment> list = repo.getAvailableEquipmentList();
        assertTrue(list.contains(equipment));
    }

    @Test
    void validateAvailableEquipment() {
        AvailableEquipmentRepository repo = new AvailableEquipmentRepository();
        AvailableEquipment equipment = new AvailableEquipment("Central heating");
        repo.add(equipment);
        assertFalse(repo.validateAvailableEquipment(equipment));
    }

    @Test
    void getAvailableEquipmentList() {
        AvailableEquipmentRepository repo = new AvailableEquipmentRepository();
        AvailableEquipment equipment = new AvailableEquipment("Central heating");
        repo.add(equipment);
        List<AvailableEquipment> list = repo.getAvailableEquipmentList();
        assertTrue(list.contains(equipment));
    }
}