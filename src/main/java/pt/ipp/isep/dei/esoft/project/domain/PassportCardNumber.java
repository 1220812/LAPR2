package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

public class PassportCardNumber implements Serializable {
    /**
     * passport card number
     */
    private String passportCardNumber;

    /**
     * This method creates the PassportCardNumber with passportCardNumber
     *
     * @param passportCardNumber passport card number
     */
    public PassportCardNumber(String passportCardNumber) {
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
     * Compares two instances of passport card number
     * @param o other instance of passport card number
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassportCardNumber that = (PassportCardNumber) o;
        return Objects.equals(passportCardNumber, that.passportCardNumber);
    }

    /**
     * Hashcode of passport card number
     * @return hashcode of passport card number
     */

    @Override
    public int hashCode() {
        return Objects.hash(passportCardNumber);
    }
    /**
     * Textual representation of an instance of Address
     */
    @Override
    public String toString() {
        return passportCardNumber;
    }

    /**
     * This method creates a clone of the passport card number
     * @return clone of the passport card number
     */
    public PassportCardNumber clone(){
        return new PassportCardNumber(this.passportCardNumber);
    }
}