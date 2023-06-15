package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.District;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DistrictRepositoryTest {

    @Test
    void addDistrict() {
        DistrictRepository districtRepository = new DistrictRepository();
        District district = new District("East");
        districtRepository.addDistrict(district);
        List<District> districts = districtRepository.getDistrictList();
        assertTrue(districts.contains(district));
    }

    @Test
    void validateDistrict() {
        DistrictRepository districtRepository = new DistrictRepository();
        District district = new District("East");
        assertTrue(districtRepository.validateDistrict(district));
    }

    @Test
    void getDistrictList() {
        DistrictRepository districtRepository = new DistrictRepository();
        District district = new District("East");
        districtRepository.addDistrict(district);
        List<District> districts = districtRepository.getDistrictList();
        assertTrue(districts.contains(district));
    }
}