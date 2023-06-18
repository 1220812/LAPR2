package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.PropertyType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Property type repository test.
 */
class PropertyTypeRepositoryTest {

    /**
     * Validate property type.
     */
    @Test
    void validatePropertyType() {
        PropertyTypeRepository repo = new PropertyTypeRepository();
        PropertyType propType = new PropertyType("House");
        boolean result = repo.validatePropertyType(propType);
        assertTrue(result);
    }

    /**
     * Gets property type.
     */
    @Test
    void getPropertyType() {
        PropertyTypeRepository repo = new PropertyTypeRepository();
        PropertyType propType = new PropertyType("House");
        repo.addPropertyType(propType);
        List<PropertyType> propTypeList = repo.getPropertyType();
        assertTrue(propTypeList.contains(propType));
    }
}