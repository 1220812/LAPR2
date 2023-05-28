package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
public class Order {
    /**
     * age of the order
     */
    public int age;
    /**
     * the amount of the order
     */
    public ArrayList<Double> amount = new ArrayList<>();
    /**
     * code of the property that is being ordered
     */
    public String propertyCode;
    /**
     * Instantiates a new order with the propertyCode code and the age of the order
     * @param propertyCode the property code
     * @param age the age of the order
     */
    public Order(String propertyCode, int age) {
        this.age = age;
        this.propertyCode = propertyCode;
    }
    /**
     * empty order constructor
     */
    public Order(){
    }
    /**
     * This method returns the age of the order
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * This method returns the amount of the order
     * @return the amount of the order
     */
    public ArrayList<Double> getAmount() {
        return this.amount;
    }
    /**
     * This method shows the property code
     * @return property code
     */
    public String getPropertyCode() {
        return propertyCode;
    }
    /**
     * Method to change the age of the order
     * @param age changed value of age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Method to change the amount of the order
     * @param amount changed value of amount
     */
    public void setAmount(ArrayList<Double> amount) {
        this.amount = amount;
    }
    /**
     * Method to change the property code
     * @param propertyCode changed value of property code
     */
    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }
}