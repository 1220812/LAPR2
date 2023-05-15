package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class PassportCardNumber {
    /**
     * passport card number
     */
    private String passportCardNumber;
    /**
     * passport card number length
     */
    private static final int PASSPORT_NUMBER_LENGTH = 8;

    /**
     * This method creates the PassportCardNumber with passportCardNumber
     *
     * @param passportCardNumber passport card number
     */
    public PassportCardNumber(String passportCardNumber) {
        if(passportCardNumber.length() != PASSPORT_NUMBER_LENGTH || !StringUtils.isNumeric(passportCardNumber)){
            throw new IllegalArgumentException("Invalid passport card number");
        }
        this.passportCardNumber = passportCardNumber;
    }
    /**
     * This method shows the passportNumber of the PassportCard
     * @return passport card number
     */
    public String getPassportCardNumber() {
        return passportCardNumber;
    }
    /**
     * This method changes the passportNumber of the PassportCard
     * @param passportCardNumber changed passport card number
     */
    public void setPassportCardNumber(String passportCardNumber) {
        this.passportCardNumber = passportCardNumber;
    }
    /**
     * Compares two instances of Owner
     * @param o other instance of Owner
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassportCardNumber that = (PassportCardNumber) o;
        return Objects.equals(passportCardNumber, that.passportCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportCardNumber);
    }
    /**
     * Textual representation of an instance of Address
     */
    @Override
    public String toString() {
        return " | Passport Card Number: " + passportCardNumber;
    }
}