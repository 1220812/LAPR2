package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyRepository {
    /**
     * Creates a list of properties
     */
    private final List<Property> properties = new ArrayList<>();
    /**
     * Method to add a property to the list
     * @param property property to be added
     * @return the property added to the list
     */
    public Optional<Property> add(Property property){

            Optional<Property> newProperty = Optional.empty();
            boolean operationSuccess = false;

            if(validateProperty(property)){
                newProperty = Optional.of(property.clone());
                operationSuccess = properties.add(newProperty.get());
            }
            if(!operationSuccess){
                newProperty = Optional.empty();
            }
            return newProperty;
    }
    /**
     * Creates a land property
     * @param area area of the property
     * @param address address of the property
     * @param propertyType propertyType of the property
     * @return the property created
     */
    public Optional <Property> createLand(double area, double distanceFromTheCityCentre, Address address, PropertyType propertyType, List<Photographs> photographsList){
        Optional<Property> optionalValue = Optional.empty();

        Property property = new Property(area, distanceFromTheCityCentre, address, propertyType, photographsList);
        if(addProperty(property)){
            optionalValue = Optional.of(property);
        }
        return optionalValue;
    }

    /**
     * Creates an apartment property
     * @param area area of the property
     * @param address address of the property
     * @param propertyType propertyType of the property
     * @param numberOfBedrooms number of bedrooms
     * @param numberOfBathrooms number of bathrooms
     * @param numberOfParkingSpaces number of parking spaces
     * @param centralHeating central heating
     * @param airConditioning air conditioning
     * @return the property created
     */
    public Optional <Property> createApartment(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, PropertyType propertyType, List<Photographs> photographsList, boolean centralHeating, boolean airConditioning){
        Optional<Property> optionalValue = Optional.empty();

        Residence apartment = new Residence(address, area, distanceFromCityCentre, propertyType ,numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, photographsList, centralHeating, airConditioning);
        if(addProperty(apartment)){
            optionalValue = Optional.of(apartment);
        }
        return optionalValue;
    }
    /**
     * Creates a house property
     * @param address address of the property
     * @param area  area of the property
     * @param distanceFromCityCentre distance from the city center
     * @param numberOfBathrooms     number of bathrooms
     * @param numberOfBedrooms     number of bedrooms
     * @param numberOfParkingSpaces    number of parking spaces
     * @param airConditioning    air conditioning
     * @param centralHeating    central heating
     * @param basement   basement
     * @param sunExposure  sun exposure
     * @param inhabitableLoft  inhabitable loft
     * @param photoList list of photographs
     * @return the property created
     */
    public Optional<Property> createHouse(Address address, double area, double distanceFromCityCentre, int numberOfBathrooms, int numberOfBedrooms, int numberOfParkingSpaces, boolean airConditioning , boolean centralHeating , boolean basement, SunExposure sunExposure, boolean inhabitableLoft, PropertyType propertyType, List<Photographs> photoList){
        Optional<Property> optionalValue = Optional.empty();
        House house = new House(address, area, distanceFromCityCentre, propertyType, numberOfBathrooms, numberOfBedrooms, numberOfParkingSpaces, airConditioning, centralHeating, basement, sunExposure, inhabitableLoft, photoList);
        if(addProperty(house)){
            optionalValue = Optional.of(house);
        }
        return optionalValue;
    }
    /**
     * Verifies if a property is on the list
     * @param property property to be verified
     * @return if the property isn´t on the list
     */
    public boolean validateProperty(Property property){
        return !properties.contains(property);
    }
    /**
     * This method validates the property and adds it to the list if it's validated
     * @param property property
     * @return true if the property is added to the list, false if it isn't
     */
    public boolean addProperty(Property property){
        boolean addProperty = false;
        if(validateProperty(property)){
            addProperty = properties.add(property);
        }
        return addProperty;
    }
    public List<Property> getProperties(){
        return List.copyOf(properties);
    }
}