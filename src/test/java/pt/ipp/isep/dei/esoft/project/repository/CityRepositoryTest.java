package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.City;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityRepositoryTest {

    @Test
    void validateCity() {
        CityRepository cityRepository = Repositories.getInstance().getCityRepository();
        City city = new City("Porto");
        boolean isValid = cityRepository.validateCity(city);
        assertTrue(isValid);
        cityRepository.addCity(city);
        assertTrue(cityRepository.validateCity(city));
    }

    @Test
    void getCityList() {
        CityRepository cityRepository = Repositories.getInstance().getCityRepository();
        City city = new City("Porto");
        cityRepository.add(city);
        List<City> cities = cityRepository.getCityList();
        assertNotSame(cities, cityRepository.getCityList());
        assertTrue(cities.contains(city));
    }

    @Test
    void createCity() {
        CityRepository cityRepository = Repositories.getInstance().getCityRepository();
        Optional<City> city = cityRepository.addCity(cityRepository.CreateCity("Porto"));
        assertTrue(city.isPresent());
        List<City> cities = cityRepository.getCityList();
        assertTrue(cities.contains(city.get()));
    }
}