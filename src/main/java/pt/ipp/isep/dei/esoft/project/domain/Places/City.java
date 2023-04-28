package pt.ipp.isep.dei.esoft.project.domain.Places;

import java.util.Objects;

public class City extends District {

    private String cityName;
    private static final String CITY_NAME_POR_OMISSAO = "without city name";

    public City(String cityName, String name, String date, String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String district) {
        super(name, date, designation, area, distanceCityCenter, price, typeOfProperty, district);
        this.cityName = cityName;
    }

    public City() {
        super();
        this.cityName = CITY_NAME_POR_OMISSAO;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City: \n" +
                "Name - " + cityName + ";\n";
    }

}
