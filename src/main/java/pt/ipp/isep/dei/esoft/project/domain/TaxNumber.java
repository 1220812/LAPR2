package pt.ipp.isep.dei.esoft.project.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class TaxNumber {
    /**
     * tax number
     */
    private String taxNumber;
    /**
     * tax number length
     */
    private static final int TAX_NUMBER_LENGTH = 9;

    /**
     * This method creates the TaxNumber with tax number
     *
     * @param taxNumber tax number
     */
    public TaxNumber(String taxNumber) {
        if(taxNumber.length() != TAX_NUMBER_LENGTH || !StringUtils.isNumeric(taxNumber)){
            throw new IllegalArgumentException("Invalid passport card number");
        }
        this.taxNumber = taxNumber;
    }
    /**
     * This method shows the tax number
     * @return tax number
     */
    public String getTaxNumber() {
        return taxNumber;
    }
    /**
     * This method changes the tax number
     * @param taxNumber changed tax number
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Compares two instances of tax number
     * @param o other instance of tax number
     * @return true if the instances are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxNumber taxNumber1 = (TaxNumber) o;
        return Objects.equals(taxNumber, taxNumber1.taxNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxNumber);
    }

    /**
     * Textual representation of an instance of TaxNumber
     */
    @Override
    public String toString() {
        return taxNumber;
    }

    /**
     * This method clones an instance of TaxNumber
     * @return cloned TaxNumber
     */

    public TaxNumber clone(){
        return new TaxNumber(this.taxNumber);
    }
}