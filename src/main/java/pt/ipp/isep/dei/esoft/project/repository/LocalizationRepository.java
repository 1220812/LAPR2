package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Localization;

import java.util.ArrayList;
import java.util.List;

public class LocalizationRepository {
    private static List<Localization> localizationList;
    public LocalizationRepository(){
        localizationList = new ArrayList<>();
    }
    public List<Localization> getLocationList(){
        return localizationList;
    }
    public static void registerLocation(Localization localization){
        localizationList.add(localization);
    }
    public static Localization createLocation(String street, String doorNumber, String floorNumber, String postalCode, String city, String district, String state){
        Localization localization = new Localization(street, doorNumber,floorNumber, postalCode,city, district,state);
        registerLocation(localization);
        return localization;
}

}